package _38_shop;

public class Book extends Product {
    private final String author;

    public Book(String title, String description, float price, int storageQuantity, String author) {
        super(title, description, price, storageQuantity);
        this.author = author;
    }

    public float calculateTotal(int quantity, float price) {
        if (quantity == 0) {
            return 0;
        }

        if (quantity <= 10) {
            float total = quantity * price;
            return total - (total * 10) / 100;
        } else if (quantity <= 100) {
            float total = quantity * price;
            return total - (total * 20) / 100;
        } else {
            float total = quantity * price;
            return total - (total * 25) / 100;
        }
    }
}
