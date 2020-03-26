package com.codecool.inventory_management.controller;

import com.codecool.inventory_management.dao.InventoryDao;
import com.codecool.inventory_management.util.JsonProvider;
import org.bson.types.ObjectId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "default",urlPatterns = {"/inventories/*"})
public class InventoryController extends HttpServlet {
    private InventoryDao inventoryDao = InventoryDao.getInstance();
    private JsonProvider jsonProvider = new JsonProvider();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(filteredFaviconRequest(req, resp))
            return;
        try {
            String[] params = req.getPathInfo().substring(1).split("/");

        } catch (NullPointerException ignored) {}

        jsonProvider.sendJson(resp, jsonProvider.stringify(inventoryDao.getAllInventories()));
    }

    private boolean filteredFaviconRequest(HttpServletRequest req, HttpServletResponse resp) {
        if ("/favicon.ico".equals(req.getRequestURI())) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return true;
        }
        else {
            return false;
        }
    }
}
