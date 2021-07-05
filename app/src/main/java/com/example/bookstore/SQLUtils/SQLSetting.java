package com.example.bookstore.SQLUtils;

public class SQLSetting {
    //表名
    static public final String TABLE_USER = "userinfo";
    static public final String TABLE_BOOK = "bookinfo";
    static public final String TABLE_ORDER = "orderinfo";
    static public final String TABLE_MAIL = "mailinfo";
    static public final String TABLE_CLASSIFY = "classification";
    static public final String TABLE_STORE = "storeinfo";
    static public final String TABLE_SERVICE = "serviceinfo";
    static public final String TABLE_ORDERBOOK = "orderbookinfo";
    static public final String TABLE_BOOKCLASSIFY = "bookclassifyinfo";
    static public final String TABLE_STOREBOOK = "storebookinfo";

    //用户表列名
    static public final String USER_NAME = "userinfo.username";
    static public final String USER_PASSWORD = "password";
    static public final String USER_REGISTER_TIME = "time";

    //图书表列名
    static public final String BOOK_ISBN = "bookinfo.isbn";
    static public final String BOOK_NAME = "bookname";
    static public final String BOOK_PRICE = "price";

    //订单表列名
    static public final String ORDER_ID = "orderinfo.id";
    static public final String ORDER_OCCUR_TIME = "orderinfo.time";
    static public final String ORDER_USER = "orderinfo.username";

    //邮寄信息表列名
    static public final String MAIL_ID = "mailinfo.id";
    static public final String MAIL_ADDRESS = "address";
    static public final String MAIL_PHONE = "telephone";
    static public final String MAIL_USER = "mailinfo.username";

    //分类表列名
    static public final String CLASSIFY_ID = "classification.id";
    static public final String CLASSIFY_CONTENT = "content";

    //店铺表列名
    static public final String STORE_ID = "storeinfo.id";
    static public final String STORE_NAME = "storename";

    //客服表列名
    static public final String SERVICE_ID = "serviceinfo.id";
    static public final String SERVICE_NAME = "servicename";
    static public final String SERVICE_STORE = "storeid";

    //订单图书表列名
    static public final String ORDERBOOK_ISBN = "orderbookinfo.isbn";
    static public final String ORDERBOOK_ORDERID = "orderbookinfo.orderid";

    //图书分类表列名
    static public final String BOOKCLASSIFY_ISBN = "bookclassifyinfo.isbn";
    static public final String BOOKCLASSIFY_CLASSIFYID = "bookclassifyinfo.classificationid";

    //店铺图书表列名
    static public final String STOREBOOK_ISBN = "storebookinfo.isbn";
    static public final String STOREBOOK_STOREID = "storebookinfo.storeid";

}
