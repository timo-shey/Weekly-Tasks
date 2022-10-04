package Test;

import Interface.CashierInterface;
import Interface.CustomerInterface;
import Model.Cashier;
import Model.Customer;
import Model.Product;
import Interface.Impl.CashierServiceImpl;
import Interface.Impl.CustomerServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashierTest {

    @Test
    public void shouldReturnTrueIfTheSaleIsSuccessful() {
        CashierInterface cashierService = new CashierServiceImpl();
        CustomerInterface customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Naruto", "Uzumaki", "Male", 25,
                "U.naruto@email.com", 10000.00, 2);

        Product product = new Product("Sardine", 4000.00, 100);

        Cashier cashier = new Cashier("Sakura", "Chan", "Female", 25,
                "c.sakura@email.com", 0003, "Cashier");;

        assertEquals(true, cashierService.sellProduct(customer, product));
    }

    @Test
    public void shouldReturnFalseIfTheSaleIsSuccessful() {
        CashierInterface cashierService = new CashierServiceImpl();
        CustomerInterface customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Naruto", "Uzumaki", "Male", 25,
                "U.naruto@email.com", 7000.00, 2);

        Product product = new Product("Sardine", 4000.00, 100);

        Cashier cashier = new Cashier("Sakura", "Chan", "Female", 25,
                "c.sakura@email.com", 0003, "Cashier");;

        assertEquals(false, cashierService.sellProduct(customer, product));
    }



    @Test
    public void shouldReturnTransactionSuccessfulAndIssueAReceiptForTheSuccessfulTransaction() {
        CashierInterface cashierService = new CashierServiceImpl();
        CustomerInterface customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Naruto", "Uzumaki", "Male", 25,
                "U.naruto@email.com", 10000.00, 2);

        Product product = new Product("Sardine", 4000.00, 100);

        Cashier cashier = new Cashier("Sakura", "Chan", "Female", 25,
                "c.sakura@email.com", 0003, "Cashier");

        double change = customer.getMoney() - (product.getProductPrice() * customer.getUnitsOfProduct());
        String expected = "==============================================================\n"
                + "  ================== Transaction Receipt =================== \n"
                + "==============================================================\n"
                + customer.getFirstName() + " " + customer.getLastName() + ", your purchase is successful.\n" + "\n"
                + "Product Name:     " + product.getProductName() + "\n" + "Product Amount:   "
                + product.getProductPrice() + "\n" + "Product Quantity: " + customer.getUnitsOfProduct() + "\n"
                + "\n" + "==============================================================\n" + "     Grand Total:  "
                + product.getProductPrice() * customer.getUnitsOfProduct() + "      ||      Change:  "
                + change + "\n" + "==============================================================";

        assertEquals(expected, cashierService.issueReceipt(customer, product));
    }

    @Test
    public void shouldReturnTransactionNotSuccessfulAndIssueReceiptForTheFailedTransaction() {
        CashierInterface cashierService = new CashierServiceImpl();
        CustomerInterface customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Naruto", "Uzumaki", "Male", 25,
                "U.naruto@email.com", 500.00, 2);

        Product product = new Product("Sardine", 4000.00, 100);

        Cashier cashier = new Cashier("Sakura", "Chan", "Female", 25,
                "c.sakura@email.com", 0003, "Cashier");

        double extraAmount = (product.getProductPrice() * customer.getUnitsOfProduct() - customer.getMoney());
        String expected = "==================================================================\n"
                + "   =================== Transaction Receipt ====================\n"
                + "==================================================================\n" +  "\n"
                + "    Transaction not successful. You don't have enough money!\n" + "You need an extra amount of "
                + extraAmount + " to complete this transaction.\n"
                + "\n" + "==================================================================";

        assertEquals(expected, cashierService.issueReceipt(customer, product));
    }
}