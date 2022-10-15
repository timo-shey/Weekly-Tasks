package Impl;

import CustomException.UsageException;
import Interface.ManagerService;
import Model.Applicant;
import Model.ConvenienceStore;
import Model.Staff;

public class ManagerServiceImpl implements ManagerService {
    @Override
    public String hire(Applicant applicant, Staff staff, ConvenienceStore convenienceStore) {
        try {
            if (staff.getDepartment().equals("Manager")) {
                if (convenienceStore.getApplicants().contains(applicant)) {
                    if (applicant.getQualification().equals("B.Sc")) {
                        Staff newStaff = new Staff(
                                applicant.getLastName(),
                                applicant.getLastName(),
                                applicant.getGender(),
                                applicant.getAge(),
                                0001,
                                "Cashier");
                        convenienceStore.getStaff().add(newStaff);
                        System.out.println("Hi " + applicant.getFirstName() + ", you have been hired!");
                    } else {
                        throw new UsageException("" + applicant.getFirstName() + ", " + applicant.getLastName() + "\n, " +
                                "your application for the post of a Cashier is unsuccessful. You did not meet the minimum criteria.");
                    }
                }
            }
        } catch (UsageException e){
            System.out.println(e.getErrorMessage());
        }
        return "You cannot hire an applicant.";
    }
}
