package Model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private int productQuantity;
    private  Product product;
    private double inCartAmount;

    public ShoppingCart(int productQuantity, Product product, double inCartAmount) {
        this.productQuantity = productQuantity;
        this.product = product;
        this.inCartAmount = inCartAmount;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setInCartAmount(double inCartAmount) {
        this.inCartAmount = inCartAmount;
    }

    public double getInCartAmount() { return inCartAmount; }

    public int getQuantity() { return productQuantity; }

    public Product getProduct() { return product; }
}
