package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.Product;
import com.codecool.inventory_management.model.ProductCategory;
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
        ProductCategory productCategory1 = new ProductCategory(new ObjectId("5e78fe2a1b65c45a7b03baa2"), "Fruit");
        Product product1 = new Product(9, "Test product 1", 100, 160, productCategory1);
        ObjectId newProductId = product1.getId();
        assertNull(productDao.getProductBy(newProductId));
        productDao.add(product1);
        assertNotNull(productDao.getProductBy(newProductId));

    }

    // QUESTION:
    // How can I avoid to create a product for the test case below too?
    // I would like to use the product id created in addTest and remove that product from the database.
    // Or is it impossible because test cases are independent from each other?
    // Solution: Should I create a Constructor for testing purposes?
    @Test
    public void removeProductFromDatabaseTest() {
        ProductCategory productCategory1 = new ProductCategory(new ObjectId("5e78fe2a1b65c45a7b03baa2"), "Fruit");
        Product product1 = new Product(9, "Test product 1", 100, 160, productCategory1);
        ObjectId newProductId = product1.getId();
        productDao.add(product1);
        assertNotNull(productDao.getProductBy(newProductId));
        productDao.remove(newProductId);
        assertNull(productDao.getProductBy(newProductId));
    }

}