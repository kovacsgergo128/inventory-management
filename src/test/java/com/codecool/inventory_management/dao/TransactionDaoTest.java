package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.*;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionDaoTest {
    private TransactionDao transactionDao = null;

    @BeforeEach
    public void init() {
        this.transactionDao = TransactionDao.getInstance();
    }

    @Test
    public void sanityCheck() {
        assertNotNull(this.transactionDao);
    }

    @Test
    public void testGetAllTransactionsOf() {
        ObjectId inventoryId = new ObjectId("5e79fa69e0e42b7d3f9323fc");
        System.out.println(transactionDao.getAllTransactionsOf(inventoryId).get(0));
        assertNotNull(transactionDao.getAllTransactionsOf(inventoryId).get(0));
        assertEquals(inventoryId, transactionDao.getAllTransactionsOf(inventoryId).get(0).getInventoryId());
    }

    @Test
    public void testGetTransactionBy() {
        ObjectId transactionId = new ObjectId("5e79fa24e0e42b7d3f9323fb");
        System.out.println(transactionDao.getTransactionBy(transactionId));
        assertNotNull(transactionDao.getTransactionBy(transactionId));
        assertEquals(transactionId, transactionDao.getTransactionBy(transactionId).getId());
    }

    @Test
    public void testSaveNewTransaction() {
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

        Transaction newTransaction = new Transaction(
                new ObjectId("5e79fa69e0e42b7d3f9323fc"),
                List.of(item1, item2),
                TransactionType.PURCHASE
        );
        ObjectId newTransactionId = newTransaction.getId();

        assertNull(transactionDao.getTransactionBy(newTransactionId));
        transactionDao.saveNewTransaction(newTransaction);
        assertNotNull(transactionDao.getTransactionBy(newTransactionId));
    }
}
