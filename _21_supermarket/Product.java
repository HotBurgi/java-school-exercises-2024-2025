package _21_supermarket;

public class Product {
    private final String code;
    private final String description;
    private final double price;
    private int quantityInShop;
    private int quantityInStock;

    public Product(String description, double price, int quantityInShop, int quantityInStock) {
        this.code = "P" + (int) (Math.random() * 1000);
        this.description = description;
        this.price = price;
        this.quantityInShop = quantityInShop;
        this.quantityInStock = quantityInStock;
    }

    public String getCode() {
        return code;
    }

    public String moveToStock(int quantity) {
        if (quantityInShop >= quantity) {
            quantityInShop -= quantity;
            quantityInStock += quantity;
            return "Success";
        }
        return "Failed";
    }

    public String moveToShop(int quantity) {
        if (quantityInStock >= quantity) {
            quantityInStock -= quantity;
            quantityInShop += quantity;
            return "Success";
        }
        return "Failed";
    }

    public String printQuantity() {
        return "Quantity in shop: " + quantityInShop + "\nQuantity in stock: " + quantityInStock;
    }

    public int getQuantity() {
        return quantityInShop + quantityInShop;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityInShop=" + quantityInShop +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}