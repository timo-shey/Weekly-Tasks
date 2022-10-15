package Model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private double money;

    private List<ShoppingCart> cart = new ArrayList<>();

    public Customer(String firstName, String lastName, String gender, int age, double money) {
        super(firstName, lastName, gender, age);
        this.money = money;
    }

    public double getMoney() { return money; }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<ShoppingCart> getCart() { return cart; }

    public void setCart(List<ShoppingCart> cart) { this.cart = cart; }

    public int cartQuantity(){
        int quantity = 0;
        for(ShoppingCart cart1 : cart){
            quantity += cart1.getQuantity();
        }
        return quantity;
    }

}
