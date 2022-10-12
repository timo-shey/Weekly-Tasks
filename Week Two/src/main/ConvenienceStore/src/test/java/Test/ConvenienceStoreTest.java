package Test;

import CustomException.UsageException;
import Impl.ConvenienceStoreServiceImpl;
import Impl.CustomerServiceImpl;
import Interface.ConvenienceStoreService;
import Interface.CustomerService;
import Interface.ManagerService;
import Impl.ManagerServiceImpl;
import Model.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ConvenienceStoreTest {

    @Test
    public void shouldSellProductAndDebitBalance() throws UsageException, IOException {
        ConvenienceStore convenienceStore = new ConvenienceStore("DigiStores");
        ConvenienceStoreService storeAction = new ConvenienceStoreServiceImpl();
        Staff cashier = new Staff("John", "Doe", "Female", 23, 0222, "Cashier");
        Customer customer = new Customer("Jane", "Sanders", "Female", 25, 100000.00);
        CustomerService customerAction  = new CustomerServiceImpl();
        customerAction.addToCart(customer, convenienceStore, ConvenienceStore.productList);
        convenienceStore.viewProducts();
        storeAction.sellProduct(convenienceStore, customer, cashier);
        assertEquals(customer.getMoney(), 30800.00);
    }

}