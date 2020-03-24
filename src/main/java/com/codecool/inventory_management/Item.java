package com.codecool.inventory_management;

import org.bson.types.ObjectId;

public class Item {
    private ObjectId _id;
    private Product product;
    private int quantity;

    public Item() {
    }

    public Item(Product product, int quantity) {
        this._id = new ObjectId();
        this.product = product;
        this.quantity = quantity;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
