package Interface.Impl;

import Interface.ManagerInterface;
import Model.Applicant;

public class ManagerServiceImpl implements ManagerInterface {
    @Override
    public String hire(Applicant applicant) {

        if (applicant.qualification.equals("B.Sc")) {
            return applicant.getFirstName() + " " + applicant.getLastName()
                    + ", your application for the post of a Cashier is successful.";
        }
        return applicant.getFirstName() + " " + applicant.getLastName()
                + ", your application for the post of a Cashier is unsuccessful."
                + " You did not meet the minimum criteria.";
    }
}
