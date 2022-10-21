package Interface;

import CustomException.UsageException;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public interface CashierService {
    String sellProduct(Customer customer);
    String issueReceipt(Customer customer);
    void attendToThread(LinkedList<Customer> queue) throws IOException;

}
