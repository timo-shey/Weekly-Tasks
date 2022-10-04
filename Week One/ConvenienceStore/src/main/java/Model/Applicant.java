package Model;

public class Applicant extends Person{
    public String qualification;
    private String position;

    public Applicant(String firstName, String lastName, String gender, int age, String emailAddress, String qualification, String position) {
        super(firstName, lastName, gender, age, emailAddress);
        this.qualification = qualification;
        this.position = position;
    }

    public String getQualification() { return qualification; }

    public String getPosition() { return position; }
}
