package com.codecool.inventory_management;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;

import java.util.List;

public class TransactionDao {
    private static TransactionDao transactionDao = null;
    private static final String COLLECTION_NAME = "Transaction";

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
                connection.getCollection(COLLECTION_NAME)
                          .withDocumentClass(Transaction.class)
                          .find(Filters.eq("inventoryId", inventoryId));

        return MongoCollectionExtractor.extract(transactions);
    }

    public Transaction getTransactionBy(ObjectId transactionId) {
        return connection.getCollection(COLLECTION_NAME)
                         .withDocumentClass(Transaction.class)
                         .find(Filters.eq("_id", transactionId))
                         .first();
    }

    public List<Transaction> getAllTransactions() {
        FindIterable<Transaction> transactions =
                connection.getCollection(COLLECTION_NAME)
                          .withDocumentClass(Transaction.class)
                          .find();

        return MongoCollectionExtractor.extract(transactions);
    }

    public void saveNewTransaction(Transaction transaction) {
        connection.getCollection(COLLECTION_NAME)
                  .withDocumentClass(Transaction.class)
                  .insertOne(transaction);
    }
}
