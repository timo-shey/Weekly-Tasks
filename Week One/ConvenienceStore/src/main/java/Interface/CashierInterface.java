package Interface;

import Model.Customer;
import Model.Product;

public interface CashierInterface {
    String issueReceipt(Customer customer, Product product);
    boolean sellProduct(Customer customer, Product product);
}
