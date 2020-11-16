package src.main.java.controller.implementation;


import src.main.java.model.implementation.AccessLevel;
import src.main.java.service.implementation.AccessLevelService;
import src.main.java.service.implementation.GeneralService;

public class AccessLevelController extends GeneralController<AccessLevel> {
    private static final AccessLevelService ACCESS_LEVEL_SERVICE = new AccessLevelService();

    @Override
    public final GeneralService<AccessLevel> getService() {
        return ACCESS_LEVEL_SERVICE;
    }
}
