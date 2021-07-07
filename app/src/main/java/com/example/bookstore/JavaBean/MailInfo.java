package com.example.bookstore.JavaBean;

public class MailInfo {
    private String id;
    private String address;
    private String userName;
    private String telephone;

    public MailInfo(String id, String address, String userName, String telephone) {
        this.id = id;
        this.address = address;
        this.userName = userName;
        this.telephone = telephone;
    }

    public MailInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
