package src.main.java.DAO.implementation;
;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.model.implementation.SystemControl;
import src.main.java.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SystemControlDAO implements IGeneralDAO<SystemControl, Integer> {

    private static final String GET_ALL = "SELECT * FROM my_db.system";
    private static final String GET_BY_ID = "SELECT * FROM my_db.system WHERE id=?";
    private static final String CREATE = "INSERT my_db.system"
            + "(id, quantity_control_processings) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE my_db.system"
            + " SET quantity_control_processings=? WHERE id=?";
    private static final String DELETE = "DELETE FROM my_db.system WHERE id=?";

    @Override
    public final List<SystemControl> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<SystemControl> systemsControl = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    int quantityControlProcessings  = resultSet.getInt(2);
                    systemsControl.add(new SystemControl(id, quantityControlProcessings));
                }
            }
        }
        return systemsControl;
    }

    @Override
    public final SystemControl getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        SystemControl systemControl = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    int quantityControlProcessings  = resultSet.getInt(2);
                    systemControl = new SystemControl(foundId, quantityControlProcessings);
                }
            }
        }

        return systemControl;
    }

    @Override
    public final int create(final SystemControl entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getQuantityControlProcessings());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final SystemControl entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getQuantityControlProcessings());
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

