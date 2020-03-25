package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.util.ConnectionHandler;
import com.codecool.inventory_management.model.Inventory;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

import java.util.List;

public class InventoryDao {
    private static InventoryDao inventoryDao;
    private  MongoDatabase connection;

    private InventoryDao() {
        connection = ConnectionHandler.getInstance().getDatabase();

    }

    public InventoryDao getInstance(){
        if (inventoryDao == null) {
            inventoryDao = new InventoryDao();
        }
        return inventoryDao;
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
