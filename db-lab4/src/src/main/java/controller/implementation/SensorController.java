package src.main.java.controller.implementation;


import src.main.java.model.implementation.Sensor;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.SensorService;

public class SensorController extends GeneralController<Sensor> {

    private static final SensorService SENSOR_SERVICE = new SensorService();

    @Override
    public final GeneralService<Sensor> getService() {
        return SENSOR_SERVICE;
    }

}
