package Interface;

import Model.Applicant;
import Model.Cashier;
import Model.ConvenienceStore;
import Model.Staff;

public interface ManagerService {
    String hire(Applicant applicant, Staff staff, ConvenienceStore convenienceStore);
}
