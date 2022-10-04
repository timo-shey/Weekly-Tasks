package Test;

import Interface.ManagerInterface;
import Interface.Impl.ManagerServiceImpl;
import Model.Applicant;
import Model.Manager;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void shouldReturnASuccessfulApplication() {
        ManagerInterface managerService = new ManagerServiceImpl();
        Applicant applicant = new Applicant("Homer", "Simpson", "Male", 42,
                "hhSimp@email.com", "B.Sc", "Cashier");

        Manager manager = new Manager("Timileyin", "Adeleke", "Male", 35,
                "t.adeleke@email.com", 0002, "Manager");


        String expected1 = applicant.getFirstName() + " " + applicant.getLastName()
                + ", your application for the post of a Cashier is successful.";

        assertEquals(expected1, managerService.hire(applicant));
    }


    @Test
    public void shouldReturnAFailedApplication() {
        ManagerInterface managerService = new ManagerServiceImpl();
        Applicant applicant = new Applicant("Homer", "Simpson", "Male", 42,
                "hhSimp@email.com", "HND", "Cashier");

        Manager manager = new Manager("Timileyin", "Adeleke", "Male", 35,
                "t.adeleke@email.com", 0002, "Manager");


        String expected2 = applicant.getFirstName() + " " + applicant.getLastName()
                + ", your application for the post of a Cashier is unsuccessful."
                + " You did not meet the minimum criteria.";

        assertEquals(expected2, managerService.hire(applicant));
    }
}