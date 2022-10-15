package Impl;

import CustomException.UsageException;
import Interface.ConvenienceStoreService;
import Model.*;

import java.util.Map;

public class ConvenienceStoreServiceImpl implements ConvenienceStoreService {

    @Override
    public String sellProduct(ConvenienceStore convenienceStore, Customer customer, Staff staff) throws UsageException {
        Product product;
        if(staff.getDepartment().equals("Cashier")){
            double cartAmount = 0.0;
            for(ShoppingCart shoppingCart : customer.getCart()){
                product = shoppingCart.getProduct();
                customer.setMoney(-shoppingCart.getInCartAmount());
                product.setProductQuantity(product.getProductQuantity() - shoppingCart.getQuantity());
                if(product.getProductQuantity() == 0){
                    product.setProductAvailability("OUT OF STOCK");
                }
            }
            issueReceipt(convenienceStore, customer, staff);
        }
        return "Item could not be sold, Unauthorized Personnel.";
    }

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

