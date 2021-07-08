package com.example.bookstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.JavaBean.Book;
import com.example.bookstore.Utils.HttpUtils;
import com.example.bookstore.Utils.JsonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public class TestActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button btn;

    private String userstr;

    private Handler handler = new Handler(Looper.getMainLooper()){
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String result;
            if(msg.what == HttpUtils.LOGIN){
                result=(String) msg.obj;
                Toast.makeText(TestActivity.this,result,Toast.LENGTH_SHORT).show();
                if(result.equals("SUCCESS")){
                    try {
                        FileOutputStream fos = openFileOutput("user.dat", MODE_PRIVATE);
                        fos.write(userstr.getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Intent intent=new Intent(TestActivity.this,jindutiao.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(TestActivity.this,"账号或密码输入错误！",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        user = findViewById(R.id.qq_user);
        pass=findViewById(R.id.qq_password);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();
                userstr = user.getText().toString();
                String pass2=pass.getText().toString();
                map.put("user", userstr);
                map.put("pass", pass2);
                HttpUtils.getDataByPost(HttpUtils.LOGIN_URL, HttpUtils.LOGIN, map, handler);
            }
        });

    }
}