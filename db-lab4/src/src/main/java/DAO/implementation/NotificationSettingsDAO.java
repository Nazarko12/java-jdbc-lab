package src.main.java.DAO.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.model.implementation.NotificationSettings;
import src.main.java.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class NotificationSettingsDAO implements IGeneralDAO<NotificationSettings, Integer> {

    private static final String GET_ALL = "SELECT * FROM my_db.notification_settings";
    private static final String GET_BY_ID = "SELECT * FROM my_db.notification_settings WHERE id=?";
    private static final String CREATE = "INSERT my_db.notification_settings"
            + "(id, control_access_level, system_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE my_db.notification_settings"
            + " SET control_access_level=?, system_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM my_db.notification_settings WHERE id=?";

    @Override
    public final List<NotificationSettings> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<NotificationSettings> notificationSettings = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    double controlAccessLevel = resultSet.getDouble(2);
                    Integer systemId = resultSet.getInt(3);
                    notificationSettings.add(new NotificationSettings(id, controlAccessLevel,  systemId));
                }
            }
        }
        return notificationSettings;
    }

    @Override
    public final NotificationSettings getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        NotificationSettings  notificationSetting = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    double controlAccessLevel = resultSet.getDouble(2);
                    Integer systemId = resultSet.getInt(3);
                    notificationSetting = new NotificationSettings(foundId, controlAccessLevel, systemId);
                }
            }
        }

        return notificationSetting;
    }

    @Override
    public final int create(final NotificationSettings entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setDouble(2, entity.getControlAccessLevel());
            ps.setInt(3, entity.getSystemId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final NotificationSettings entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setDouble(2, entity.getControlAccessLevel());
            ps.setInt(3, entity.getSystemId());
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