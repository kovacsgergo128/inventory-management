package com.codecool.inventory_management.util;

import com.mongodb.client.FindIterable;

import java.util.ArrayList;
import java.util.List;

public class MongoCollectionExtractor {

    public static <E> List<E> extract(FindIterable<E> queryResult) {
        List<E> result = new ArrayList<>();
        for (E element : queryResult) {
            result.add(element);
        }

        return result;
    }
}
