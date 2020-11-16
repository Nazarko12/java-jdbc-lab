package src.main.java.model.implementation;

import src.main.java.model.IGeneralModel;

;

public class SensorSettings implements IGeneralModel {
    private Integer id;
    private double sensorRange;
    private double sensorResolution;
    private Integer systemId;


    public SensorSettings(Integer id, double sensorRange, double sensorResolution, Integer systemId) {
        this.id = id;
        this.sensorRange = sensorRange;
        this.sensorResolution = sensorResolution;
        this.systemId = systemId;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSensorRange() {
        return sensorRange;
    }

    public void setSensorRange(double sensorRange) {
        this.sensorRange = sensorRange;
    }

    public double getSensorResolution() {
        return sensorResolution;
    }

    public void setSensorResolution(double sensorResolution) {
        this.sensorResolution = sensorResolution;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }


    @Override
    public String toString() {
        return "SensorSettings{" +
                "id=" + id +
                ", sensorRange=" + sensorRange +
                ", sensorResolution=" + sensorResolution +
                ", systemId=" + systemId + '\'' +
                '}';
    }
}