package com.codecool.inventory_management.model;

import org.bson.types.ObjectId;

public class ProductCategory {

    private ObjectId id;
    private String name;

    public ProductCategory() {
    }

    public ProductCategory(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
