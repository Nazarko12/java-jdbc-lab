package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class Zone implements IGeneralModel {
    private Integer id;
    private int quantityRooms;
    private double levelRange;


    public Zone(Integer id, int quantityRooms, double levelRange) {
        this.id = id;
        this.quantityRooms = quantityRooms;
        this.levelRange = levelRange;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantityRooms() {
        return quantityRooms;
    }

    public void setQuantityRooms(int quantityRooms) {
        this.quantityRooms = quantityRooms;
    }

    public double getLevelRange() {
        return levelRange;
    }

    public void setLevelRange(double levelRange) {
        this.levelRange = levelRange;
    }


    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", quantityRooms=" + quantityRooms +
                ", levelRange=" + levelRange + '\'' +
                '}';
    }
}

