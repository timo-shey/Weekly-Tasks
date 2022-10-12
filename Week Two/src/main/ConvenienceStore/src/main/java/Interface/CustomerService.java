package Interface;

import CustomException.UsageException;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;

import java.util.List;

public interface CustomerService {
    void addToCart (Customer customer, ConvenienceStore convenienceStore, List<Product> productList) throws UsageException;

}
