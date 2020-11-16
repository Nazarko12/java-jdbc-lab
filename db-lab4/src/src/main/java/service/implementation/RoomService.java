package src.main.java.service.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.DAO.implementation.RoomDAO;
import src.main.java.model.implementation.Room;

public class RoomService extends GeneralService<Room> {
    private final IGeneralDAO<Room, Integer> roomDAOImplementation = new RoomDAO();

    @Override
    public final IGeneralDAO<Room, Integer> getDAO() {
        return roomDAOImplementation;
    }
}
