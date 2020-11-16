package src.main.java.controller.implementation;


import src.main.java.model.implementation.Zone;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.ZoneService;

public class ZoneController extends GeneralController<Zone> {

    private static final ZoneService ZONE_SERVICE = new ZoneService();

    @Override
    public final GeneralService<Zone> getService() {
        return ZONE_SERVICE;
    }

}
