package Model;

import Interface.ManagerInterface;

public class Manager extends Staff {

    public Manager(String firstName, String lastName, String gender, int age, String emailAddress, int staffId, String position) {
        super(firstName, lastName, gender, age, emailAddress, staffId, position);
    }

}
