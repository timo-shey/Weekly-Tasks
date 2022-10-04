package Model;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String emailAddress;

    public Person(String firstName, String lastName, String gender, int age, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
