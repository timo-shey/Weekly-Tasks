import CustomException.UsageException;
import Impl.*;
import Interface.*;
import Model.*;
import Model.Comparator;
import jdk.dynalink.linker.ConversionComparator;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws UsageException, IOException {

        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/ConvenienceStore.csv";
        ConvenienceStore store = new ConvenienceStore("DigiStores");
        ConvenienceStoreService convenienceStoreService = new ConvenienceStoreServiceImpl();
        store.addProducts(path);
        System.out.println("List of products: " + store.getProductList());

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

        System.out.println();

        System.out.println("=================== FIRST IN FIRST OUT (FIFO) ===================");
        LinkedList<Customer> fifoQueue = new LinkedList<>();
        fifoQueue.add(customer);
        fifoQueue.add(customer2);
        fifoQueue.add(customer3);
        fifoQueue.add(customer4);
        while(!fifoQueue.isEmpty()){
            System.out.println(fifoQueue.remove().getFirstName());
        }
        System.out.println("=================================================================");

        System.out.println();

        System.out.println("============== PRIORITY QUEUE(MOST PRODUCTS FIRST) ==============");
        Queue<Customer> priorityQueue = new PriorityQueue<>(new Comparator());
        priorityQueue.offer(customer);
        priorityQueue.offer(customer2);
        priorityQueue.offer(customer3);
        priorityQueue.offer(customer4);
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll().getFirstName());
        }
        System.out.println("=================================================================");

    }
}
