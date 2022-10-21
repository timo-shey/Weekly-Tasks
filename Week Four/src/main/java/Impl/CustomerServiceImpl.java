package Impl;

import CustomException.UsageException;
import Interface.CustomerService;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;
import Model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

import static Model.StoreColour.ANSI_BLUE;
import static Model.StoreColour.ANSI_RED;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public String buyProduct(Customer customer, String productName, int productQuantity) throws UsageException {
        List<Product> products = ConvenienceStore.getProductList();
        if(productQuantity <= 0 ){
            throw new UsageException("Quantity must be greater than zero.");
        }
        String message = "";
        double price;
        Product product = products.stream().filter(p->p.getProductName().equals(productName)).findAny().orElse(null);
        if(product != null){
            if(product.getProductQuantity() == 0){
                throw new UsageException(ANSI_RED + "Product is out of stock.");
            }
            if(product.getProductQuantity() >= productQuantity){
                price = product.getProductPrice() * productQuantity;
                if(customer.getMoney() >= price){
                    message = String.format(ANSI_BLUE + "%s added %s quantities of %s worth %s to cart.", customer.getFirstName(),
                            productQuantity, product.getProductName(), price);
                    System.out.println(message);
                    addToCart(customer, new ShoppingCart(productQuantity, product, price));
                    product.setProductQuantity(product.getProductQuantity() - productQuantity);
                    return message;
                } else message = String.format(ANSI_RED + "%s: Transaction could not be completed. Insufficient fund.",
                        customer.getFirstName());
            } else message = String.format(ANSI_RED + "%s: We have %s left in stock.",customer.getFirstName(),
                    product.getProductQuantity());
        }else message = ANSI_RED + "Product Not Found";
        System.out.println(message);
        return message;
    }

    @Override
    public void addToCart(Customer customer, ShoppingCart shoppingCart){
        customer.getCart().add(shoppingCart);
//        Product product = new Product();
//        product.
    }

    @Override
    public void emptyCart(Customer customer) {
        customer.setCart(new ArrayList<>());
    }
}
