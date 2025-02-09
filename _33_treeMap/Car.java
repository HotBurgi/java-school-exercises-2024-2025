package _33_treeMap;

public class Car {
    private String model;
    private String color;
    private String plate;
    private String brand;
    private int year;

    public Car(String model, String color, String plate, String brand, int year) {
        this.model = model;
        this.color = color;
        this.plate = plate;
        this.brand = brand;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                '}';
    }
}
