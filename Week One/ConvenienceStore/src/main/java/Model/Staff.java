package Model;

public class Staff extends Person {

    private int staffId;
    private String position;

    public Staff(String firstName, String lastName, String gender, int age, String emailAddress, int staffId, String position) {
        super(firstName, lastName, gender, age, emailAddress);
        this.staffId = staffId;
        this.position = position;
    }

    public Staff() {
        super();
    }
}
