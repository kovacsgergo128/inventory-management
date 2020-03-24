package com.codecool.inventory_management;

public enum TransactionType {
    SALE("decrease"),
    PURCHASE("increase");

    private String direction;

    TransactionType() {
    }

    TransactionType(String direction) {
        this.direction = direction;
    }


}
