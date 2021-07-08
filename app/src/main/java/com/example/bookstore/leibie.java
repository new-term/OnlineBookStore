package com.example.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstore.Book;
import com.example.bookstore.DetailActivity;
import com.example.bookstore.MyAdapter;
import com.example.bookstore.dingdan;

import java.util.ArrayList;

public class leibie extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.listview);
        ArrayList<Book>lists=new ArrayList<>();
        lists.add(new Book("山河之书",25));
        lists.add(new Book("骆驼祥子",35));
        lists.add(new Book("光明",62));
        lists.add(new Book("黑暗",30));
        lists.add(new Book("宇宙奥秘",60));
        lists.add(new Book("史记",120));
        MyAdapter adapter=new MyAdapter(this,R.layout.item_book,lists);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(leibie.this, DetailActivity.class);
                intent.putExtra("name",lists.get(position).getName());
                intent.putExtra("price",lists.get(position).getPrice());
                startActivity(intent);
            }
        });
    }

    public void order(View view) {
        startActivity(new Intent(this, dingdan.class));
    }

    public void exit(View view) {
        finish();
    }
}