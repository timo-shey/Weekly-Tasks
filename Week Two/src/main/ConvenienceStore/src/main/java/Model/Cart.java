package Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> inCart;
    private double inCartAmount;

    public Cart() {
        this.inCart = new HashMap<>();
    }

    public Map<Product, Integer> getInCart() {
        return inCart;
    }

    public void setInCartAmount(double inCartAmount) {
        this.inCartAmount = inCartAmount;
    }

    public double getInCartAmount() {
        inCartAmount = 0.0;
        for (Product product : ConvenienceStore.productList){
            inCartAmount += product.getProductPrice();
        }
        return inCartAmount;
    }
}
