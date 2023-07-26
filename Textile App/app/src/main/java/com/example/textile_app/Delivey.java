package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Delivey extends AppCompatActivity {
    RecyclerView odRecycle;
    LinearLayoutManager layoutManager;
    List<delivery_model> list;
    delivery_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivey);

        initDataO();
        initRecyclerView();
    }

    private void initDataO() {

        list = new ArrayList<>();
        list.add(new delivery_model("1", "31/05/22", "1", "1", "1", "1234", "XYZ", "123456789"));
        list.add(new delivery_model("1", "31/05/22", "1", "1", "1", "1234", "XYZ", "123456789"));
        list.add(new delivery_model("1", "31/05/22", "1", "1", "1", "1234", "XYZ", "123456789"));


    }

    private void initRecyclerView() {

        odRecycle = findViewById(R.id.rv2);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        odRecycle.setLayoutManager(layoutManager);
        adapter = new delivery_adapter(list);
        odRecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}