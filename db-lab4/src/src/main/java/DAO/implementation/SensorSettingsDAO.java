package src.main.java.DAO.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.model.implementation.SensorSettings;
import src.main.java.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SensorSettingsDAO implements IGeneralDAO<SensorSettings, Integer> {

    private static final String GET_ALL = "SELECT * FROM my_db.sensor_settings";
    private static final String GET_BY_ID = "SELECT * FROM my_db.sensor_settings WHERE id=?";
    private static final String CREATE = "INSERT my_db.sensor_settings"
            + "(id, sensor_range, sensor_resolution, system_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE my_db.sensor_settings"
            + " SET sensor_range=?, sensor_resolution=?, system_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM my_db.sensor_settings WHERE id=?";

    @Override
    public final List<SensorSettings> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<SensorSettings> sensorsettings = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Double sensorRange = resultSet.getDouble(2);
                    Double sensorResolution = resultSet.getDouble(3);
                    Integer systemId = resultSet.getInt(4);
                    sensorsettings.add(new SensorSettings(id, sensorRange, sensorResolution, systemId));
                }
            }
        }
        return sensorsettings;
    }

    @Override
    public final SensorSettings getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        SensorSettings sensorSetting = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Double sensorRange = resultSet.getDouble(2);
                    Double sensorResolution = resultSet.getDouble(3);
                    Integer systemId = resultSet.getInt(4);
                    sensorSetting = new SensorSettings(foundId, sensorRange, sensorResolution, systemId);
                }
            }
        }

        return sensorSetting;
    }

    @Override
    public final int create(final SensorSettings entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setDouble(2, entity.getSensorRange());
            ps.setDouble(3, entity.getSensorResolution());
            ps.setInt(4, entity.getSystemId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final SensorSettings entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setDouble(2, entity.getSensorRange());
            ps.setDouble(3, entity.getSensorResolution());
            ps.setInt(4, entity.getSystemId());
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

