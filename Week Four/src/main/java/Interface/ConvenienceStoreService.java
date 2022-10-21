package Interface;


import CustomException.UsageException;
import Impl.ConvenienceStoreServiceImpl;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

import java.util.Queue;

public interface ConvenienceStoreService {
    String issueReceipt(ConvenienceStore convenienceStore, Customer customer, Staff staff);

}
