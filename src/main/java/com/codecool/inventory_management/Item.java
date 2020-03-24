package com.codecool.inventory_management;

public class Item {
    private Product product;
    private int quantity;
    private int salePrice;

    public Item() {
    }

    public Item(Product product, int quantity, int salePrice) {
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }
}
