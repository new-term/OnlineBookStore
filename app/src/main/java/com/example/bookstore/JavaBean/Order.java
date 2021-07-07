package com.example.bookstore.JavaBean;

public class Order {
    private String id;
    private String time;
    private String userName;

    public Order(String id, String time, String userName) {
        this.id = id;
        this.time = time;
        this.userName = userName;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
