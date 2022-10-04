package Interface.Impl;

import Interface.CustomerInterface;
import Model.Customer;
import Model.Product;

public class CustomerServiceImpl implements CustomerInterface {

    @Override
    public String buyProduct(Customer customer, Product product) {
        if(customer.getMoney() >= product.getProductPrice() * customer.getUnitsOfProduct()) {
            return "Transaction successful";
        }
        return "Transaction not successful. You don't have enough money!";
    }
}
