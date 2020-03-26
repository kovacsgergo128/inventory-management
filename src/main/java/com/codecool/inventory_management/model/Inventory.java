package com.codecool.inventory_management.model;

import com.codecool.inventory_management.util.ObjectIdTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {

    @JsonAdapter(ObjectIdTypeAdapter.class)
    private ObjectId id;
    private String name;
    private List<Item> items = new ArrayList<>();


    public Inventory() {
    }

    public Inventory(String name) {
        this.id = new ObjectId();
        this.name = name;
    }

    public Inventory(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public Inventory(ObjectId id, String name, List<Item> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addItemToInventory(Item item) {
        items.add(item);
    }
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return id.equals(inventory.id) &&
                name.equals(inventory.name) &&
                items.equals(inventory.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, items);
    }
}
