package src.main.java.controller.implementation;


import src.main.java.model.implementation.Room;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.RoomService;

public class RoomController extends GeneralController<Room> {

    private static final RoomService ROOM_SERVICE = new RoomService();

    @Override
    public final GeneralService<Room> getService() {
        return ROOM_SERVICE;
    }

}
