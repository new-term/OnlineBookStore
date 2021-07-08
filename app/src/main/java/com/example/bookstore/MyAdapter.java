package com.example.bookstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.bookstore.Book;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter {
    private final int resourceId;
    public MyAdapter(@NonNull Context context, int resource, ArrayList<Book>list) {
        super(context, resource, list);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Book book=(Book) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView content = (TextView) view.findViewById(R.id.price);

        title.setText(book.getName());
        content.setText(book.getPrice()+"元");

        return view;
    }
}

