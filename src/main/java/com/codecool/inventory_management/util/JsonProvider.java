package com.codecool.inventory_management.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class JsonProvider {
    private Gson gson;

    public JsonProvider() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new JsonExclusionStrategy());
        this.gson = gsonBuilder.create();
    }

    public <O> String stringify(List<O> objectList) {
        return gson.toJson(objectList);
    }

    public <O> String stringify(O object) {
        return gson.toJson(object);
    }

    public void sendJson(HttpServletResponse resp, String json) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        out.print(json);
        out.flush();
    }
}
