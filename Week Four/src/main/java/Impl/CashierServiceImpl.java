package Impl;

import Interface.CashierService;
import Model.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static Model.StoreColour.*;

public class CashierServiceImpl implements CashierService {

    @Override
    public String sellProduct(Customer customer) {
        List<Product> products = ConvenienceStore.getProductList();
        CustomerServiceImpl customerAction = new CustomerServiceImpl();
        double productCost = 0.0;
        Product product;
        for (ShoppingCart shoppingCart : customer.getCart()) {
            product = shoppingCart.getProduct();
            if (product.getProductQuantity() == 0) {
                product.isAvailable();
//                product.setProductAvailability("OUT OF STOCK");
            }
            if (customer.getMoney() >= shoppingCart.getTotalPrice()) {
                customer.setMoney(customer.getMoney() - shoppingCart.getTotalPrice());
            } else return "You have insufficient balance to complete this transaction.";
        }
        issueReceipt(customer);
        customerAction.emptyCart(customer);
        return customer.getFirstName() + " has successfully made a purchase.";
    }

        @Override
        public String issueReceipt (Customer customer){
            StringBuilder products = new StringBuilder();
            double productCost = 0.0;
            for (ShoppingCart shoppingCart : customer.getCart()) {
                products.append(String.format("- %s         %s              %s%n", shoppingCart.getProduct().getProductName()
                        , shoppingCart.getProductQuantity(), shoppingCart.getProduct().getProductPrice()));
                productCost += shoppingCart.getTotalPrice();
            }
            if (products.isEmpty()){
                String message = String.format(ANSI_RED + "%n==============================================================%n"
                        + "  ================== Transaction Receipt =================== %n"
                        + "==============================================================%n"
                        + "Transaction failed! %n"
                        + "Customer Name: %s.%n"
                        + "==============================================================%n", customer.getFirstName());
                System.out.println(message);
                return message;
            } else {
                String receipt = String.format(ANSI_GREEN + "%n==============================================================%n"
                                + "  ================== Transaction Receipt =================== %n"
                                + "==============================================================%n"
                                + "Transaction Successful! %n" +
                                "Customer Name: %s.%n" +
                                "  Product           Quantity       Price%n" +
                                "%s        %n" +
                                "Total:            %s%n" +
                                "==============================================================%n", customer.getFirstName()
                        , products, productCost);

                System.out.println(receipt);
                return receipt;
            }
        }

        @Override
        public void attendToThread (LinkedList <Customer> queue) throws IOException {
            int coreCount = Runtime.getRuntime().availableProcessors();
            ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

            try {
                while (!queue.isEmpty()) {
                    executorService.submit(() -> {
                        Customer customer = queue.remove();
                        System.out.println(ANSI_PURPLE + customer.getFirstName() + " is being attended to on "
                                + Thread.currentThread().getName());
                        long delayTime = customer.getQuantity() * 1000L;
                        try {
                            Thread.sleep(delayTime);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        sellProduct(customer);
                    });
                }
            } finally {
                executorService.shutdown();
            }
        }
    }