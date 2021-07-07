package com.example.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.JavaBean.Book;
import com.example.bookstore.Utils.HttpUtils;
import com.example.bookstore.Utils.JsonUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public class TestActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;

    private Handler handler = new Handler(Looper.getMainLooper()){
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String jieguo;
            if(msg.what == HttpUtils.LOGIN){
                jieguo=(String) msg.obj;
                Toast.makeText(TestActivity.this,jieguo,Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        user = findViewById(R.id.qq_user);
        pass=findViewById(R.id.qq_password);


        HashMap<String, String> map = new HashMap<>();
        String user1 = user.getText().toString();
        String pass2=pass.getText().toString();
        map.put("user", user1);
        map.put("pass", pass2);
        HttpUtils.getDataByPost(HttpUtils.LOGIN_URL, HttpUtils.LOGIN, map, handler);
    }
}