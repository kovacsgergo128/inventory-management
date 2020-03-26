package com.codecool.inventory_management.model;

import com.codecool.inventory_management.util.ObjectIdTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import org.bson.types.ObjectId;

public class Item {

    @JsonAdapter(ObjectIdTypeAdapter.class)
    private ObjectId id;

    private Product product;
    private int quantity;

    public Item() {
    }

    public Item(Product product, int quantity) {
        this.id = new ObjectId();
        this.product = product;
        this.quantity = quantity;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Item{" +
                "id: " + id +
                ", product: " + product +
                ", quantity: " + quantity +
                '}';
    }
}
