package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.ProductCategory;
import com.codecool.inventory_management.util.ConnectionHandler;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ProductCategoryDao {

    private static ProductCategoryDao instance = null;
    private static final String COLLECTION_NAME = "ProductCategory";

    private MongoDatabase connection;
    private MongoCollection<ProductCategory> collection;

    private ProductCategoryDao() {
        this.connection = ConnectionHandler.getInstance().getDatabase();
        this.collection = connection.getCollection(COLLECTION_NAME, ProductCategory.class);
    }

    public static ProductCategoryDao getInstance() {
        if (instance == null)
            instance = new ProductCategoryDao();

        return instance;
    }

    public void add(ProductCategory productCategory) {
        collection.insertOne(productCategory);
    }





}
