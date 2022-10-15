package Interface;


import CustomException.UsageException;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

import java.util.Queue;

public interface ConvenienceStoreService {
    String sellProduct(Customer customer) throws UsageException;
    String issueReceipt(Customer customer);
    void sellByPriorityQueue(Queue<Customer> queue) throws UsageException;
    void sellByQueue(Queue<Customer> queue) throws UsageException;
    void addCustomerToPriorityQueue(Customer customer);

    void addCustomerToQueue(Customer customer);
}
