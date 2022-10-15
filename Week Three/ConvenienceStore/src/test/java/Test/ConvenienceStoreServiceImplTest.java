package Test;

import CustomException.UsageException;
import Impl.ConvenienceStoreServiceImpl;
import Impl.CustomerServiceImpl;
import Interface.ConvenienceStoreService;
import Interface.CustomerService;
import Model.ConvenienceStore;
import Model.Customer;
import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;

public class ConvenienceStoreServiceImplTest {

    @Test
    public void sellProduct() throws UsageException {
        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/ConvenienceStore.csv";
        ConvenienceStore store = new ConvenienceStore("DigiStores");
        store.addProducts(path);
        Customer customer = new Customer("Peter", "Griffin", "Male", 24, 50000);
        ConvenienceStoreService convenienceStoreService = new ConvenienceStoreServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        customerService.buyProduct(customer, "Bournvita", 3);
        assertEquals("Product has been sold successfully.", convenienceStoreService.sellProduct(customer));
    }

    @Test
    public void issueReceipt() throws UsageException {
        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/ConvenienceStore.csv";
        ConvenienceStore store = new ConvenienceStore("DigiStores");
        store.addProducts(path);
        Customer customer = new Customer("Peter", "Griffin", "Male", 24, 50000);
        ConvenienceStoreService convenienceStoreService = new ConvenienceStoreServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        customerService.buyProduct(customer, "Bournvita", 3);
        assertEquals("==============================================================\n"
                + "  ================== Transaction Receipt =================== \n"
                + "==============================================================\n"
                + customer.getFirstName() + " " + customer.getLastName() + ", your purchase is successful.\n"
                + "Product Amount:   " + 3000.0 + "\n"
                + "==============================================================\n", convenienceStoreService.issueReceipt(customer));
    }

    @Test
    public void sellByPriorityQueue() throws UsageException {
        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/ConvenienceStore.csv";
        ConvenienceStore store = new ConvenienceStore("DigiStores");
        ConvenienceStoreService convenienceStoreService = new ConvenienceStoreServiceImpl();
        store.addProducts(path);
        CustomerService customerService = new CustomerServiceImpl();
        Queue<Customer> queue = store.getPriorityQueue();
        Customer customer = new Customer("Peter", "Griffin", "Male", 24, 50000);
        Customer customer2 = new Customer("John", "Griffin", "Male", 25, 50000);
        Customer customer3 = new Customer("James", "Griffin", "Male", 22, 25000);
        Customer customer4 = new Customer("Andrew", "Griffin", "Male", 26, 15000);

        customerService.buyProduct(customer, "Bournvita", 1);
        customerService.buyProduct(customer2, "Microwave", 4);
        customerService.buyProduct(customer3, "Lego Bricks", 2);
        customerService.buyProduct(customer4, "Bag of Rice", 3);

        convenienceStoreService.addCustomerToPriorityQueue(customer);
        convenienceStoreService.addCustomerToPriorityQueue(customer2);
        convenienceStoreService.addCustomerToPriorityQueue(customer3);
        convenienceStoreService.addCustomerToPriorityQueue(customer4);

        assertEquals(customer2, queue.remove());
        assertEquals(customer4, queue.remove());
        assertEquals(customer3, queue.remove());
        assertEquals(customer, queue.remove());

    }

    @Test
    public void sellByQueue() throws UsageException {
        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/ConvenienceStore.csv";
        ConvenienceStore store = new ConvenienceStore("DigiStores");
        ConvenienceStoreService convenienceStoreService = new ConvenienceStoreServiceImpl();
        store.addProducts(path);
        CustomerService customerService = new CustomerServiceImpl();
        Queue<Customer> queue = store.getQueue();
        Customer customer = new Customer("Peter", "Griffin", "Male", 24, 50000);
        Customer customer2 = new Customer("John", "Griffin", "Male", 25, 50000);
        Customer customer3 = new Customer("James", "Griffin", "Male", 22, 25000);
        Customer customer4 = new Customer("Andrew", "Griffin", "Male", 26, 15000);

        customerService.buyProduct(customer, "Bournvita", 1);
        customerService.buyProduct(customer2, "Microwave", 4);
        customerService.buyProduct(customer3, "Lego Bricks", 2);
        customerService.buyProduct(customer4, "Bag of Rice", 3);

        convenienceStoreService.addCustomerToQueue(customer);
        convenienceStoreService.addCustomerToQueue(customer2);
        convenienceStoreService.addCustomerToQueue(customer3);
        convenienceStoreService.addCustomerToQueue(customer4);

        assertEquals(customer, queue.remove());
        assertEquals(customer2, queue.remove());
        assertEquals(customer3, queue.remove());
        assertEquals(customer4, queue.remove());
    }

}