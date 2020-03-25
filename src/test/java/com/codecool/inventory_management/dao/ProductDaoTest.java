package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.Product;
import com.codecool.inventory_management.model.ProductCategory;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoTest {

    private ProductDao productDao = null;
    private ProductCategory productCategory = null;
    private Product product = null;
    private ObjectId newProductId = null;

    @BeforeEach
    public void init() {
        this.productDao = ProductDao.getInstance();
        createProductRelatedObjects();
    }

    @Test
    public void addProductToDatabaseTest() {
        assertNull(productDao.getProductBy(newProductId));
        productDao.add(product);
        assertNotNull(productDao.getProductBy(newProductId));
        productDao.remove(newProductId);

    }

    @Test
    public void removeProductFromDatabaseTest() {
        productDao.add(product);
        assertNotNull(productDao.getProductBy(newProductId));
        productDao.remove(newProductId);
        assertNull(productDao.getProductBy(newProductId));
    }

    @Test
    public void testGetProductById() {
        productDao.add(product);
        Product result = productDao.getProductBy(newProductId);
        assertEquals(product, result);
        productDao.remove(newProductId);
    }

    @Test
    public void testGetProductByArticleNumber() {
        int newProductArticleNumber = product.getArticleNumber();
        productDao.add(product);
        Product result = productDao.getProductBy(newProductArticleNumber);
        assertEquals(product, result);
        productDao.remove(newProductId);
    }

    @Test
    public void testGetProductsByProductCategory() {
        productDao.add(product);
        Product result = productDao.getProductsBy(productCategory).get(0);
        assertEquals(product, result);
        productDao.remove(newProductId);
    }

    @Test
    public void testGetAllProducts() {
        ObjectId id = new ObjectId("5e78febe1b65c45a7b03baa3");
        Product product = productDao.getProductBy(id);
        Product result = productDao.getAllProducts().get(0);
        assertEquals(product, result);
    }

    private void createProductRelatedObjects() {
        this.productCategory = new ProductCategory(new ObjectId("5e78fe2a1b65c45a7b03baa2"), "Chocolate");
        this.product = new Product(2122, "Test product 1", 100, 160, this.productCategory);
        this.newProductId = product.getId();
    }
}