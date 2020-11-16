package src.main.java.DAO.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.model.implementation.SystemAlert;
import src.main.java.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SystemAlertDAO implements IGeneralDAO<SystemAlert, Integer> {

    private static final String GET_ALL = "SELECT * FROM my_db.system_alert";
    private static final String GET_BY_ID = "SELECT * FROM my_db.system_alert WHERE id=?";
    private static final String CREATE = "INSERT my_db.system_alert"
            + "(id, many_notifications, texts_notifications, about_processings, system_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE my_db.system_alert"
            + " SET many_notifications=?, texts_notifications=?, about_processings=?, system_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM my_db.system_alert WHERE id=?";

    @Override
    public final List<SystemAlert> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<SystemAlert> systemAlerts = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    int manyNotifications = resultSet.getInt(2);
                    String textsNotifications = resultSet.getString(3);
                    String aboutProcessings = resultSet.getString(4);
                    Integer systemId = resultSet.getInt(5);
                    systemAlerts.add(new SystemAlert(id, manyNotifications, textsNotifications,
                            aboutProcessings, systemId));
                }
            }
        }
        return systemAlerts;
    }

    @Override
    public final SystemAlert getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        SystemALert systemALert = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    int manyNotifications = resultSet.getInt(2);
                    String textsNotifications = resultSet.getString(3);
                    String aboutProcessings = resultSet.getString(4);
                    Integer systemId = resultSet.getInt(5);
                    systemAlert = new SystemAlert(foundId, manyNotifications, textsNotifications,
                            aboutProcessings, systemId);
                }
            }
        }

        return systemALert;
    }

    @Override
    public final int create(final SystemAlert entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getManyNotifications());
            ps.setString(3, entity.getTextsNotifications());
            ps.setString(4, entity.getAboutProcessings());
            ps.setInt(5, entity.getSystemId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final SystemAlert entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getManyNotifications());
            ps.setString(3, entity.getTextsNotifications());
            ps.setString(4, entity.getAboutProcessings());
            ps.setInt(5, entity.getSystemId());
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

