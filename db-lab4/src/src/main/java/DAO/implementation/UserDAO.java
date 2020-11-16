package src.main.java.DAO.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.model.implementation.User;
import src.main.java.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAO implements IGeneralDAO<User, Integer> {

    private static final String GET_ALL = "SELECT * FROM my_db.user";
    private static final String GET_BY_ID = "SELECT * FROM my_db.user WHERE id=?";
    private static final String CREATE = "INSERT my_db.user"
            + "(id, first_name, last_name, country, system_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE my_db.user"
            + " SET first_name=?, last_name=?, country=?, system_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM my_db.user WHERE id=?";

    @Override
    public final List<User> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<User> users = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    String country = resultSet.getString(4);
                    Integer systemId = resultSet.getInt(5);
                    users.add(new User(id, firstName, lastName, country, systemId));
                }
            }
        }
        return users;
    }

    @Override
    public final User getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    String country = resultSet.getString(4);
                    Integer systemId = resultSet.getInt(5);
                    user = new User(foundId, firstName, lastName, country, systemId);
                }
            }
        }

        return user;
    }

    @Override
    public final int create(final User entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getCountry());
            ps.setInt(5, entity.getSystemId());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final User entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getCountry());
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
