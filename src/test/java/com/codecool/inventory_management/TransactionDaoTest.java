package com.codecool.inventory_management;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
