package Impl;

import Interface.ConvenienceStoreService;
import Model.*;

public class ConvenienceStoreServiceImpl implements ConvenienceStoreService {



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

