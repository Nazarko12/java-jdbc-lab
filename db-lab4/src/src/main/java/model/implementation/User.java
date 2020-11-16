package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class User implements IGeneralModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String country;
    private Integer systemId;

    public User(Integer id, String firstName, String lastName, String country, Integer systemId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.systemId = systemId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", country=" + country +
                ", systemId=" + systemId + '\'' +
                '}';
    }
}