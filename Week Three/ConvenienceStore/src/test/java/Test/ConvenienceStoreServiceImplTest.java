package Test;

import CustomException.UsageException;
import Impl.ConvenienceStoreServiceImpl;
import Impl.CustomerServiceImpl;
import Interface.ConvenienceStoreService;
import Interface.CustomerService;
import Model.Comparator;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class ConvenienceStoreServiceImplTest {

    @Test
    public void firstInFirstOutTest() {
        Product Bournvita = new Product("Beverage", 1000.0, "Bournvita", 10);
        Product Microwave = new Product("Electronics", 1500.0, "Microwave", 10);
        Product LegoBricks = new Product("Toys", 2000.0, "Lego Bricks", 10);
        Product BagOfRice = new Product("Foodstuff", 2500.0, "Bag of Rice", 10);

        Customer customer = new Customer("Peter", "Griffin", "Male", 24, 50000);
        Customer customer2 = new Customer("John", "Griffin", "Male", 25, 50000);
        Customer customer3 = new Customer("James", "Griffin", "Male", 22, 25000);
        Customer customer4 = new Customer("Andrew", "Griffin", "Male", 26, 15000);

        CustomerServiceImpl customerAction = new CustomerServiceImpl();
        customerAction.addToCart(customer, Bournvita);
        customerAction.addToCart(customer2, Microwave, BagOfRice, BagOfRice, LegoBricks);
        customerAction.addToCart(customer3, LegoBricks, Microwave);
        customerAction.addToCart(customer4, BagOfRice, Microwave, Bournvita);

        List<Customer> fifoQueue = new LinkedList<>();
        fifoQueue.add(customer);
        fifoQueue.add(customer2);
        fifoQueue.add(customer3);
        fifoQueue.add(customer4);

        assertEquals("Peter", fifoQueue.get(0).getFirstName());
        assertEquals("John", fifoQueue.get(1).getFirstName());
        assertEquals("James", fifoQueue.remove(2).getFirstName());
    }

    @Test
    public void priorityQueueMostProductsFirst() {
        Product Bournvita = new Product("Beverage", 1000.0, "Bournvita", 10);
        Product Microwave = new Product("Electronics", 1500.0, "Microwave", 10);
        Product LegoBricks = new Product("Toys", 2000.0, "Lego Bricks", 10);
        Product BagOfRice = new Product("Foodstuff", 2500.0, "Bag of Rice", 10);

        Customer customer = new Customer("Peter", "Griffin", "Male", 24, 50000);
        Customer customer2 = new Customer("John", "Griffin", "Male", 25, 50000);
        Customer customer3 = new Customer("James", "Griffin", "Male", 22, 25000);
        Customer customer4 = new Customer("Andrew", "Griffin", "Male", 26, 15000);

        CustomerServiceImpl customerAction = new CustomerServiceImpl();
        customerAction.addToCart(customer, Bournvita);
        customerAction.addToCart(customer2, Microwave, BagOfRice, BagOfRice, LegoBricks);
        customerAction.addToCart(customer3, LegoBricks, Microwave);
        customerAction.addToCart(customer4, BagOfRice, Microwave, Bournvita);

        Queue<Customer> priorityQueue = new PriorityQueue<>(new Comparator());
        priorityQueue.offer(customer);
        priorityQueue.offer(customer2);
        priorityQueue.offer(customer3);
        priorityQueue.offer(customer4);

        assertEquals("John", priorityQueue.poll().getFirstName());
        assertEquals("Andrew", priorityQueue.poll().getFirstName());
        assertEquals("James", priorityQueue.poll().getFirstName());
        assertEquals("Peter", priorityQueue.poll().getFirstName());
    }

}