package src.main.java.controller.implementation;


import src.main.java.model.implementation.User;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.UserService;

public class UserController  extends GeneralController<User> {

    private static final UserService USER_SERVICE = new UserService();

    @Override
    public final GeneralService<User> getService() {
        return USER_SERVICE;
    }

}

