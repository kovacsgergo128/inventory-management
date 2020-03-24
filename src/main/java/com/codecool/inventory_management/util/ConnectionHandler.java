package com.codecool.inventory_management.util;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ConnectionHandler {

    private static ConnectionHandler instance = null;

    private static final ConnectionString CONNECTION_STRING = new ConnectionString(
            "mongodb+srv://inventory-user_1:inventory-user_1@inventory-management-mvcox.mongodb.net/test?retryWrites=true&w=majority"
    );
    private static final String DATABASE_NAME = "InventoryManagement";


    private MongoClient mongoClient;

    private ConnectionHandler() {
        this.mongoClient = initClient();
    }

    public static ConnectionHandler getInstance() {
        if (instance == null)
            instance = new ConnectionHandler();

        return instance;
    }

    public MongoDatabase getDatabase() {
        return this.mongoClient.getDatabase(DATABASE_NAME);
    }

    private MongoClient initClient() {
        CodecProvider codecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry codecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(codecProvider)
        );
        MongoClientSettings clientSettings =
                MongoClientSettings.builder()
                                   .applyConnectionString(CONNECTION_STRING)
                                   .codecRegistry(codecRegistry)
                                   .build();

        return MongoClients.create(clientSettings);
    }
}
