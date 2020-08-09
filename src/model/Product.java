package model;

public class Product {
    private String id;
    private String productName;
    private String productCode;
    private String description;
    private int stocks;
    private double price;

    public void ProductData(String productName, String productCode, String description, int stocks, double price) {
        this.productName = productName;
        this.productCode = productCode;
        this.description = description;
        this.stocks = stocks;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
