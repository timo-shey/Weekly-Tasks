package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private double money;

    private int quantity;

    private List<Product> cart = new ArrayList<>();

    public Customer(String firstName, String lastName, String gender, int age, double money) {
        super(firstName, lastName, gender, age);
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
