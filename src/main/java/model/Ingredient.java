package model;

public class Ingredient {
    private String name;
    private double quantity;
    private String unit;

    public Ingredient(String name, double quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }
    public double getQuantity() {
        return quantity;
    }
    public String getUnit() {
        return unit;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String toString() {
        return quantity + " " + unit + " of " + name;
    }
}
