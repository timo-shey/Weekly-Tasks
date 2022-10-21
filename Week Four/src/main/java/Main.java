import CustomException.UsageException;
import Impl.*;
import Interface.*;
import Model.*;
import Model.Comparator;
import jdk.dynalink.linker.ConversionComparator;

import java.io.IOException;
import java.util.*;

import static Model.StoreColour.*;

public class Main {
    public static void main(String[] args) throws UsageException, IOException {

        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/ConvenienceStore.csv";
        ConvenienceStore store = new ConvenienceStore();
        store.addProducts(path);
        System.out.println(ANSI_CYAN + ConvenienceStore.getProductList());

        Product Bournvita = new Product("Beverage", 1000.0, "Bournvita", 10);
        Product Microwave = new Product("Electronics", 1500.0, "Microwave", 10);
        Product LegoBricks = new Product("Toys", 2000.0, "Lego Bricks", 10);
        Product BagOfRice = new Product("Foodstuff", 2500.0, "Bag of Rice", 10);

        Customer customer = new Customer("Peter", "Griffin", "Male", 24, 50000);
        Customer customer2 = new Customer("John", "Griffin", "Male", 25, 50000);
        Customer customer3 = new Customer("James", "Griffin", "Male", 22, 10000);
        Customer customer4 = new Customer("Andrew", "Griffin", "Male", 26, 50000);
        Customer customer5 = new Customer("Mary", "Griffin", "Female", 21, 50000);
        Customer customer6 = new Customer("Paul", "Griffin", "Male", 23, 50000);
        Customer customer7 = new Customer("Matthew", "Griffin", "Male", 20, 50000);
        Customer customer8 = new Customer("Martha", "Griffin", "Female", 27, 50000);


        CustomerServiceImpl customerAction = new CustomerServiceImpl();
        customerAction.buyProduct(customer, "Bournvita", 6);
        customerAction.buyProduct(customer2, "Bournvita", 5);
        customerAction.buyProduct(customer3, "Lego Bricks", 6);
        customerAction.buyProduct(customer4, "Bag of Rice", 5);
        customerAction.buyProduct(customer5, "Milo", 4);
        customerAction.buyProduct(customer6, "Microwave", 10);
        customerAction.buyProduct(customer7, "Lego Bricks", 10);
        customerAction.buyProduct(customer8, "Bag of Rice", 6);

        System.out.println();

        CashierService cashierService = new CashierServiceImpl();

//        cashierService.sellProduct(customer);
//        cashierService.sellProduct(customer2);
//        cashierService.sellProduct(customer3);
//        cashierService.sellProduct(customer4);
//        cashierService.sellProduct(customer5);
//        cashierService.sellProduct(customer6);
//        cashierService.sellProduct(customer7);
//        cashierService.sellProduct(customer8);

        LinkedList<Customer> fifoQueue = new LinkedList<>();

        fifoQueue.add(customer);
        fifoQueue.add(customer2);
        fifoQueue.add(customer3);
        fifoQueue.add(customer4);
        fifoQueue.add(customer5);
        fifoQueue.add(customer6);
        fifoQueue.add(customer7);
        fifoQueue.add(customer8);

        while ((!fifoQueue.isEmpty())){
            cashierService.attendToThread(fifoQueue);
        }

        System.out.println(ANSI_CYAN + ConvenienceStore.getProductList());

        System.out.println(ANSI_BLACK + customer.getFirstName() + ": " + customer.getMoney());
        System.out.println(ANSI_BLACK + customer2.getFirstName() + ": " + customer2.getMoney());
        System.out.println(ANSI_BLACK + customer3.getFirstName() + ": " + customer3.getMoney());
        System.out.println(ANSI_BLACK + customer4.getFirstName() + ": " + customer4.getMoney());
        System.out.println(ANSI_BLACK + customer5.getFirstName() + ": " + customer5.getMoney());
        System.out.println(ANSI_BLACK + customer6.getFirstName() + ": " + customer6.getMoney());
        System.out.println(ANSI_BLACK + customer7.getFirstName() + ": " + customer7.getMoney());
        System.out.println(ANSI_BLACK + customer8.getFirstName() + ": " + customer8.getMoney());
    }
}
