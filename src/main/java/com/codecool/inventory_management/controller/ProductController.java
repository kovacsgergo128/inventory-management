package com.codecool.inventory_management.controller;

import com.codecool.inventory_management.dao.ProductDao;
import com.codecool.inventory_management.model.Product;
import com.codecool.inventory_management.util.JsonProvider;
import com.codecool.inventory_management.util.JsonReader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/products/*")
public class ProductController extends HttpServlet {

    private ProductDao productDao = ProductDao.getInstance();
    private JsonProvider jsonProvider = new JsonProvider();
    private JsonReader jsonReader = new JsonReader();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getPathInfo() == null)
            jsonProvider.sendJson(resp, jsonProvider.stringify(productDao.getAllProducts()));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getPathInfo() == null) {
            Product newProduct = jsonReader.parse(req, Product.class);
            productDao.add(newProduct);
        }

    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getPathInfo() != null) {
            String[] routeComponents = req.getPathInfo().substring(1).split("/");

            if (routeComponents.length == 1) {
                Product updatedProduct = jsonReader.parse(req, Product.class);
            }
        }
    }
}
