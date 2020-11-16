package src.main.java.service.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.DAO.implementation.UserDAO;
import src.main.java.model.implementation.User;

public class UserService extends GeneralService<User> {
    private final IGeneralDAO<User, Integer> userDAOImplementation = new UserDAO();

    @Override
    public final IGeneralDAO<User, Integer> getDAO() {
        return userDAOImplementation;
    }
}