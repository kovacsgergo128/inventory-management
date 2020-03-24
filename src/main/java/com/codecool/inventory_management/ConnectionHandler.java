package com.codecool.inventory_management;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionHandler {

    private static final String CONNECTION_STRING =
            "mongodb+srv://inventory-user_1:inventory-user_1@inventory-management-mvcox.mongodb.net/test?retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "InventoryManagement";

    private static ConnectionHandler instance = null;

    private MongoClient mongoClient;

    private ConnectionHandler() {
        this.mongoClient = MongoClients.create(CONNECTION_STRING);
    }

    public static ConnectionHandler getInstance() {
        if (instance == null)
            instance = new ConnectionHandler();

        return instance;
    }

    public MongoDatabase getDatabase() {
        return this.mongoClient.getDatabase(DATABASE_NAME);
    }
}
