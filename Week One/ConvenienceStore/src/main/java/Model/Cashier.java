package Model;

import Interface.CashierInterface;

public class Cashier extends Staff {

    public Cashier(String firstName, String lastName, String gender, int age, String emailAddress, int staffId, String position) {
        super(firstName, lastName, gender, age, emailAddress, staffId, position);
    }

    public Cashier() {
        super();
    }

}
