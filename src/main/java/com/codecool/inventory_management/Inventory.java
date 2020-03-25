package com.codecool.inventory_management;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@BsonDiscriminator
public class Inventory {

    @BsonId
    private ObjectId _id;
    private String name;
    private List<Item> items = new ArrayList<>();


    public Inventory() {
    }

    public Inventory(String name) {
        this._id = new ObjectId();
        this.name = name;
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
}
