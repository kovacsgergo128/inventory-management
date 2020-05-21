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
        ObjectId inventoryID = new ObjectId("5e7cdd1437c26d352e40d13a");
        assertNotNull(inventoryDao.findInventory(inventoryID));
        assertEquals(inventoryID, inventoryDao.findInventory(inventoryID).getId());
    }
    @Test
    public void addNewInventory() {
        ProductCategory productCategory1 = new ProductCategory(
                new ObjectId("5e78fe2a1b65c45a7b03baa2"),
                "Fruit"
        );
        Product product1 = new Product(
                111,
                "Test product 1",
                100,
                160,
                productCategory1
        );
        Product product2 = new Product(
                321,
                "Test product 2",
                120,
                180,
                productCategory1
        );

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