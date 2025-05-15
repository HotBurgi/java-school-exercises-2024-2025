package _38_shop;

public abstract class Product {
    private static int prog = 0;
    private final int code;
    private final String title;
    private final String description;
    private final float price;
    private final int storageQuantity;

    public Product(String title, String description, float price, int storageQuantity) {
        prog++;
        this.code = prog;
        this.title = title;
        this.description = description;
        this.price = price;
        this.storageQuantity = storageQuantity;
    }

    public abstract float calculateTotal(int quantity, float price);

    public float getPrice() {
        return price;
    }
}
