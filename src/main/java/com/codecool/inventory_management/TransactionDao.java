package com.codecool.inventory_management;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

import java.util.List;

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
        FindIterable<Transaction> transactions =
                connection.getCollection("Transaction")
                          .withDocumentClass(Transaction.class)
                          .find(Filters.eq("inventoryId", inventoryId));

        return MongoCollectionExtractor.extract(transactions);
    }

    public Transaction getTransactionBy(ObjectId transactionId) {
        return connection.getCollection("Transaction")
                         .withDocumentClass(Transaction.class)
                         .find(Filters.eq("id", transactionId))
                         .first();
    }

    public List<Transaction> getAllTransactions() {
        FindIterable<Transaction> transactions =
                connection.getCollection("Transaction")
                          .withDocumentClass(Transaction.class)
                          .find();

        return MongoCollectionExtractor.extract(transactions);
    }
}
