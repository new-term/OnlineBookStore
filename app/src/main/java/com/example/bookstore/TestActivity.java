package com.example.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import com.example.bookstore.JavaBean.Book;
import com.example.bookstore.Utils.HttpUtils;
import com.example.bookstore.Utils.JsonUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public class TestActivity extends AppCompatActivity {

    private TextView result;

    private Handler handler = new Handler(Looper.getMainLooper()){
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == HttpUtils.LOGIN){
                result.setText((String) msg.obj);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        result = findViewById(R.id.result);

        HashMap<String, String> map = new HashMap<>();
        String user = "testuser";
        map.put("user", user);
        map.put("pass", "12345678");
        HttpUtils.getDataByPost(HttpUtils.LOGIN_URL, HttpUtils.LOGIN, map, handler);
    }
}