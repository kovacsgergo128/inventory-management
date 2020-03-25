package com.codecool.inventory_management.dao;

import com.codecool.inventory_management.model.Product;
import com.codecool.inventory_management.model.ProductCategory;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoTest {

    private ProductDao productDao;
    private ProductCategory productCategory;
    private Product product;
    private ObjectId newProductId;

    @BeforeEach
    public void init() {
        this.productDao = ProductDao.getInstance();
        createProductRelatedObjects();
    }

    @AfterEach
    public void removeAddedProduct(TestInfo info) {
        if(!info.getTags().contains("removeAddedProduct")) return;
        productDao.remove(newProductId);
    }

    @Test
    @Tag("removeAddedProduct")
    public void addProductToDatabaseTest() {
        assertNull(productDao.getProductBy(newProductId));
        productDao.add(product);
        assertNotNull(productDao.getProductBy(newProductId));

    }

    @Test
    public void removeProductFromDatabaseTest() {
        productDao.add(product);
        assertNotNull(productDao.getProductBy(newProductId));
        productDao.remove(newProductId);
        assertNull(productDao.getProductBy(newProductId));
    }

    @Test
    @Tag("removeAddedProduct")
    public void testGetProductById() {
        productDao.add(product);
        Product result = productDao.getProductBy(newProductId);
        assertEquals(product, result);
    }

    @Test
    @Tag("removeAddedProduct")
    public void testGetProductByArticleNumber() {
        int newProductArticleNumber = product.getArticleNumber();
        productDao.add(product);
        Product result = productDao.getProductBy(newProductArticleNumber);
        assertEquals(product, result);
    }

    @Test
    @Tag("removeAddedProduct")
    public void testGetProductsByProductCategory() {
        productDao.add(product);
        Product result = productDao.getProductsBy(productCategory).get(0);
        assertEquals(product, result);
    }

    @Test
    public void testGetAllProducts() {
        ObjectId id = new ObjectId("5e78febe1b65c45a7b03baa3");
        Product product = productDao.getProductBy(id);
        Product result = productDao.getAllProducts().get(0);
        assertEquals(product, result);
    }

    private void createProductRelatedObjects() {
        this.productCategory = new ProductCategory(new ObjectId("5e78fe2a1b65c45a7b03baa2"), "Test Category 1");
        this.product = new Product(2122, "Test product 1", 100, 160, this.productCategory);
        this.newProductId = product.getId();
    }
}