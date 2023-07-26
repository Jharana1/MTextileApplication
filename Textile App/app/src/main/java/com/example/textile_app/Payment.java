package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Payment extends AppCompatActivity {

    RecyclerView odRecycle;
    LinearLayoutManager layoutManager;
    List<payment_model> list;
    payment_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        initData();
        initRecyclerView();

    }

    private void initData() {

        list = new ArrayList<>();
        list.add(new payment_model("1" ,"01/06/22","1000","500","500","Unpaid"));
        list.add(new payment_model("2" ,"01/06/22","5000","5000","00","Paid"));
        list.add(new payment_model("3" ,"01/06/22","1000","500","500","Unpaid"));
        list.add(new payment_model("3" ,"01/06/22","1000","500","500","Unpaid"));

    }

    private void initRecyclerView() {

        odRecycle= findViewById(R.id.rv4);
        layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        odRecycle.setLayoutManager(layoutManager);
        adapter = new payment_adapter(list);
        odRecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}