package Model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final int productQuantity;
    private final Product product;
    private final double totalPrice;

    public ShoppingCart(int productQuantity, Product product, double totalPrice) {
        this.productQuantity = productQuantity;
        this.product = product;
        this.totalPrice = totalPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
