package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.Product;
import com.codecool.inventory_management.util.ConnectionHandler;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ProductDao {

    private static ProductDao instance = null;
    public static final String COLLECTION_NAME = "Product";
    private MongoDatabase connection;
    private MongoCollection<Product> collection;


    private ProductDao() {
        this.connection = ConnectionHandler.getInstance().getDatabase();
        this.collection = connection.getCollection(COLLECTION_NAME, Product.class);
    }

    public static ProductDao getInstance() {
        if (instance == null)
            instance = new ProductDao();

        return instance;
    }



}
