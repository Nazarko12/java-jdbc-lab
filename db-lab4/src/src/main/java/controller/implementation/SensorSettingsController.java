package src.main.java.controller.implementation;


import src.main.java.model.implementation.SensorSettings;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.SensorSettingsService;

public class SensorSettingsController extends GeneralController<SensorSettings> {

    private static final SensorSettingsService SENSOR_SETTINGS_SERVICE = new SensorSettingsService();

    @Override
    public final GeneralService<SensorSettings> getService() {
        return SENSOR_SETTINGS_SERVICE;
    }

}