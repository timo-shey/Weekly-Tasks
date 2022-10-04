import Interface.CashierInterface;
import Interface.CustomerInterface;
import Interface.ManagerInterface;
import Interface.Impl.CashierServiceImpl;
import Interface.Impl.CustomerServiceImpl;
import Interface.Impl.ManagerServiceImpl;
import Model.*;

public class Main {
    public static void main(String[] args) {

        Staff staff = new Staff("Rick", "Sanchez", "Male", 67,
                "rickierick@email.com", 0001, "CEO");
        System.out.println("My name is " + staff.getFirstName() + " " + staff.getLastName() + ".");


        Applicant applicant = new Applicant("Homer", "Simpson", "Male", 42,
                "hhSimp@email.com", "B.Sc", "Cashier");
        System.out.println(applicant.getFirstName() + " " + applicant.getLastName()
                + " has applied for the position of a " + applicant.getPosition() + ".");


        ManagerInterface managerService = new ManagerServiceImpl();
        Manager manager = new Manager("Timileyin", "Adeleke", "Male", 35,
                "t.adeleke@email.com", 0002, "Manager");
        managerService.hire(applicant);
        System.out.println(managerService.hire(applicant));


        CustomerInterface customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Naruto", "Uzumaki", "Male", 25,
                "U.naruto@email.com", 9250.00, 2);
        System.out.println("Customer: " + customer.getFirstName() + " " +  customer.getLastName()
                + " has #" + customer.getMoney() + " to spend.");


        Product product = new Product("Sardine", 4000.00, 100);
        System.out.println("There are " + product.getProductQuantity() + " quantities of " + product.getProductName()
                + " left at " + product.getProductPrice() + " per unit.");


        CashierInterface cashierService = new CashierServiceImpl();
        Cashier cashier = new Cashier("Sakura", "Chan", "Female", 25,
                "c.sakura@email.com", 0003, "Cashier");
        System.out.println(cashier.getFirstName() + " " + cashier.getLastName()
                + " is the only Female staff in the store.");
        System.out.println(customerService.buyProduct(customer, product));
        System.out.println(cashierService.sellProduct(customer, product));
        System.out.println(cashierService.issueReceipt(customer, product));
        customerService.buyProduct(customer, product);
        cashierService.issueReceipt(customer, product);
    }
}
