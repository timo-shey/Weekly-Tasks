package Interface;


import CustomException.UsageException;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

public interface ConvenienceStoreService {
    
    String [] productCategory = { "Beverages", "Electronics", "Foodstuff", "Toys" };
    Product[] viewProductsByCategory(ConvenienceStore convenienceStore, String productCategory);

    String sellProduct(ConvenienceStore convenienceStore, Customer customer, Staff staff) throws UsageException;
}
