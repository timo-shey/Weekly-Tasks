package Interface.Impl;

import Interface.CashierInterface;
import Model.Customer;
import Model.Product;

public class CashierServiceImpl implements CashierInterface {

    @Override
    public boolean sellProduct(Customer customer, Product product) {
        if(customer.getMoney() >= product.getProductPrice() * customer.getUnitsOfProduct()) {
            return true;
        }
        return false;
    }

    @Override
    public String issueReceipt(Customer customer, Product product) {
        double change = customer.getMoney() - (product.getProductPrice() * customer.getUnitsOfProduct());
        double extraAmount = (product.getProductPrice() * customer.getUnitsOfProduct() - customer.getMoney());
        if(sellProduct(customer, product) == true) {
            return "==============================================================\n"
                    + "  ================== Transaction Receipt =================== \n"
                    + "==============================================================\n"
                    + customer.getFirstName() + " " + customer.getLastName() + ", your purchase is successful.\n" + "\n"
                    + "Product Name:     " + product.getProductName() + "\n" + "Product Amount:   "
                    + product.getProductPrice() + "\n" + "Product Quantity: " + customer.getUnitsOfProduct() + "\n"
                    + "\n" + "==============================================================\n" + "     Grand Total:  "
                    + product.getProductPrice() * customer.getUnitsOfProduct() + "      ||      Change:  "
                    + change + "\n" + "==============================================================";
        }
        return "==================================================================\n"
                + "   =================== Transaction Receipt ====================\n"
                + "==================================================================\n" +  "\n"
                + "    Transaction not successful. You don't have enough money!\n" + "You need an extra amount of "
                + extraAmount + " to complete this transaction.\n"
                + "\n" + "==================================================================";
    }
}
