package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.*;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryDaoTest {
    InventoryDao inventoryDao = null;

    private Inventory createTestInventory(String inventoryName) {
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
        Inventory myInventory = new Inventory(inventoryID, inventoryName, List.of(item1, item2));
        return myInventory;
    }

    @BeforeEach
    public void init() {
        this.inventoryDao = InventoryDao.getInstance();
    }

    @Test
    public void testFindInventory() {
        Inventory inventoryToFind = createTestInventory("inventoryToFind");
        inventoryDao.addNewInventory(inventoryToFind);
        ObjectId inventoryID = inventoryToFind.getId();
        assertNotNull(inventoryDao.findInventory(inventoryID));
        assertEquals(inventoryID, inventoryDao.findInventory(inventoryID).getId());
    }
    @Test
    public void testAddNewInventory() {
        Inventory myInventory = createTestInventory("myNewInventory");
        ObjectId inventoryID = myInventory.getId();
        assertNull(inventoryDao.findInventory(inventoryID));
        inventoryDao.addNewInventory(myInventory);
        assertNotNull(inventoryDao.findInventory(inventoryID));
    }
    @Test
    public void testUpdateInventory() {
        Inventory updateTestInventory = createTestInventory("updateTestInventory");
        ObjectId inventoryID = updateTestInventory.getId();
        inventoryDao.addNewInventory(updateTestInventory);
        assertNotNull(inventoryDao.findInventory(inventoryID));
        updateTestInventory.setName("updatedInventory");
        assertNotEquals(updateTestInventory, inventoryDao.findInventory(inventoryID));
        inventoryDao.updateInventory(updateTestInventory);
        assertEquals(updateTestInventory.getName(), inventoryDao.findInventory(inventoryID).getName());
        System.out.println(updateTestInventory);
        System.out.println(inventoryDao.findInventory(inventoryID));

    }

    @Test
    public void testRemoveInventory() {
        Inventory removeTestInventory = createTestInventory("removeTestInventory");
        ObjectId inventoryId = removeTestInventory.getId();
        inventoryDao.addNewInventory(removeTestInventory);
        assertEquals(removeTestInventory.getId(), inventoryDao.findInventory(inventoryId).getId());
        inventoryDao.removeInventory(inventoryId);
        assertNull(inventoryDao.findInventory(inventoryId));

    }
}