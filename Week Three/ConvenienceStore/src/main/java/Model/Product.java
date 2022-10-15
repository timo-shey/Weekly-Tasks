package Model;

public class Product {

    private String productCategory;
    private double productPrice;
    private String productName;
    private int productQuantity;
    private String productAvailability;


    public Product(String productCategory, double productPrice, String productName, int productQuantity) {
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productQuantity = productQuantity;
        isAvailable();
    }

    public Product(){}

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(String productAvailability) {
        this.productAvailability = productAvailability;
    }

    public void isAvailable() {
        if (this.getProductQuantity() == 0)
            this.setProductAvailability("OUT OF STOCK");
        else this.setProductAvailability("AVAILABLE");
    }

    @Override
    public String toString() {
        return " Product { " +
                " ProductCategory= '" + productCategory + '\'' +
                ", ProductPrice= " + productPrice +
                ", ProductName= '" + productName + '\'' +
                ", ProductQuantity= " + productQuantity +
                ", ProductAvailability= '" + productAvailability + '\'' +
                '}';
    }
}
