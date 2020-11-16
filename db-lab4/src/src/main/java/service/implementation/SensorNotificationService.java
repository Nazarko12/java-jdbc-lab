package src.main.java.service.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.DAO.implementation.SensorNotificationDAO;
import src.main.java.model.implementation.SensorNotification;

public class SensorNotificationService extends GeneralService<SensorNotification> {
    private final IGeneralDAO <SensorNotification, Integer> sensorNotificationDAOImplementation = new SensorNotificationDAO();

    @Override
    public final IGeneralDAO<SensorNotification, Integer> getDAO() {
        return sensorNotificationDAOImplementation;
    }
}
