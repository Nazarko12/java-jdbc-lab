package src.main.java.service.implementation;


import src.main.java.DAO.IGeneralDAO;
import src.main.java.DAO.implementation.NotificationSettingsDAO;
import src.main.java.model.implementation.NotificationSettings;

public class NotificationSettingsService extends GeneralService<NotificationSettings> {
    private final IGeneralDAO<NotificationSettings, Integer> notificationSettingsDAOImplementation = new NotificationSettingsDAO();

    @Override
    public final IGeneralDAO<NotificationSettings, Integer> getDAO() {
        return notificationSettingsDAOImplementation;
    }
}
