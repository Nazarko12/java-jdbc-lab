package src.main.java.DAO.implementation;



import src.main.java.DAO.IGeneralDAO;
import src.main.java.model.implementation.Room;
import src.main.java.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RoomDAO implements IGeneralDAO<Room, Integer> {

    private static final String GET_ALL = "SELECT * FROM my_db.room";
    private static final String GET_BY_ID = "SELECT * FROM my_db.room WHERE id=?";
    private static final String CREATE = "INSERT my_db.room"
            + "(id, name_room, square) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE my_db.room"
            + " SET name_room=?, square=? WHERE id=?";
    private static final String DELETE = "DELETE FROM my_db.room WHERE id=?";

    @Override
    public final List<Room> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Room> rooms = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String nameRoom = resultSet.getString(2);
                    Double square = resultSet.getDouble(3);
                    rooms.add(new Room(id, nameRoom, square));
                }
            }
        }
        return rooms;
    }

    @Override
    public final Room getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
       Room room = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String nameRoom = resultSet.getString(2);
                    Double square = resultSet.getDouble(3);
                    room = new Room(foundId, nameRoom, square);
                }
            }
        }

        return room;
    }

    @Override
    public final int create(final Room entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getNameRoom());
            ps.setDouble(3, entity.getSquare());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Room entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getNameRoom());
            ps.setDouble(3, entity.getSquare());
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
