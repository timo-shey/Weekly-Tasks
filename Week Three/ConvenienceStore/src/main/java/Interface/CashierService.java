package Interface;

import CustomException.UsageException;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

import java.util.Queue;

public interface CashierService {
    String issueReceipt(ConvenienceStore convenienceStore, Customer customer, Staff staff);

}
