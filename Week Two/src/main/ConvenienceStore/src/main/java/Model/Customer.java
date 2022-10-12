package Model;

public class Customer extends Person {
    private double money;
    private Cart cart;

    public Customer(String firstName, String lastName, String gender, int age, double money) {
        super(firstName, lastName, gender, age);
        this.money = money;
        this.cart = new Cart();
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Cart getCart() {
        return cart;
    }

}
