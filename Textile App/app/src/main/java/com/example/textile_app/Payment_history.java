package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Payment_history extends AppCompatActivity {

    RecyclerView odRecycle;
    LinearLayoutManager layoutManager;
    List<payment_history_model> list;
    payment_history_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);



        initDataO();
        initRecyclerView();
    }

    private void initDataO() {

        list = new ArrayList<>();
        list.add(new payment_history_model("Payment ID = 1","Order No. = 1","Total Amount = 500","Payment Detail = Cash"));
        list.add(new payment_history_model("Payment ID = 1","Order No. = 1","Total Amount = 500","Payment Detail = Cash"));
        list.add(new payment_history_model("Payment ID = 1","Order No. = 1","Total Amount = 500","Payment Detail = Cash"));
        list.add(new payment_history_model("Payment ID = 1","Order No. = 1","Total Amount = 500","Payment Detail = Cash"));
        list.add(new payment_history_model("Payment ID = 1","Order No. = 1","Total Amount = 500","Payment Detail = Cash"));
        list.add(new payment_history_model("Payment ID = 1","Order No. = 1","Total Amount = 500","Payment Detail = Cash"));
        list.add(new payment_history_model("Payment ID = 1","Order No. = 1","Total Amount = 500","Payment Detail = Cash"));
    }

    private void initRecyclerView() {

        odRecycle = findViewById(R.id.rv3);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        odRecycle.setLayoutManager(layoutManager);
        adapter = new payment_history_adapter(list);
        odRecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}