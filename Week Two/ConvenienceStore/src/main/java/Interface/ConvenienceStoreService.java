package Interface;


import CustomException.UsageException;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

public interface ConvenienceStoreService {
    String sellProduct(ConvenienceStore convenienceStore, Customer customer, Staff staff) throws UsageException;
}
