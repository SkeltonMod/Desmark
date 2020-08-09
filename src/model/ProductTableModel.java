package model;

public class ProductTableModel {

    private String id;
    private String productName;
    private String productCode;
    private int stocks;

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

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public ProductTableModel(String id, String productName, String productCode, int stocks) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.stocks = stocks;
    }
}
