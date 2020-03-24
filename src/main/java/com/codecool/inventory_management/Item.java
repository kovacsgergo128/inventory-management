package com.codecool.inventory_management;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator
public class Item {
    @BsonProperty(useDiscriminator = true)
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }
}
