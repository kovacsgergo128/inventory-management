package com.codecool.inventory_management;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class TransactionDao {
    private static TransactionDao transactionDao = null;

    private MongoDatabase connection;


    private TransactionDao() {
        this.connection = ConnectionHandler.getInstance().getDatabase();
    }

    public static TransactionDao getInstance() {
        if (transactionDao == null)
            transactionDao = new TransactionDao();

        return transactionDao;
    }

    public List<Transaction> getAllTransactionsOf(ObjectId inventoryId) {
        List<Transaction> result = new ArrayList<>();
        FindIterable<Transaction> transactions =
                connection.getCollection("Transaction")
                          .withDocumentClass(Transaction.class)
                          .find(Filters.eq("inventoryId", inventoryId));

        for (Transaction transaction : transactions) result.add(transaction);

        return result;
    }
}
