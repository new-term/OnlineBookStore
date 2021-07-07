package com.example.bookstore.Utils;

import com.example.bookstore.JavaBean.Book;
import com.example.bookstore.JavaBean.Order;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class JsonUtils {

    private static final Gson gson = new Gson();

    public static ArrayList<Book> getBookListFromJson(String Json){
        ArrayList<Book> books = new ArrayList<>();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        books = gson.fromJson(Json, type);
        return books;
    }

    public static ArrayList<Order> getOrderListFromJson(String Json){
        ArrayList<Order> orders = new ArrayList<>();
        Type type = new TypeToken<ArrayList<Order>>(){}.getType();
        orders = gson.fromJson(Json, type);
        return orders;
    }

    public static String getJsonFromBookList(ArrayList<Book> books){
        return gson.toJson(books);
    }

    public static String getJsonFromMap(Map<String, String> map){
        return gson.toJson(map);
    }
}
