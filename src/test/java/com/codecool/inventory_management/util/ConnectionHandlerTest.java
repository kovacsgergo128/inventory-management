package com.codecool.inventory_management.util;

import com.codecool.inventory_management.util.ConnectionHandler;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ConnectionHandlerTest {

    private MongoDatabase connection = null;

    @BeforeEach
    public void init() {
        this.connection = ConnectionHandler.getInstance().getDatabase();
    }

    @Test
    public void sanityCheck() {
        assertNotNull(connection);
    }

    @Test
    public void reachDatabaseExistsTest() {
        assertNotNull(this.connection.listCollectionNames().first());
    }

    @Test
    public void reachCollectionExistsAndHasDocumentTest() {
        assertNotNull(this.connection.getCollection("Product").find().first());
    }

    @Test
    public void reachCollectionNotExistsTest() {
        assertNull(this.connection.getCollection("NotExist").find().first());
    }
}
