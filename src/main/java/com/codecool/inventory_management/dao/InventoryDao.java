package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.Inventory;
import org.bson.types.ObjectId;

import java.util.List;

public interface InventoryDao {
    void addNewInventory(Inventory inventory);

    void removeInventory(ObjectId _id);

    Inventory findInventory(ObjectId _id);

    List<Inventory> getAllInventories();

    void addItemToInventory();


}
