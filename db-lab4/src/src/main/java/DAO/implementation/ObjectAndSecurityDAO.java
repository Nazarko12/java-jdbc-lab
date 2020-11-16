package src.main.java.DAO.implementation;

import src.main.java.DAO.IGeneralDAO;
import src.main.java.model.implementation.ObjectAndSecurity;
import src.main.java.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ObjectAndSecurityDAO implements IGeneralDAO<ObjectAndSecurity, Integer> {

    private static final String GET_ALL = "SELECT * FROM my_db.object";
    private static final String GET_BY_ID = "SELECT * FROM my_db.object WHERE id=?";
    private static final String CREATE = "INSERT my_db.object "
            + "(id, loctaion) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE my_db.object"
            + " SET location=? WHERE id=?";
    private static final String DELETE = "DELETE FROM my_db.object WHERE id=?";

    @Override
    public final List<ObjectAndSecurity> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<ObjectAndSecurity> objectsAndSecurity = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String location = resultSet.getString(2);
                    objectsAndSecurity.add(new ObjectAndSecurity(id, location));
                }
            }
        }
        return objectsAndSecurity;
    }

    @Override
    public final ObjectAndSecurity getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        ObjectAndSecurity objectAndSecurity = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String location = resultSet.getString(2);
                    objectAndSecurity = new ObjectAndSecurity(foundId, location);
                }
            }
        }

        return objectAndSecurity;
    }

    @Override
    public final int create(final ObjectAndSecurity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLocation());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final ObjectAndSecurity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLocation());
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