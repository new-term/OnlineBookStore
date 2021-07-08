package com.example.bookstore;

public class Store {
    private String storeName;
    private String name;
    private int price;

    public Store(String storeName, String name, int price) {
        this.storeName = storeName;
        this.name = name;
        this.price = price;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
