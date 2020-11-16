package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class NotificationSettings implements IGeneralModel {
    private Integer id;
    private double controlAccessLevel;
    private Integer systemId;

    public NotificationSettings(Integer id, double controlAccessLevel, Integer systemId) {
        this.id = id;
        this.controlAccessLevel = controlAccessLevel;
        this.systemId = systemId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getControlAccessLevel() {
        return controlAccessLevel;
    }

    public void setControlAccessLevel(double controlAccessLevel) {
        this.controlAccessLevel = controlAccessLevel;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) { this.systemId = systemId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", controlAccessLevel='" + controlAccessLevel +
                ", systemId='" + systemId + '\'' +
                '}';
    }
}
