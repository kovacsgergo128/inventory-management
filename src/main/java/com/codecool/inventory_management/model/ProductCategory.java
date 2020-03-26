package com.codecool.inventory_management.model;

import com.codecool.inventory_management.util.ObjectIdTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import org.bson.types.ObjectId;

public class ProductCategory {
    @JsonAdapter(ObjectIdTypeAdapter.class)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCategory)) return false;

        ProductCategory that = (ProductCategory) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
