package com.example.bookstore;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tushu);
        TextView name=findViewById(R.id.title);
        TextView price=findViewById(R.id.price);
       name.setText( getIntent().getStringExtra("name"));
       price.setText(getIntent().getIntExtra("price",0)+"元");

    }

    public void exit(View view) {
        finish();
    }
}