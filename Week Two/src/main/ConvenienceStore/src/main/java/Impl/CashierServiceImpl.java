package Impl;

import CustomException.UsageException;
import Interface.CashierService;
import Interface.ConvenienceStoreService;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

import java.util.Map;

public class CashierServiceImpl implements CashierService {

    @Override
    public String receivePayment(ConvenienceStore convenienceStore, Customer customer, Staff staff) throws UsageException {
        if (staff.getDepartment().equals("Cashier")) {
            double cartAmount = customer.getCart().getInCartAmount();
            Map<Product, Integer> productInCart = customer.getCart().getInCart();
            for (Map.Entry<Product, Integer> products : productInCart.entrySet()) {
                Product product = products.getKey();
                Integer quantity = products.getValue();
                cartAmount += getCartAmount(product, quantity);
            }
            return sufficientFunds(convenienceStore, customer, staff, cartAmount);
        } else {
            throw new UsageException("You are not authorized to sell.");
        }
    }

    private String sufficientFunds(ConvenienceStore store, Customer customer, Staff staff, double cartAmount) throws UsageException {
        if (customer.getMoney() >= cartAmount) {
            double customerMoney = customer.getMoney() - cartAmount;
            customer.setMoney(customerMoney);
            String receipt = issueReceipt(store, customer, cartAmount, staff);
            customer.getCart().setInCartAmount(0);
            customer.getCart().getInCart().clear();
            return receipt;
        } else {
            throw new UsageException("Insufficient amount to make this purchase");
        }
    }

    @Override
    public String issueReceipt(ConvenienceStore convenienceStore, Customer customer, double cartAmount, Staff staff) {
        StringBuilder productsBought = new StringBuilder();
        for (Map.Entry<Product, Integer> product : customer.getCart().getInCart().entrySet()) {
            productsBought.append(product.getKey().getProductName()).append(", ").append("Price: ")
                    .append(product.getKey().getProductPrice()).append(",").append(" Quantity Bought: ")
                    .append(product.getValue()).append("\n");
        }

        return "==============================================================\n"
                + "  ================== Transaction Receipt =================== \n"
                + "==============================================================\n"
                + customer.getFirstName() + " " + customer.getLastName() + ", your purchase is successful.\n"
                + "Product Amount:   " + cartAmount + "\n"
                + "==============================================================\n";
    }

    private double getCartAmount(Product product, Integer quantity) throws UsageException {
        double cartAmount;
        if(product.getProductAvailability().equals("Available")){
            if(product.getProductQuantity() >= quantity){
                cartAmount = product.getProductPrice() * quantity;
                product.setProductQuantity(product.getProductQuantity() - quantity);
                product.isAvailable();
                return cartAmount;
            } else {
                throw new UsageException("Only " + product.getProductQuantity() + " is/are left");
            }
        } else throw new UsageException("Product is no longer available.");
    }

}
