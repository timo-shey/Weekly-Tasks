package Test;

import CustomException.UsageException;
import Impl.CashierServiceImpl;
import Impl.CustomerServiceImpl;
import Interface.CashierService;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class CashierServiceImplTest {

    @Test
    public void testToCheckForTheDelayTimePerCustomer() throws IOException, UsageException {
        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/ConvenienceStore.csv";
        ConvenienceStore store = new ConvenienceStore();
        store.addProducts(path);

        Product Bournvita = new Product("Beverage", 1000.0, "Bournvita", 10);
        Product Microwave = new Product("Electronics", 1500.0, "Microwave", 10);
        Product LegoBricks = new Product("Toys", 2000.0, "Lego Bricks", 10);
        Product BagOfRice = new Product("Foodstuff", 2500.0, "Bag of Rice", 10);

        Customer customer = new Customer("Peter", "Griffin", "Male", 24, 50000);
        Customer customer2 = new Customer("John", "Griffin", "Male", 25, 50000);
        Customer customer3 = new Customer("James", "Griffin", "Male", 22, 50000);
        Customer customer4 = new Customer("Andrew", "Griffin", "Male", 26, 50000);
        Customer customer5 = new Customer("Mary", "Griffin", "Female", 21, 50000);
        Customer customer6 = new Customer("Paul", "Griffin", "Male", 23, 50000);
        Customer customer7 = new Customer("Matthew", "Griffin", "Male", 20, 50000);
        Customer customer8 = new Customer("Martha", "Griffin", "Female", 27, 50000);


        CustomerServiceImpl customerAction = new CustomerServiceImpl();
        customerAction.buyProduct(customer, "Bournvita", 8);
        customerAction.buyProduct(customer2, "Microwave", 7);
        customerAction.buyProduct(customer3, "Lego Bricks", 6);
        customerAction.buyProduct(customer4, "Bag of Rice", 5);
        customerAction.buyProduct(customer5, "Bournvita", 4);
        customerAction.buyProduct(customer6, "Microwave", 3);
        customerAction.buyProduct(customer7, "Lego Bricks", 2);
        customerAction.buyProduct(customer8, "Bag of Rice", 1);

        LinkedList<Customer> fifoQueue = new LinkedList<>();

        fifoQueue.add(customer);
        fifoQueue.add(customer2);
        fifoQueue.add(customer3);
        fifoQueue.add(customer4);
        fifoQueue.add(customer5);
        fifoQueue.add(customer6);
        fifoQueue.add(customer7);
        fifoQueue.add(customer8);

        assertEquals(8000L, customer.getQuantity() * 1000L);
        assertEquals(7000L, customer2.getQuantity() * 1000L);
        assertEquals(6000L, customer3.getQuantity() * 1000L);
        assertEquals(5000L, customer4.getQuantity() * 1000L);
        assertEquals(4000L, customer5.getQuantity() * 1000L);
        assertEquals(3000L, customer6.getQuantity() * 1000L);
        assertEquals(2000L, customer7.getQuantity() * 1000L);
        assertEquals(1000L, customer8.getQuantity() * 1000L);
    }
}