package _38_shop;

public class Game extends Product {
    private final String distributor;

    public Game(String title, String description, float price, int storageQuantity, String distributor) {
        super(title, description, price, storageQuantity);
        this.distributor = distributor;
    }

    public float calculateTotal(int quantity, float price) {
        if (quantity == 0) {
            return 0;
        }

        if (quantity <= 10) {
            float total = quantity * price;
            return total - (total * 5) / 100;
        } else if (quantity <= 100) {
            float total = quantity * price;
            return total - (total * 10) / 100;
        } else {
            float total = quantity * price;
            return total - (total * 20) / 100;
        }
    }
}
