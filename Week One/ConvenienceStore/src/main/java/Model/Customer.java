package Model;

import Interface.CustomerInterface;

public class Customer extends Person {
    private double money;
    private int unitsOfProduct;

    public Customer(String firstName, String lastName, String gender, int age, String emailAddress, double money, int unitsOfProduct) {
        super(firstName, lastName, gender, age, emailAddress);
        this.money = money;
        this.unitsOfProduct = unitsOfProduct;
    }

    public double getMoney() {
        return money;
    }

    public int getUnitsOfProduct() {
        return unitsOfProduct;
    }

}
