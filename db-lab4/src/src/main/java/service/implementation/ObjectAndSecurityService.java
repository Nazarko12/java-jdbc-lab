package src.main.java.service.implementation;

import src.main.java.DAO.IGeneralDAO;
import src.main.java.DAO.implementation.ObjectAndSecurityDAO;
import src.main.java.model.implementation.ObjectAndSecurity;

public class ObjectAndSecurityService extends GeneralService<ObjectAndSecurity> {
    private final IGeneralDAO<ObjectAndSecurity, Integer> objectAndSecurityDAOImplementation = new ObjectAndSecurityDAO();

    @Override
    public final IGeneralDAO<ObjectAndSecurity, Integer> getDAO() {
        return objectAndSecurityDAOImplementation;
    }
}