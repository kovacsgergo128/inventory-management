package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.Product;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoTest {

    private ProductDao productDao = null;

    @BeforeEach
    public void init() {
        this.productDao = ProductDao.getInstance();
    }

    @Test
    public void addProductToDatabaseTest() {
        Product product1 = new Product(9, "Test product 1", 100, 160, new ObjectId("5e78fe2a1b65c45a7b03baa2"));
        ObjectId newProductId = product1.getId();
        assertNull(productDao.getProductBy(newProductId));
        productDao.add(product1);
        assertNotNull(productDao.getProductBy(newProductId));

    }
}