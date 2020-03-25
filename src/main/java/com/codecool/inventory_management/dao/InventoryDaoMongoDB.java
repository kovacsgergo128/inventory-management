package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.util.ConnectionHandler;
import com.codecool.inventory_management.Inventory;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

import java.util.List;

public class InventoryDaoMongoDB {
    private static InventoryDaoMongoDB instance;
    private  MongoDatabase connection;

    private InventoryDaoMongoDB() {
        connection = ConnectionHandler.getInstance().getDatabase();

    }

    public InventoryDaoMongoDB getInstance(){
        if (instance == null) {
            instance = new InventoryDaoMongoDB();
        }
        return instance;
    }

    public void addNewInventory(Inventory inventory) {

    }

    public void removeInventory(ObjectId _id ) {

    }


    public Inventory findInventory(ObjectId _id) {
        return null;
    }

    public List<Inventory> getAllInventories() {
        return null;
    }

    public void addItemToInventory() {

    }
}
