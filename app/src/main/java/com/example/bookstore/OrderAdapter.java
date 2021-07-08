package com.example.bookstore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookstore.JavaBean.Order;
import com.example.bookstore.R;
import com.example.bookstore.Store;

import java.util.ArrayList;

public class OrderAdapter extends ArrayAdapter {
    private final int resourceId;
    private ArrayList<Order> orders;

    @Nullable
    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    public OrderAdapter(@NonNull Context context, int resource, ArrayList<Order> list) {
        super(context, resource, list);
        resourceId = resource;
        orders = list;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Order order = (Order) getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView content = (TextView) view.findViewById(R.id.price);
        TextView storeName = (TextView) view.findViewById(R.id.store);
        title.setText("成交时间：" + order.getTime());
        storeName.setText("订单号：" + order.getId());
        content.setText("");
        return view;
    }
}
