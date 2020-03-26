package com.codecool.inventory_management.controller;

import com.codecool.inventory_management.dao.TransactionDao;
import com.codecool.inventory_management.model.Transaction;
import com.codecool.inventory_management.util.JsonProvider;
import com.codecool.inventory_management.util.JsonReader;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/transactions")
public class TransactionController extends HttpServlet {

    private TransactionDao transactionDao = TransactionDao.getInstance();
    private JsonProvider jsonProvider = new JsonProvider();
    private JsonReader jsonReader = new JsonReader();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getPathInfo() == null)
            jsonProvider.sendJson(resp, jsonProvider.stringify(transactionDao.getAllTransactions()));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getPathInfo() == null) {
            Transaction newTransaction = jsonReader.parse(req, Transaction.class);
            transactionDao.saveNewTransaction(newTransaction);
        }

    }
}
