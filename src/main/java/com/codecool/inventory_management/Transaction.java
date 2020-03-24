package com.codecool.inventory_management;

import com.codecool.inventory_management.Item;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private ObjectId _id;
    private ObjectId inventoryId;
    private LocalDateTime date;
    private List<Item> items = new ArrayList<>();
    private TransactionType type;

    public Transaction(ObjectId inventoryId, List<Item> items, TransactionType type) {
        this._id = new ObjectId();
        this.inventoryId = inventoryId;
        this.date = LocalDateTime.now();
        this.items = items;
        this.type = type;
    }

    public Transaction() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public ObjectId getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(ObjectId inventoryId) {
        this.inventoryId = inventoryId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "_id: " + _id +
                ", inventoryId: " + inventoryId +
                ", date: " + date +
                ", items: " + items +
                ", type: " + type +
                '}';
    }
}
