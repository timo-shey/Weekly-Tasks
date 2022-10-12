package Impl;

import CustomException.UsageException;
import Interface.CustomerService;
import Model.ConvenienceStore;
import Model.Customer;
import Model.Product;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void addToCart(Customer customer, ConvenienceStore convenienceStore, List<Product> productList) throws UsageException {
        for (Product product : productList){
            if(product.getProductAvailability().equals("Available")){
                System.out.println(product.getProductName() + " has been added to cart");
            }
        }
        throw new UsageException("Product is out of stock.");
    }
}
