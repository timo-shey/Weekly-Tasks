import CustomException.UsageException;
import Impl.*;
import Interface.*;
import Model.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws UsageException, IOException {
        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/src/ConvenienceStore.csv";

        System.out.println();
        ConvenienceStore store = new ConvenienceStore("DigiStores");
        store.addProducts(path);
        List<Product> allProducts = store.getProductList();
        System.out.println();

        System.out.println("List of products: " + store.getProductList());
        System.out.println();

        CashierServiceImpl cashier = new CashierServiceImpl();
        Applicant applicant = new Applicant("Sarah", "Lean", "Female", 23, "B.Sc");
        Staff manager = new Staff("Johnny", "Depp", "Male", 42, 0001, "Manager");
        ManagerService managerService = new ManagerServiceImpl();
        Customer customer = new Customer("John", "Doe", "Male", 24, 90000.0);
        Customer customer1 = new Customer("Jane", "Dane", "Female", 23, 65000.0);
        CustomerService customerService = new CustomerServiceImpl();
        ConvenienceStoreService convenienceStoreService = new ConvenienceStoreServiceImpl();

        String shoppingCart = customerService.buyProduct(customer, "Bournvita", 12);
        String shoppingCart2 = customerService.buyProduct(customer, "Microwave", 2);
        String shoppingCart3 = customerService.buyProduct(customer1, "Bag of Rice", 2);
        String shoppingCart4 = customerService.buyProduct(customer1, "Lego Bricks", 45);

        System.out.println();
        System.out.println("List of products: " + store.getProductList());

    }
}
