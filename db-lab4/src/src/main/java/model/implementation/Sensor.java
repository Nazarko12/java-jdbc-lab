package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class Sensor implements IGeneralModel {
    private Integer id;
    private double processingTime;
    private String nameModel;
    private String type;
    private int calibration;
    private String classification;

    public Sensor(Integer id, double processingTime, String nameModel, String type, int calibration, String classification) {
        this.id = id;
        this.processingTime = processingTime;
        this.nameModel = nameModel;
        this.type = type;
        this.calibration = calibration;
        this.classification = classification;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(double processingTime) {
        this.processingTime = processingTime;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalibration() {
        return calibration;
    }

    public void setCalibration(int calibration) {
        this.calibration = calibration;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", processingTime='" + processingTime +
                ", nameModel='" + nameModel +
                "type=" + type +
                ",calibration='" + calibration +
                ",classification='" + classification + '\'' +
        '}';
    }
}

