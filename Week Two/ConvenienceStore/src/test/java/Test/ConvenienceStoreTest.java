package Test;

import CustomException.UsageException;
import Impl.ConvenienceStoreServiceImpl;
import Impl.CustomerServiceImpl;
import Interface.ConvenienceStoreService;
import Interface.CustomerService;
import Interface.ManagerService;
import Impl.ManagerServiceImpl;
import Model.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConvenienceStoreTest {

    @Test
    public void shouldPopulateProductListFromCSVFile() throws UsageException, IOException {
        String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/src/ConvenienceStore.csv";
        List<Product> expected = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if(row[1].equals("price")) {
                    continue;
                }
                expected.add(new Product());
            }
        }
        ConvenienceStore store = new ConvenienceStore("Digistore");
        store.addProducts(path);
        List<Product> actual = store.getProductList();
        assertEquals(expected.size(), actual.size(), 0);
    }

}