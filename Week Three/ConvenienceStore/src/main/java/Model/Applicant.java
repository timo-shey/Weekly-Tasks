package Model;

public class Applicant extends Person{
    public String qualification;

    public Applicant(String firstName, String lastName, String gender, int age, String qualification) {
        super(firstName, lastName, gender, age);
        this.qualification = qualification;
    }

    public String getQualification() { return qualification; }

}
