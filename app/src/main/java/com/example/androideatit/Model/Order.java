package com.example.androideatit.Model;

public class Order {
    private String ProductId;
    private String ProductName;
    private String Quantity;
    private String Price;
    private String Discout;

    public Order() {
    }

    public Order(String productId, String productName, String quantity, String price, String discout) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
        Price = price;
        Discout = discout;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscout() {
        return Discout;
    }

    public void setDiscout(String discout) {
        Discout = discout;
    }
}
