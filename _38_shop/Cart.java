package _38_shop;

import java.util.ArrayList;

public class Cart {
    ArrayList<CartProduct> cart;

    public Cart(ArrayList<CartProduct> cart) {
        this.cart = cart;
    }

    public void addToCart(Product p, int q) {
        CartProduct cp = new CartProduct(p, q);
        cart.add(cp);
    }

    public Boolean removeFromCart(Product p) {
        for (CartProduct cp : cart) {
            if (cp.getProduct().equals(p)) {
                cart.remove(cp);
                return true;
            }
        }
        return false;
    }

    public float payment() {
        float total = 0;
        for (CartProduct p : cart) {
            total += p.getProduct().calculateTotal(p.getQuantity(), p.getProduct().getPrice());
        }
        return total;
    }

    public ArrayList<CartProduct> getCart() {
        return cart;
    }
}
