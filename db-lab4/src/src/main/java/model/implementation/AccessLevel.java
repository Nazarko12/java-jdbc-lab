package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class AccessLevel implements IGeneralModel {
    private Integer id;
    private double range;
    private double resolution;


    public AccessLevel(Integer id, double range, double resolution) {
        this.id = id;
        this.range = range;
        this.resolution = resolution;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getResolution() {
        return resolution;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }


    @Override
    public String toString() {
        return "AccessLevel{" +
                "id=" + id +
                ", range='" + range + '\'' +
                ", resolution='" + resolution + '\'' +
                '}';
    }
}
