package com.codecool.inventory_management.controller;

import com.codecool.inventory_management.dao.InventoryDao;
import com.codecool.inventory_management.dao.TransactionDao;
import com.codecool.inventory_management.model.Inventory;
import com.codecool.inventory_management.model.Item;
import com.codecool.inventory_management.util.JsonProvider;
import com.codecool.inventory_management.util.JsonReader;
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
    private TransactionDao transactionDao = TransactionDao.getInstance();
    private JsonProvider jsonProvider = new JsonProvider();
    private JsonReader jsonReader = new JsonReader();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(filteredFaviconRequest(req, resp))
            return;
        try {
            String[] params = req.getPathInfo().substring(1).split("/");
            ObjectId inventoryId = new ObjectId(params[0]);
            Inventory inventory = inventoryDao.findInventory(inventoryId);
            if (params.length == 1) {
                jsonProvider.sendJson(resp, jsonProvider.stringify(inventory));
                return;
            }
            else if (params[1].equals("items")) {
                jsonProvider.sendJson(resp, jsonProvider.stringify(inventory.getItems()));
                return;
            }

            else if (params[1].equals("transactions"))
                jsonProvider.sendJson(resp, jsonProvider.stringify(transactionDao.getAllTransactionsOf(inventoryId)));
            return;

        } catch (NullPointerException | IllegalArgumentException ignored) {}

        jsonProvider.sendJson(resp, jsonProvider.stringify(inventoryDao.getAllInventories()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String[] params = req.getPathInfo().substring(1).split("/");
            ObjectId inventoryId = new ObjectId(params[0]);
            if (params[1].equals("items")) {
                Item newItem = jsonReader.parse(req, Item.class);
                inventoryDao.addItemToInventory(inventoryId, newItem);
            }
            return;
        } catch (NullPointerException ignored) {}

        Inventory newInventory = jsonReader.parse(req, Inventory.class);
        inventoryDao.addNewInventory(newInventory);

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
