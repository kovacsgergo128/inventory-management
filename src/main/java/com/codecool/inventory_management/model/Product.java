package com.codecool.inventory_management.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Product {

    private ObjectId id;
    @BsonProperty(value = "article number")
    private int articleNumber;
    private String name;
    @BsonProperty(value = "purchase price")
    private double purchasePrice;
    @BsonProperty(value = "sale price")
    private double salePrice;
    @BsonProperty(value = "product_category_id")
    private ObjectId productCategoryId;
    @BsonProperty(value = "product category")
    private ProductCategory productCategory;

    public Product(){}

    public Product(int articleNumber, String name, double purchasePrice, double salePrice, ProductCategory productCategory) {
        this.id = new ObjectId();
        this.articleNumber = articleNumber;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.productCategory = productCategory;
    }


    // QUESTION: Variables => final?

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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", articleNumber=" + articleNumber +
                ", name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", salePrice=" + salePrice +
                ", productCategoryId=" + productCategoryId +
                ", productCategory=" + productCategory +
                '}';
    }
}
