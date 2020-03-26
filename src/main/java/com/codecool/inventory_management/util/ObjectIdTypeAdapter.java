package com.codecool.inventory_management.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.bson.types.ObjectId;

import java.io.IOException;

public class ObjectIdTypeAdapter extends TypeAdapter<ObjectId> {
    @Override
    public void write(JsonWriter out, ObjectId value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        String objectId = value.toHexString();
        out.value(objectId);
    }

    @Override
    public ObjectId read(JsonReader in) throws IOException {
        return null;
    }
}
