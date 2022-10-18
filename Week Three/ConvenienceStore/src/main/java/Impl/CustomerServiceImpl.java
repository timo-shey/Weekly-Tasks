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
                throw new UsageException("Product is out of stock.");
            }
            if(product.getProductQuantity() >= productQuantity){
                price = product.getProductPrice() * productQuantity;
                if(customer.getMoney() >= price){
                    message = String.format("%s added %s quantities of %s worth %s to cart.", customer.getFirstName(),
                            productQuantity, product.getProductName(), price);
                    System.out.println(message);
                    return message;
                } else message = "Transaction could not be completed. Insufficient fund.";
            } else message = String.format("We have %s left in stock", product.getProductQuantity());
        }else throw new UsageException("Product Not Found");
        System.out.println(message);
        return message;
    }

    public void addToCart(Customer customer, Product... product){
        customer.getCart().addAll(List.of(product));
        customer.setQuantity(product.length);
    }

}
