package src.main.java.controller.implementation;


import src.main.java.model.implementation.SensorNotification;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.SensorNotificationService;

public class SensorNotificationController extends GeneralController<SensorNotification> {

    private static final SensorNotificationService SENSOR_NOTIFICATION_SERVICE = new SensorNotificationService();

    @Override
    public final GeneralService<SensorNotification> getService() {
        return SENSOR_NOTIFICATION_SERVICE;
    }

}