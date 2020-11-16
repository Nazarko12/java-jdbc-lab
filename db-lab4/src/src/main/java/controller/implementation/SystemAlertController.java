package src.main.java.controller.implementation;


import src.main.java.model.implementation.SystemAlert;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.SystemAlertService;

public class SystemAlertController extends GeneralController<SystemAlert> {

    private static final SystemAlertService SYSTEM_ALERT_SERVICE = new SystemAlertService();

    @Override
    public final GeneralService<SystemAlert> getService() {
        return SYSTEM_ALERT_SERVICE;
    }

}

