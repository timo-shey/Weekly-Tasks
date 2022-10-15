package Impl;

import CustomException.UsageException;
import Interface.CustomerService;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.ShoppingCart;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void addToCart(Customer customer, ShoppingCart cart) throws UsageException {
        customer.getCart().add(cart);
    }

    @Override
    public String buyProduct(Customer customer, String productName, int productQuantity) throws UsageException {
        List<Product> products = ConvenienceStore.getProductList();
//        if(productQuantity <= 0 ){
//            throw new UsageException("Quantity must be greater than zero.");
//        }
        String message = "";
        double price;
        Product product1 = products.stream().filter(p->p.getProductName().equals(productName)).findAny().orElse(null);
        if(product1 != null){
            if(product1.getProductQuantity() == 0){
                throw new UsageException("Product is out of stock.");
            }
            if(product1.getProductQuantity() >= productQuantity){
                price = product1.getProductPrice() * productQuantity;
                if(customer.getMoney() >= price){
                    message = String.format("%s added %s quantities of %s worth %s to cart.", customer.getFirstName(),
                            productQuantity, product1.getProductName(), price);
                    System.out.println(message);
                    addToCart(customer, new ShoppingCart(productQuantity, product1, price));
                    return message;
                } else message = "Transaction could not be completed. Insufficient fund.";
            } else message = String.format("We have %s left in stock", product1.getProductQuantity());
        }else throw new UsageException("Product Not Found");
        System.out.println(message);
        return message;
    }

}
