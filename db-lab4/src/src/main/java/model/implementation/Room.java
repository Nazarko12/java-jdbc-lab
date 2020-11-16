package src.main.java.model.implementation;

import src.main.java.model.IGeneralModel;

public class Room implements IGeneralModel {
    private Integer id;
    private String nameRoom;
    private double square;


    public Room(Integer id, String  nameRoom, double square) {
        this.id = id;
        this.nameRoom = nameRoom;
        this.square = square;
    }



    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", nameRoom='" + nameRoom + '\'' +
                ", square='" + square + '\'' +
                '}';
    }
}

