package src.main.java.service.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.DAO.implementation.ZoneDAO;
import src.main.java.model.implementation.Zone;

public class ZoneService extends GeneralService <Zone> {
    private final IGeneralDAO<Zone, Integer> zoneDAOImplementation = new ZoneDAO();

    @Override
    public final IGeneralDAO <Zone, Integer> getDAO() {
        return zoneDAOImplementation;
    }
}