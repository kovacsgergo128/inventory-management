package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.ConnectionHandler;
import com.codecool.inventory_management.Inventory;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;


import java.util.List;

public class InventoryDaoMongoDB implements InventoryDao {
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

    @Override
    public void addNewInventory(Inventory inventory) {

    }

    @Override
    public void removeInventory(ObjectId _id ) {

    }

    @Override
    public Inventory findInventory(ObjectId _id) {
        return null;
    }

    @Override
    public List<Inventory> getAllInventories() {
        return null;
    }

    @Override
    public void addItemToInventory() {

    }
}
