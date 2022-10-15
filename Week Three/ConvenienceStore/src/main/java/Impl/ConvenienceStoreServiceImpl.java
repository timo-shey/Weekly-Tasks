package Impl;

import CustomException.UsageException;
import Interface.ConvenienceStoreService;
import Model.*;

import java.util.Map;
import java.util.Queue;

public class ConvenienceStoreServiceImpl implements ConvenienceStoreService {

    @Override
    public String sellProduct(Customer customer) throws UsageException {
        Product product;
        double cartAmount = 0.0;
        for(ShoppingCart shoppingCart : customer.getCart()){
            product = shoppingCart.getProduct();
            customer.setMoney(-shoppingCart.getInCartAmount());
            product.setProductQuantity(product.getProductQuantity() - shoppingCart.getQuantity());
            if(product.getProductQuantity() == 0){
                product.setProductAvailability("OUT OF STOCK");
            }
        }
        issueReceipt(customer);
        return String.format("Product has been sold successfully.");
    }

    public String issueReceipt(Customer customer) {
        StringBuilder productsBought = new StringBuilder();
        double total = 0;
        for (ShoppingCart shoppingCart : customer.getCart()){
            productsBought.append(shoppingCart.getProduct().getProductName()).append(", ").append("Price: ")
                    .append(shoppingCart.getInCartAmount()).append(",").append(" Quantity Bought: ")
                    .append(shoppingCart.getQuantity()).append("\n");
            total += shoppingCart.getInCartAmount();
        }

        return "==============================================================\n"
                + "  ================== Transaction Receipt =================== \n"
                + "==============================================================\n"
                + customer.getFirstName() + " " + customer.getLastName() + ", your purchase is successful.\n"
                + "Product Amount:   " + total + "\n"
                + "==============================================================\n";
    }

    @Override
    public void sellByPriorityQueue(Queue<Customer> queue) throws UsageException {
        while (!queue.isEmpty()){
            sellProduct(queue.remove());
        }
    }

    @Override
    public void sellByQueue(Queue<Customer> queue) throws UsageException {
        while (!queue.isEmpty()){
            sellProduct(queue.remove());
        }
    }

    @Override
    public void addCustomerToPriorityQueue(Customer customer) {
        ConvenienceStore.getPriorityQueue().add(customer);
    }

    @Override
    public void addCustomerToQueue(Customer customer) {
        ConvenienceStore.getQueue().add(customer);
    }
}

