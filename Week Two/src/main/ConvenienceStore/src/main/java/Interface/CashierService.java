package Interface;

import CustomException.UsageException;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

public interface CashierService {
    String receivePayment(ConvenienceStore convenienceStore, Customer customer, Staff staff) throws UsageException;

    String issueReceipt(ConvenienceStore convenienceStore, Customer customer, double cartAmount, Staff staff);
}
