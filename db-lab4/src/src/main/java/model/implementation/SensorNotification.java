package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class SensorNotification implements IGeneralModel {
    private Integer id;
    private double rangeLevel;
    private double resolutionLevel;
    private Integer systemId;


    public SensorNotification(Integer id, double rangeLevel, double resolutionLevel, Integer systemId) {
        this.id = id;
        this.rangeLevel = rangeLevel;
        this.resolutionLevel = resolutionLevel;
        this.systemId = systemId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRangeLevel() {
        return rangeLevel;
    }

    public void setRangeLevel(double rangeLevel) {
        this.rangeLevel = rangeLevel;
    }

    public double getResolutionLevel() {
        return rangeLevel;
    }

    public void setResolutionLevel(double resolutionLevel) {
        this.resolutionLevel = resolutionLevel;
    }

    public Integer getSystemId() {
        return id;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }


    @Override
    public String toString() {
        return "SensorNotification{" +
                "id=" + id +
                ", rangeLevel='" + rangeLevel +
                ", resolutionLevel='" + resolutionLevel +
                ", systemId='" + systemId + '\'' +
                '}';
    }

    public void add(SensorNotification sensorNotification) {
    }
}
