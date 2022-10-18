package Impl;

import CustomException.UsageException;
import Interface.CashierService;
import Model.*;

import java.util.Map;
import java.util.Queue;

public class CashierServiceImpl implements CashierService {
    @Override
    public String issueReceipt(ConvenienceStore convenienceStore, Customer customer, Staff staff) {
        return "==============================================================\n"
                + "  ================== Transaction Receipt =================== \n"
                + "==============================================================\n"
                + "Store name: " + convenienceStore.getStoreName() + "\n"
                + customer.getFirstName() + " " + customer.getLastName() + ", your purchase is successful.\n"
                + "Seller: " + staff.getFirstName() + " " + staff.getLastName()
                + "==============================================================\n";
    }
}
