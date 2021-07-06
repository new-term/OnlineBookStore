package com.example.bookstore.JavaBean;

import com.example.bookstore.Utils.SQLHelper;
import com.example.bookstore.Utils.SQLSetting;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;

public class Book {
    private String bookName;
    private String ISBN;
    private BigDecimal price;
    private int count;

    public Book(String bookName, String ISBN, BigDecimal price, int count) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.price = price;
        this.count = count;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean insertBook(){
        //TODO:向服务器发出请求
        boolean bIsSuccess = false;

        return bIsSuccess;
    }
}
