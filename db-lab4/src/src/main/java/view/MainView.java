package src.main.java.view;

import src.main.java.controller.implementation.*;
import src.main.java.model.implementation.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private final AccessLevelController accessLevelController = new AccessLevelController();
    private final NotificationSettingsController notificationSettingsController = new NotificationSettingsController();
    private final ObjectAndSecurityController objectAndSecurityController = new ObjectAndSecurityController();
    private final RoomController roomController = new RoomController();
    private final SensorController sensorController = new SensorController();
    private final SensorNotificationController sensorNotificationController = new SensorNotificationController();
    private final SensorSettingsController sensorSettingsController = new SensorSettingsController();
    private final SystemAlertController systemAlertController = new SystemAlertController();
    private final SystemControlController systemControlController = new SystemControlController();
    private final UserController userController = new UserController();
    private final ZoneController zoneController = new ZoneController();


    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    public MainView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("11", "11 - Get all access levels");
        menu.put("12", "12 - Get access level by ID");
        menu.put("13", "13 - Create access level");
        menu.put("14", "14 - Delete access level by ID");
        menu.put("15", "15 - Update access level by ID");

        menu.put("21", "21 - Get all notifications settings");
        menu.put("22", "22 - Get notification setting by ID");
        menu.put("23", "23 - Create notification setting");
        menu.put("24", "24 - Delete notification setting by ID");
        menu.put("25", "25 - Update notification setting by ID");

        menu.put("31", "31 - Get all objects and security");
        menu.put("32", "32 - Get object object and security by ID");
        menu.put("33", "33 - Create object object and security");
        menu.put("34", "34 - Delete object object and security by ID");
        menu.put("35", "35 - Update object object and security by ID");

        menu.put("41", "41 - Get all rooms");
        menu.put("42", "42 - Get room by ID");
        menu.put("43", "43 - Create room");
        menu.put("44", "44 - Delete room by ID");
        menu.put("45", "45 - Update room by ID");


        menu.put("51", "51 - Get all sensors");
        menu.put("52", "52 - Get sensor by ID");
        menu.put("53", "53 - Create sensor");
        menu.put("54", "54 - Delete sensor by ID");
        menu.put("55", "55 - Update sensor by ID");

        menu.put("61", "61 - Get all sensor notifications");
        menu.put("62", "62 - Get sensor notification by ID");
        menu.put("63", "63 - Create sensor notification");
        menu.put("64", "64 - Delete sensor notification by ID");
        menu.put("65", "65 - Update sensor notification by ID");

        menu.put("71", "71 - Get all sensor settings");
        menu.put("72", "72 - Get sensor setting by ID");
        menu.put("73", "73 - Create sensor setting");
        menu.put("74", "74 - Delete sensor setting by ID");
        menu.put("65", "65 - Update sensor setting by ID");

        menu.put("81", "81 - Get all system alerts");
        menu.put("82", "82 - Get system alert by ID");
        menu.put("83", "83 - Create system alert");
        menu.put("84", "84 - Delete system alert by ID");
        menu.put("85", "85 - Update system alert by ID");

        menu.put("91", "91 - Get all systems control");
        menu.put("92", "92 - Get system control by ID");
        menu.put("93", "93 - Create system control");
        menu.put("94", "94 - Delete system control by ID");
        menu.put("95", "95 - Update system control by ID");

        menu.put("101", "101 - Get all users");
        menu.put("102", "102 - Get user by ID");
        menu.put("103", "103 - Create user");
        menu.put("104", "104 - Delete user by ID");
        menu.put("105", "105 - Update user by ID");

        menu.put("111", "111 - Get all zones");
        menu.put("112", "112 - Get zone by ID");
        menu.put("113", "113 - Create zone");
        menu.put("114", "114 - Delete zone by ID");
        menu.put("115", "115 - Update zone by ID");


        methodsMenu.put("11", this::getAllAccessLevels);
        methodsMenu.put("12", this::getAccessLevelById);
        methodsMenu.put("13", this::createAccessLevel);
        methodsMenu.put("14", this::deleteAccessLevelById);
        methodsMenu.put("15", this::updateAccessLevelById);

        methodsMenu.put("21", this::getAllNotificationsSettings);
        methodsMenu.put("22", this::getNotificationSettingsById);
        methodsMenu.put("23", this::createNotificationSettings);
        methodsMenu.put("24", this::deleteNotificationSettingsById);
        methodsMenu.put("25", this::updateNotificationSettingsById);

        methodsMenu.put("31", this::getAllObjectsAndSecurity);
        methodsMenu.put("32", this::getObjectAndSecurityById);
        methodsMenu.put("33", this::createObjectAndSecurity);
        methodsMenu.put("34", this::deleteObjectAndSecurityById);
        methodsMenu.put("35", this::updateObjectAndSecurityById);

        methodsMenu.put("41", this::getAllRooms);
        methodsMenu.put("42", this::getRoomById);
        methodsMenu.put("43", this::createRoom);
        methodsMenu.put("44", this::deleteRoomById);
        methodsMenu.put("45", this::updateRoomById);


        methodsMenu.put("51", this::getAllSensors);
        methodsMenu.put("52", this::getSensorById);
        methodsMenu.put("53", this::createSensor);
        methodsMenu.put("54", this::deleteSensorById);
        methodsMenu.put("55", this::updateSensorById);

        methodsMenu.put("61", this::getAllSensorsNotification);
        methodsMenu.put("62", this::getSensorNotificationById);
        methodsMenu.put("63", this::createSensorNotification);
        methodsMenu.put("64", this::deleteSensorNotificationById);
        methodsMenu.put("65", this::updateSensorNotificationById);

        methodsMenu.put("71", this::getAllSensorsSettings);
        methodsMenu.put("72", this::getSensorSettingsById);
        methodsMenu.put("73", this::createSensorSettings);
        methodsMenu.put("74", this::deleteSensorSettingsById);
        methodsMenu.put("75", this::updateSensorSettingsById);

        methodsMenu.put("81", this::getAllSystemAlerts);
        methodsMenu.put("82", this::getSystemAlertById);
        methodsMenu.put("83", this::createSystemAlert);
        methodsMenu.put("84", this::deleteSystemAlertById);
        methodsMenu.put("85", this::updateSystemAlertById);

        methodsMenu.put("91", this::getAllSystemsControl);
        methodsMenu.put("92", this::getSystemControlById);
        methodsMenu.put("93", this::createSystemControl);
        methodsMenu.put("94", this::deleteSystemControlById);
        methodsMenu.put("95", this::updateSystemControlById);

        methodsMenu.put("101", this::getAllUsers);
        methodsMenu.put("102", this::getUserById);
        methodsMenu.put("103", this::createUser);
        methodsMenu.put("104", this::deleteUserById);
        methodsMenu.put("105", this::updateUserById);


        methodsMenu.put("131", this::getAllZones);
        methodsMenu.put("132", this::getZoneById);
        methodsMenu.put("133", this::createZone);
        methodsMenu.put("134", this::deleteZoneById);
        methodsMenu.put("135", this::updateZoneById);


    }


    private void getAllAccessLevels() throws SQLException {
        System.out.println("\nTable: access_level");
        accessLevelController.getAll();
    }

    private void getAccessLevelById() throws SQLException {
        System.out.println("Enter ID for Access Level: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        accessLevelController.getById(id);
    }

    private void createAccessLevel() throws SQLException {
        System.out.println("Enter new accessLevel range: ");
        Double range = INPUT.nextDouble();
        System.out.println("Enter new accessLevel resolution: ");
        Double resolution = INPUT.nextDouble();
        INPUT.nextDouble();
        AccessLevel entity = new AccessLevel(0, range, resolution);
        accessLevelController.create(entity);
    }

    private void deleteAccessLevelById() throws SQLException {
        System.out.println("Enter ID to delete AccessLevel: ");
        int id = INPUT.nextInt();
        INPUT.nextDouble();
        accessLevelController.delete(id);
    }

    private void updateAccessLevelById() throws SQLException {
        System.out.println("Enter access level id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        AccessLevel oldAccessLevel = accessLevelController.getService().getById(id);
        System.out.println("Enter new range for accessLevel: ");
        Double range = INPUT.nextDouble();
        System.out.println("Enter new resolution for accessLevel: ");
        Double resolution = INPUT.nextDouble();
        INPUT.nextDouble();

        Double newRange = range;
        Double newResolution = resolution;

        if (range.equals("")) newRange = oldAccessLevel.getRange();
        if (resolution.equals("")) newResolution = oldAccessLevel.getResolution();

        AccessLevel entity = new AccessLevel(id, newRange, newResolution);
        accessLevelController.update(entity);
    }


    private void getAllNotificationsSettings() throws SQLException {
        System.out.println("\nTable: notification settings");
        notificationSettingsController.getAll();
    }

    private void getNotificationSettingsById() throws SQLException {
        System.out.println("Enter ID for Notification Settings: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        notificationSettingsController.getById(id);
    }

    private void createNotificationSettings() throws SQLException {
        System.out.println("Enter new control access level: ");
        Double controlAccessLevel = INPUT.nextDouble();
        System.out.println("Enter new system id: ");
        int systemId = INPUT.nextInt();
        INPUT.nextLine();
        NotificationSettings entity = new NotificationSettings(0, controlAccessLevel, systemId);
        notificationSettingsController.create(entity);
    }

    private void deleteNotificationSettingsById() throws SQLException {
        System.out.println("Enter ID to delete notification setting: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        notificationSettingsController.delete(id);
    }

    private void updateNotificationSettingsById() throws SQLException {
        System.out.println("Enter notification setting id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        NotificationSettings oldNotificationSetting = notificationSettingsController.getService().getById(id);
        System.out.println("Enter new control access level for notification setting: ");
        Double controlAccessLevel = INPUT.nextDouble();
        System.out.println("Enter new system id for notification setting: ");
        int systemId = INPUT.nextInt();
        INPUT.nextLine();

        Double newControlAccessLevel = controlAccessLevel;
        Integer newSystemId = systemId;

        if (controlAccessLevel < 0.0) newControlAccessLevel = oldNotificationSetting.getControlAccessLevel();
        if (systemId < 0) newSystemId = oldNotificationSetting.getSystemId();

        NotificationSettings entity = new NotificationSettings(id, newControlAccessLevel, newSystemId);
        notificationSettingsController.update(entity);
    }


    private void getAllObjectsAndSecurity() throws SQLException {
        System.out.println("\nTable: object_and_security");
        objectAndSecurityController.getAll();
    }

    private void getObjectAndSecurityById() throws SQLException {
        System.out.println("Enter ID for Object And Security: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        objectAndSecurityController.getById(id);
    }

    private void createObjectAndSecurity() throws SQLException {
        System.out.println("Enter new ID for location: ");
        String location = INPUT.nextLine();
        INPUT.nextLine();
        ObjectAndSecurity entity = new ObjectAndSecurity(0, location);
        objectAndSecurityController.create(entity);
    }

    private void deleteObjectAndSecurityById() throws SQLException {
        System.out.println("Enter ID to delete Object And Security: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        objectAndSecurityController.delete(id);
    }

    private void updateObjectAndSecurityById() throws SQLException {
        System.out.println("Enter object and security ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        ObjectAndSecurity oldObjectAndSecurity = objectAndSecurityController.getService().getById(id);
        System.out.println("Enter new location for object and security: ");
        String location = INPUT.nextLine();
        INPUT.nextLine();

        String newLocation = location;

        if (location.equals("")) newLocation = oldObjectAndSecurity.getLocation();

        ObjectAndSecurity entity = new ObjectAndSecurity(0, newLocation);
        objectAndSecurityController.update(entity);
    }


    private void getAllRooms() throws SQLException {
        System.out.println("\nTable: room");
        roomController.getAll();
    }

    private void getRoomById() throws SQLException {
        System.out.println("Enter ID for Room: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        roomController.getById(id);
    }

    private void createRoom() throws SQLException {
        System.out.println("Enter new name room: ");
        String nameRoom = INPUT.nextLine();
        System.out.println("Enter new square: ");
        Double square = INPUT.nextDouble();
        INPUT.nextLine();
        Room entity = new Room(0, nameRoom, square);
        roomController.create(entity);
    }

    private void deleteRoomById() throws SQLException {
        System.out.println("Enter ID to delete Room: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        roomController.delete(id);
    }

    private void updateRoomById() throws SQLException {
        System.out.println("Enter room ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Room oldRoom = roomController.getService().getById(id);
        System.out.println("Enter new for name room: ");
        String nameRoom = INPUT.nextLine();
        System.out.println("Enter new for square: ");
        Double square = INPUT.nextDouble();
        INPUT.nextLine();

        String newNameRoom = nameRoom;
        Double newSquare = square;


        if (nameRoom.equals("")) newNameRoom = oldRoom.getNameRoom();
        if (square < 0.0) newSquare = oldRoom.getSquare();

        Room entity = new Room(id, newNameRoom, newSquare);
        roomController.update(entity);
    }

    private void getAllSensorsNotification() throws SQLException {
        System.out.println("\nTable: sensor_notification");
        roomController.getAll();
    }

    private void getSensorNotificationById() throws SQLException {
        System.out.println("Enter ID for Sensor Notification: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorNotificationController.getById(id);
    }

    private void createSensorNotification() throws SQLException {
        System.out.println("Enter new range level: ");
        Double rangeLevel = INPUT.nextDouble();
        System.out.println("Enter new resolution level: ");
        Double resolutionLevel = INPUT.nextDouble();
        System.out.println("Enter new system ID: ");
        int systemId = INPUT.nextInt();
        INPUT.nextLine();
        SensorNotification entity = new SensorNotification(0, rangeLevel, resolutionLevel, systemId);
        sensorNotificationController.create(entity);
    }

    private void deleteSensorNotificationById() throws SQLException {
        System.out.println("Enter ID to delete Sensor Notification: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorNotificationController.delete(id);
    }

    private void updateSensorNotificationById() throws SQLException {
        System.out.println("Enter sensor notification ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        SensorNotification oldSensorNotification = sensorNotificationController.getService().getById(id);
        Double rangeLevel = INPUT.nextDouble();
        System.out.println("Enter new resolution level: ");
        Double resolutionLevel = INPUT.nextDouble();
        System.out.println("Enter new system ID: ");
        int systemId = INPUT.nextInt();
        INPUT.nextLine();

        Double newRangeLevel = rangeLevel;
        Double newResolutionLevel = resolutionLevel;
        int newSystemId = systemId;

        if (rangeLevel < 0.0) newRangeLevel = oldSensorNotification.getRangeLevel();
        if (resolutionLevel < 0.0) newResolutionLevel = oldSensorNotification.getResolutionLevel();
        if (systemId < 0) newSystemId = oldSensorNotification.getSystemId();

        SensorNotification entity = new SensorNotification(id, newRangeLevel, newResolutionLevel, newSystemId);
        sensorNotificationController.update(entity);
    }


    private void getAllSensors() throws SQLException {
        System.out.println("\nTable: sensor");
        sensorController.getAll();
    }

    private void getSensorById() throws SQLException {
        System.out.println("Enter ID for Sensor: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorController.getById(id);
    }

    private void createSensor() throws SQLException {
        System.out.println("Enter new processing time: ");
        Double processingTime = INPUT.nextDouble();
        System.out.println("Enter new name model: ");
        String nameModel = INPUT.nextLine();
        System.out.println("Enter new type: ");
        String type = INPUT.nextLine();
        System.out.println("Enter new calibration: ");
        int calibration = INPUT.nextInt();
        System.out.println("Enter new classification: ");
        String classification = INPUT.nextLine();
        INPUT.nextLine();
        Sensor entity = new Sensor(0, processingTime, nameModel, type, calibration, classification);
        sensorController.create(entity);
    }

    private void deleteSensorById() throws SQLException {
        System.out.println("Enter ID to delete Sensor: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorController.delete(id);
    }

    private void updateSensorById() throws SQLException {
        System.out.println("Enter Sensor ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Sensor oldSensor = sensorController.getService().getById(id);
        System.out.println("Enter new processing time: ");
        Double processingTime = INPUT.nextDouble();
        System.out.println("Enter new name model: ");
        String nameModel = INPUT.nextLine();
        System.out.println("Enter new type: ");
        String type = INPUT.nextLine();
        System.out.println("Enter new calibration: ");
        int calibration = INPUT.nextInt();
        System.out.println("Enter new classification: ");
        String classification = INPUT.nextLine();
        INPUT.nextLine();

        Double newProcessingTime = processingTime;
        String newNameModel = nameModel;
        String newType = type;
        int newCalibration = calibration;
        String newClassification = classification;


        if (processingTime < 0.0) newProcessingTime = oldSensor.getProcessingTime();
        if (nameModel.equals("")) newNameModel = oldSensor.getNameModel();
        if (type.equals("")) newType = oldSensor.getType();
        if (calibration < 0.0) newCalibration = oldSensor.getCalibration();
        if (classification.equals("")) newClassification = oldSensor.getClassification();

        Sensor entity = new Sensor(id, newProcessingTime, newNameModel, newType, newCalibration, newClassification);
        sensorController.update(entity);
    }


    private void getAllSensorsSettings() throws SQLException {
        System.out.println("\nTable: sensor_setting");
        sensorSettingsController.getAll();
    }

    private void getSensorSettingsById() throws SQLException {
        System.out.println("Enter ID for Sensor Setting: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorSettingsController.getById(id);
    }

    private void createSensorSettings() throws SQLException {
        System.out.println("Enter new sensor range: ");
        Double sensorRange = INPUT.nextDouble();
        System.out.println("Enter new sensor resolution: ");
        Double sensorResolution = INPUT.nextDouble();
        System.out.println("Enter new system id: ");
        Integer systemId = INPUT.nextInt();
        INPUT.nextLine();
        SensorSettings entity = new SensorSettings(0, sensorRange, sensorResolution, systemId);
        sensorSettingsController.create(entity);
    }

    private void deleteSensorSettingsById() throws SQLException {
        System.out.println("Enter ID to delete Sensor Setting: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorSettingsController.delete(id);
    }

    private void updateSensorSettingsById() throws SQLException {
        System.out.println("Enter Sensor Setting id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        SensorSettings oldSensorSetting = sensorSettingsController.getService().getById(id);
        System.out.println("Enter new ID for sensor range: ");
        Double sensorRange = INPUT.nextDouble();
        System.out.println("Enter ID status for sensor resolution: ");
        Double sensorResolution = INPUT.nextDouble();
        System.out.println("Enter new ID for system id: ");
        Integer systemId = INPUT.nextInt();
        INPUT.nextLine();

        Double newSensorRange = sensorRange;
        Double newSensorResolution = sensorResolution;
        int newSystemId = systemId;

        if (sensorRange < 0.0) newSensorRange = oldSensorSetting.getSensorRange();
        if (sensorResolution < 0.0) newSensorResolution = oldSensorSetting.getSensorResolution();
        if (systemId < 0) newSystemId = oldSensorSetting.getSystemId();

        SensorSettings entity = new SensorSettings(id, newSensorRange, newSensorResolution, newSystemId);
        sensorSettingsController.update(entity);
    }


    private void getAllSystemAlerts() throws SQLException {
        System.out.println("\nTable: system_alert");
        systemAlertController.getAll();
    }

    private void getSystemAlertById() throws SQLException {
        System.out.println("Enter ID for System Alert: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        systemAlertController.getById(id);
    }

    private void createSystemAlert() throws SQLException {
        System.out.println("Enter new many notifications: ");
        Integer manyNotifications = INPUT.nextInt();
        System.out.println("Enter new texts notifications: ");
        String textsNotifications = INPUT.nextLine();
        System.out.println("Enter new about processings: ");
        String aboutProcessings = INPUT.nextLine();
        System.out.println("Enter new system id: ");
        Integer systemId = INPUT.nextInt();
        INPUT.nextLine();
        SystemAlert entity = new SystemAlert(0, manyNotifications, textsNotifications, aboutProcessings, systemId);
        systemAlertController.create(entity);
    }

    private void deleteSystemAlertById() throws SQLException {
        System.out.println("Enter ID to delete System Alert: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        systemAlertController.delete(id);
    }

    private void updateSystemAlertById() throws SQLException {
        System.out.println("Enter System Alert id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        SystemAlert oldSystemAlert = systemAlertController.getService().getById(id);
        System.out.println("Enter new many notifications: ");
        int manyNotifications = INPUT.nextInt();
        System.out.println("Enter new texts notifications: ");
        String textsNotifications = INPUT.nextLine();
        System.out.println("Enter new about processings: ");
        String aboutProcessings = INPUT.nextLine();
        System.out.println("Enter new systemId: ");
        Integer systemId = INPUT.nextInt();
        INPUT.nextLine();

        Integer newManyNotifications = manyNotifications;
        String newTextsNotifications = textsNotifications;
        String newAboutProcessings = aboutProcessings;
        Integer newSystemId = systemId;


        if (manyNotifications < 0) newManyNotifications = oldSystemAlert.getManyNotifications();
        if (textsNotifications.equals("")) newTextsNotifications = oldSystemAlert.getTextsNotifications();
        if (aboutProcessings.equals("")) newAboutProcessings = oldSystemAlert.getAboutProcessings();
        if (systemId < 0) newSystemId = oldSystemAlert.getSystemId();

        SystemAlert entity = new SystemAlert(id, newManyNotifications, newTextsNotifications, newAboutProcessings, newSystemId);
        systemAlertController.update(entity);
    }


    private void getAllSystemsControl() throws SQLException {
        System.out.println("\nTable: system_control");
        systemControlController.getAll();
    }

    private void getSystemControlById() throws SQLException {
        System.out.println("Enter ID for System Control: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        systemControlController.getById(id);
    }

    private void createSystemControl() throws SQLException {
        System.out.println("Enter new quantity control processings: ");
        int quantityControlProcessings = INPUT.nextInt();
        INPUT.nextLine();
        SystemControl entity = new SystemControl(0, quantityControlProcessings);
        systemControlController.create(entity);
    }

    private void deleteSystemControlById() throws SQLException {
        System.out.println("Enter ID to delete System Control: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        systemControlController.delete(id);
    }

    private void updateSystemControlById() throws SQLException {
        System.out.println("Enter System Control ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        SystemControl oldSystemControl = systemControlController.getService().getById(id);
        System.out.println("Enter new quantityControlProcessings: ");
        int quantityControlProcessings = INPUT.nextInt();
        INPUT.nextLine();

        int newQuantityControlProcessings = quantityControlProcessings;

        if (quantityControlProcessings < 0)
            newQuantityControlProcessings = oldSystemControl.getQuantityControlProcessings();

        SystemControl entity = new SystemControl(id, newQuantityControlProcessings);
        systemControlController.update(entity);
    }


    private void getAllUsers() throws SQLException {
        System.out.println("\nTable: user");
        userController.getAll();
    }

    private void getUserById() throws SQLException {
        System.out.println("Enter ID for User: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        userController.getById(id);
    }

    private void createUser() throws SQLException {
        System.out.println("Enter new first name: ");
        String firstName = INPUT.nextLine();
        System.out.println("Enter new last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new country: ");
        String country = INPUT.nextLine();
        System.out.println("Enter new system id: ");
        Integer systemId = INPUT.nextInt();
        INPUT.nextLine();
        User entity = new User(0, firstName, lastName, country, systemId);
        userController.create(entity);
    }

    private void deleteUserById() throws SQLException {
        System.out.println("Enter ID to delete User: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        userController.delete(id);
    }

    private void updateUserById() throws SQLException {
        System.out.println("Enter User ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        User oldUser = userController.getService().getById(id);
        System.out.println("Enter new first name: ");
        String firstName = INPUT.nextLine();
        System.out.println("Enter new last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new country: ");
        String country = INPUT.nextLine();
        System.out.println("Enter new system id: ");
        Integer systemId = INPUT.nextInt();
        INPUT.nextLine();

        String newFirstName = firstName;
        String newLastName = lastName;
        String newCountry = country;
        Integer newSystemId = systemId;

        if (firstName.equals("")) newFirstName = oldUser.getFirstName();
        if (lastName.equals("")) newLastName = oldUser.getLastName();
        if (country.equals("")) newCountry = oldUser.getCountry();
        if (systemId < 0) newSystemId = oldUser.getSystemId();

        User entity = new User(id, newFirstName, newLastName, newCountry, newSystemId);
        userController.update(entity);
    }


    private void getAllZones() throws SQLException {
        System.out.println("\nTable: zone");
        zoneController.getAll();
    }

    private void getZoneById() throws SQLException {
        System.out.println("Enter ID for Zone: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        zoneController.getById(id);
    }

    private void createZone() throws SQLException {
        System.out.println("Enter new quantity rooms: ");
        int quantityRooms = INPUT.nextInt();
        System.out.println("Enter new level range: ");
        Double levelRange = INPUT.nextDouble();
        INPUT.nextLine();
        Zone entity = new Zone(0, quantityRooms, levelRange);
        zoneController.create(entity);
    }

    private void deleteZoneById() throws SQLException {
        System.out.println("Enter ID to delete Zone: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        zoneController.delete(id);
    }

    private void updateZoneById() throws SQLException {
        System.out.println("Enter Travel Class id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Zone oldZone = zoneController.getService().getById(id);
        System.out.println("Enter new quantity rooms: ");
        int quantityRooms = INPUT.nextInt();
        System.out.println("Enter new level range: ");
        Double levelRange = INPUT.nextDouble();
        INPUT.nextLine();

        int newQuantityRooms = quantityRooms;
        Double newLevelRange = levelRange;

        if (quantityRooms < 0) newQuantityRooms = oldZone.getQuantityRooms();
        if (levelRange < 0) newLevelRange = oldZone.getLevelRange();

        Zone entity = new Zone(id, newQuantityRooms, newLevelRange);
        zoneController.update(entity);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = INPUT.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {
            }
        } while (!keyMenu.equals("Q"));
    }
}