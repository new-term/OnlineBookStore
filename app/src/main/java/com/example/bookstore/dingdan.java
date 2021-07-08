package com.example.bookstore;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstore.JavaBean.Order;
import com.example.bookstore.Utils.HttpUtils;
import com.example.bookstore.Utils.JsonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class dingdan extends AppCompatActivity {
    private ListView listview;

    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == HttpUtils.VIEW_ORDERS){
                ArrayList<Order> orders = JsonUtils.getOrderListFromJson((String) msg.obj);
                OrderAdapter adapter = new OrderAdapter(dingdan.this, R.layout.item_order, orders);
                listview.setAdapter(adapter);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);
        listview=findViewById(R.id.listview);

        String user = null;

        try {
            FileInputStream input = openFileInput("data.dat");
            byte[] bytes = new byte[input.available()];
            input.read(bytes);
            user = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("user", user);
        HttpUtils.getDataByPost(HttpUtils.ORDERS_URL, HttpUtils.VIEW_ORDERS, map, handler);
    }

    public void exit(View view) {
        finish();
    }
}