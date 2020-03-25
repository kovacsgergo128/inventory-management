package com.codecool.inventory_management.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Inventory {


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

    public void addProductToInventory(Item item) {
        items.add(item);
    }

    public void removeItemFromInventory(Item item) {
        items.remove(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
