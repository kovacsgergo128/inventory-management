package com.codecool.inventory_management.controller;

import com.codecool.inventory_management.dao.TransactionDao;
import com.codecool.inventory_management.util.JsonProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "default",urlPatterns = {"/"})
public class MainController extends HttpServlet {
    private TransactionDao transactionDao = TransactionDao.getInstance();
    private JsonProvider jsonProvider = new JsonProvider();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(filteredFaviconRequest(req, resp))
            return;

        sendJson(resp, jsonProvider.stringify(transactionDao.getAllTransactions()));
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

    private void sendJson(HttpServletResponse resp, String json) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }


}
