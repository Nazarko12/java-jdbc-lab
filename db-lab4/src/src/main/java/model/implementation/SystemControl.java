package src.main.java.model.implementation;


import src.main.java.model.IGeneralModel;

public class SystemControl implements IGeneralModel {
    private Integer id;
    private int quantityControlProcessings;


    public SystemControl(Integer id, int quantityControlProcessings) {
        this.id = id;
        this.quantityControlProcessings = quantityControlProcessings;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantityControlProcessings() {
        return quantityControlProcessings;
    }

    public void setQuantityControlProcessings(int quantityControlProcessings) {
        this.quantityControlProcessings = quantityControlProcessings;
    }



    @Override
    public String toString() {
        return "SystemControl{" +
                "id=" + id +
                ", quantityControlProcessings='" + quantityControlProcessings + '\'' +
                '}';
    }
}
