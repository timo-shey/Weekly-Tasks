package Impl;

import CustomException.UsageException;
import Interface.ConvenienceStoreService;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.Staff;

import java.util.Map;

public class ConvenienceStoreServiceImpl implements ConvenienceStoreService {

    @Override
    public Product[] viewProductsByCategory(ConvenienceStore convenienceStore, String productCategory) {
        Product[] productsByCategory;
        int index = 0;
        String category = productCategory.valueOf(productCategory.toUpperCase());

        for(Product product : convenienceStore.getProductList()){
            if (product.getProductCategory().equals(category)) index++;
        }
        productsByCategory = new Product[index];
        int counter = 0;

        for(Product product : convenienceStore.getProductList()) {
            if (product.getProductCategory().equals(category)) {
                productsByCategory[counter++] = product;
            }
        }

        if(productsByCategory.length == 0) {
            System.out.println("There are no products in this category.");
        }
        return productsByCategory;
    }

    @Override
    public String sellProduct(ConvenienceStore convenienceStore, Customer customer, Staff staff) throws UsageException {
        if(staff.getDepartment().equals("Cashier")){
            double cartAmount = 0.0;
            for (Product product1 : ConvenienceStore.productList) {
                cartAmount += product1.getProductPrice();
            }
            return sufficientFunds(convenienceStore, customer, staff, cartAmount);
        }
        return "Item could not be sold";
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

