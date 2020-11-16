package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class ObjectAndSecurity implements IGeneralModel {
    private Integer id;
    private String location;

    public ObjectAndSecurity(Integer id, String location) {
        this.id = id;
        this.location = location;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "ObjectAndSecurity{" +
                "id=" + id +
                ", location='" + location +
        '}';
    }
}
