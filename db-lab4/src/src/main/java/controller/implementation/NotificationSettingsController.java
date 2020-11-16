package src.main.java.controller.implementation;


import src.main.java.model.implementation.NotificationSettings;
import src.main.java.service.implementation.GeneralService;
import src.main.java.service.implementation.NotificationSettingsService;

public class NotificationSettingsController extends GeneralController<NotificationSettings> {

    private static final NotificationSettingsService NOTIFICATION_SETTINGS_SERVICE = new NotificationSettingsService();

    @Override
    public final GeneralService<NotificationSettings> getService() {
        return NOTIFICATION_SETTINGS_SERVICE;
    }

}
