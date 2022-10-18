package Interface;

import CustomException.UsageException;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.ShoppingCart;

import java.util.List;

public interface CustomerService {
    String buyProduct(Customer customer, String product, int quantity) throws UsageException;

}
