package _40_bike4travel;

public abstract class Bike {
    int price;
    boolean luggage;
    String model;

    public Bike(int price, boolean luggage, String model) {
        this.price = price;
        this.luggage = luggage;
        this.model = model;
    }

    public abstract int getTotal(int days);

    public String getModel() {
        return model;
    }
}
