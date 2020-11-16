package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class SystemAlert implements IGeneralModel {
    private Integer id;
    private int manyNotifications;
    private String textsNotifications;
    private String aboutProcessings;
    private Integer systemId;

    public SystemAlert(Integer id, int manyNotifications, String textsNotifications, String aboutProcessings, Integer systemId) {
        this.id = id;
        this.manyNotifications = manyNotifications;
        this.textsNotifications = textsNotifications;
        this.aboutProcessings = aboutProcessings;
        this.systemId = systemId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getManyNotifications() {
        return manyNotifications;
    }

    public void setManyNotifications(int manyNotifications) {
        this.manyNotifications = manyNotifications;
    }

    public String getTextsNotifications() {
        return textsNotifications;
    }

    public void setTextsNotifications(String textsNotifications) {
        this.textsNotifications = textsNotifications;
    }

    public String getAboutProcessings() {
        return aboutProcessings;
    }

    public void setAboutProcessings(String aboutProcessing) {
        this.aboutProcessings = aboutProcessings;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Override
    public String toString() {
        return "SystemAlert{" +
                "id=" + id +
                ", manyNotifications=" + manyNotifications +
                ", textsNotifications='" + textsNotifications +
                ", aboutProcessing='" + aboutProcessings + '\'' +
                '}';
    }
}
