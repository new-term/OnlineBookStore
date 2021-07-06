package com.example.bookstore.Utils;

import com.example.bookstore.JavaBean.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUtils {

    public static ArrayList<Book> getBookListFromJson(String Json){
        ArrayList<Book> books = new ArrayList<>();
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        books = gson.fromJson(Json, type);
        return books;
    }

}
