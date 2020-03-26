package com.codecool.inventory_management.model;

import com.codecool.inventory_management.util.ObjectIdTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    @JsonAdapter(ObjectIdTypeAdapter.class)
    private ObjectId id;
    private ObjectId inventoryId;
    private LocalDateTime date;
    private List<Item> items = new ArrayList<>();
    private TransactionType type;

    public Transaction(ObjectId inventoryId, List<Item> items, TransactionType type) {
        this.id = new ObjectId();
        this.inventoryId = inventoryId;
        this.date = LocalDateTime.now();
        this.items = items;
        this.type = type;
    }

    public Transaction() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
                "id: " + id +
                ", inventoryId: " + inventoryId +
                ", date: " + date +
                ", items: " + items +
                ", type: " + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
