package Model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class ConvenienceStore {

    private static List<Product> productList = new ArrayList<>();
    private List<Staff> staff;
    private List<Applicant> applicants;
    private String storeName;


    public ConvenienceStore(String storeName) {
        this.storeName = storeName;
        this.applicants = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) { this.productList = productList;}

    public List<Staff> getStaff() { return staff; }

    public void setStaff(List<Staff> staff) { this.staff = staff; }

    public List<Applicant> getApplicants() { return applicants; }

    public void setApplicants(List<Applicant> applicants) { this.applicants = applicants; }

    String path = "/Users/timileyin/IdeaProjects/ConvenienceStore/src/ConvenienceStore.csv";

    public void addProducts(String path) throws IOException {
        List<Product> allProducts = getProductList();
        BufferedReader reader = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                if (row[1].equals("Unit Price")) {
                    continue;
                }
                String category = row[0];
                double price = Double.parseDouble(row[1]);
                String name = row[2];
                int quantity = Integer.parseInt(row[3]);
                Product product = new Product(category, price, name, quantity);
                allProducts.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setProductList(allProducts);
    }
}