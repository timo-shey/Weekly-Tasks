package Impl;

import CustomException.UsageException;
import Interface.CashierService;
import Model.*;

import java.util.Map;
import java.util.Queue;

public class CashierServiceImpl implements CashierService {

    @Override
    public String issueReceipt(ConvenienceStore convenienceStore, Customer customer, Staff staff) {
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


}
