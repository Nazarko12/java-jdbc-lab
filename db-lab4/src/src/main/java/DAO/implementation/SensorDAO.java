package src.main.java.DAO.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.model.implementation.Sensor;
import src.main.java.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SensorDAO implements IGeneralDAO<Sensor, Integer> {

    private static final String GET_ALL = "SELECT * FROM my_db.sensor";
    private static final String GET_BY_ID = "SELECT * FROM my_db.sensor WHERE id=?";
    private static final String CREATE = "INSERT my_db.sensor"
            + "(id, processing_time, name_model, type, calibration, classification) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE my_db.sensor"
            + " SET processing_time=?,  name_model=?, type=?, calibration=?, classification=? WHERE id=?";
    private static final String DELETE = "DELETE FROM my_db.sensor WHERE id=?";

    @Override
    public final List<Sensor> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Sensor> sensors = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Double processingTime = resultSet.getDouble(2);
                    String nameRoom = resultSet.getString(3);
                    String type = resultSet.getString(3);
                    Integer calibration = resultSet.getInt(3);
                    String classification = resultSet.getString(3);
                    sensors.add(new Sensor(id, processingTime, nameRoom, type, calibration, classification));
                }
            }
        }
        return sensors;
    }

    @Override
    public final Sensor getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Sensor sensor = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Double processingTime = resultSet.getDouble(2);
                    String nameRoom = resultSet.getString(3);
                    String type = resultSet.getString(3);
                    Integer calibration = resultSet.getInt(3);
                    String classification = resultSet.getString(3);
                    sensor = new Sensor(foundId, processingTime, nameRoom, type, calibration, classification);
                }
            }
        }

        return sensor;
    }

    @Override
    public final int create(final Sensor entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setDouble(2, entity.getProcessingTime());
            ps.setString(3, entity.getNameModel());
            ps.setString(3, entity.getType());
            ps.setInt(1, entity.getCalibration());
            ps.setString(3, entity.getClassification());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Sensor entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setDouble(2, entity.getProcessingTime());
            ps.setString(3, entity.getNameModel());
            ps.setString(3, entity.getType());
            ps.setInt(1, entity.getCalibration());
            ps.setString(3, entity.getClassification());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
