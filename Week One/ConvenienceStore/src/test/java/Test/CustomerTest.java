package Test;

import Interface.CustomerInterface;
import Interface.Impl.CustomerServiceImpl;
import Model.Customer;
import Model.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void shouldReturnTransactionSuccessful() {
        CustomerInterface customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Naruto", "Uzumaki", "Male", 25,
                "U.naruto@email.com", 10000.00, 2);


        Product product = new Product("Sardine", 4000.00, 100);


        String expected = "Transaction successful";
        assertEquals(expected, customerService.buyProduct(customer, product));
    }

    @Test
    public void shouldReturnTransactionNotSuccessful() {
        CustomerInterface customerService = new CustomerServiceImpl();
        Customer customer = new Customer("Naruto", "Uzumaki", "Male", 25,
                "U.naruto@email.com", 5000.00, 2);


        Product product = new Product("Sardine", 4000.00, 100);


        String expected = "Transaction not successful. You don't have enough money!";
        assertEquals(expected, customerService.buyProduct(customer, product));
    }
}