package Model;

public class Staff extends Person {

    private int staffId;
    private String department;

    public Staff(String firstName, String lastName, String gender, int age, int staffId, String department) {
        super(firstName, lastName, gender, age);
        this.staffId = staffId;
        this.department = department;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Staff() {
        super();
    }
}
