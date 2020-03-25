package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.*;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryDaoTest {
    InventoryDao inventoryDao = null;

    @BeforeEach
    public void init() {
        this.inventoryDao = InventoryDao.getInstance();
    }

    @Test
    public void findInventory() {
        ObjectId inventoryID = new ObjectId("5e7b3faf6a9b9c96ba2bccb4");
        assertNotNull(inventoryDao.findInventory(inventoryID));
        assertEquals(inventoryID, inventoryDao.findInventory(inventoryID).getId());
    }
    @Test
    public void addNewInventory() {
        Product product1 = new Product("Test product 1", new ObjectId("5e78fe2a1b65c45a7b03baa2"));
        Product product2 = new Product("Test product 2", new ObjectId("5e78fe2a1b65c45a7b03baa2"));

        Item item1 = new Item(product1, 4);
        Item item2 = new Item(product2, 6);
        ObjectId inventoryID = new ObjectId();

        Inventory myInventory = new Inventory(inventoryID,"myInventory", List.of(item1, item2));
        System.out.println(myInventory.toString());
        assertNull(inventoryDao.findInventory(inventoryID));
        inventoryDao.addNewInventory(myInventory);
        assertNotNull(inventoryDao.findInventory(inventoryID));
    }
}