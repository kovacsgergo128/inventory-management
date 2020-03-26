package com.codecool.inventory_management.dao;


import com.codecool.inventory_management.model.Inventory;
import com.codecool.inventory_management.util.ConnectionHandler;
import com.codecool.inventory_management.util.MongoCollectionExtractor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

import java.util.List;

public class InventoryDao {
    private static InventoryDao inventoryDao;
    private MongoDatabase connection;
    public static final String COLLECTION_NAME = "Inventory";

    private InventoryDao() {
        connection = ConnectionHandler.getInstance().getDatabase();

    }

    public static InventoryDao getInstance() {
        if (inventoryDao == null) {
            inventoryDao = new InventoryDao();
        }
        return inventoryDao;
    }

    public void addNewInventory(Inventory inventory) {
        connection.getCollection(COLLECTION_NAME)
                .withDocumentClass(Inventory.class)
                .insertOne(inventory);
    }


    public void removeInventory(ObjectId id) {

    }


    public Inventory findInventory(ObjectId inventoryID) {
            return connection.getCollection(COLLECTION_NAME)
                    .withDocumentClass(Inventory.class)
                    .find(Filters.eq("_id", inventoryID))
                    .first();


    }

    public List<Inventory> getAllInventories() {
        FindIterable<Inventory> inventories =
                connection.getCollection(COLLECTION_NAME)
                        .withDocumentClass(Inventory.class)
                        .find();

        return MongoCollectionExtractor.extract(inventories);
    }

    public void addItemToInventory() {

    }
}
