package src.main.java.controller.implementation;


import src.main.java.model.implementation.SystemControl;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.SystemControlService;

public class SystemControlController extends GeneralController<SystemControl> {

    private static final SystemControlService SYSTEM_CONTROL_SERVICE = new SystemControlService();

    @Override
    public final GeneralService<SystemControl> getService() {
        return SYSTEM_CONTROL_SERVICE;
    }

}
