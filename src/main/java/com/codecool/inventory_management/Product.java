package com.codecool.inventory_management;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Product {

    private ObjectId id;
    private String name;
    @BsonProperty(value = "product_catgory_id")
    private ObjectId productCategoryId;

    public Product(){}

    public Product(String name, ObjectId productCategoryId) {
        this.id = new ObjectId();
        this.name = name;
        this.productCategoryId = productCategoryId;
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

    public ObjectId getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(ObjectId productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", productCategoryId: " + productCategoryId +
                '}';
    }
}
