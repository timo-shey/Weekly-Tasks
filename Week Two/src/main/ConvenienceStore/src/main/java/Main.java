import CustomException.UsageException;
import Impl.ConvenienceStoreServiceImpl;
import Interface.ConvenienceStoreService;
import Interface.CustomerService;
import Interface.ManagerService;
import Impl.CustomerServiceImpl;
import Impl.ManagerServiceImpl;
import Model.*;

import java.io.IOException;
import java.util.Arrays;

import static Model.ConvenienceStore.productList;

public class Main {
    public static void main(String[] args) throws UsageException, IOException {

        Applicant applicant = new Applicant("John", "Doe", "Male", 23,
                "e@email.com", "B.Sc");
        System.out.println(applicant.getFirstName() + " " + applicant.getLastName() + " has applied");


        ManagerService managerService = new ManagerServiceImpl();
        Staff staff = new Staff("Joe", "Barry", "Male", 40, 0210,
                "Manager");
        Staff cashier = new Staff("Solo", "Mon", "Male", 32, 001, "Cashier");
        ConvenienceStore convenienceStore  = new ConvenienceStore("DigiStores");
        convenienceStore.viewProducts();
        System.out.println("List of products: "+ convenienceStore.getProductList());
        ConvenienceStoreService storeAction = new ConvenienceStoreServiceImpl();
        System.out.println(Arrays.toString(storeAction.viewProductsByCategory(convenienceStore, "Toys")));


        String cashier1 = managerService.hire(applicant, staff, convenienceStore);
        System.out.println(applicant.getFirstName() + " " + applicant.getLastName() + " is now a Cashier");


        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Naruto", "Uzumaki", "Male", 25, 250000.00);
        Customer customer2 = new Customer("Ini", "Ojo", "Female", 21, 50000.00);
        Customer customer3 = new Customer("Ann", "Ojo", "Female", 24, 75000.00);
        System.out.println("Customer: " + customer.getFirstName() + " " +  customer.getLastName()
                + " has " + customer.getMoney() + " to spend.");

        customerService.addToCart(customer, convenienceStore, productList);
        customerService.addToCart(customer2, convenienceStore, productList);
        customerService.addToCart(customer3, convenienceStore, productList);

        System.out.println(storeAction.sellProduct(convenienceStore, customer,cashier));
        System.out.println(storeAction.sellProduct(convenienceStore, customer2,cashier));
        System.out.println(storeAction.sellProduct(convenienceStore, customer3,cashier));

    }
    }
