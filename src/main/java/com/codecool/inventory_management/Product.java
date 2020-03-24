package com.codecool.inventory_management;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Product {

    private ObjectId id;
    private String name;
    @BsonProperty(value = "product_catgory_id")
    private ObjectId productCategoryId;

    public Product(){}

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

    public ObjectId getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(ObjectId productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "_id: " + id +
                ", name: '" + name + '\'' +
                ", productCategoryId: " + productCategoryId +
                '}';
    }
}
