package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class order_processing extends AppCompatActivity {
    RecyclerView odRecycle;
    LinearLayoutManager layoutManager;
    List<orderprocessingModel> list;
    orderprocessingAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_processing);

        initData();
        initRecyclerView();
    }

    private void initData() {

        list = new ArrayList<>();
        list.add(new orderprocessingModel("30/05/22","1", "5","2", "3"));
        list.add(new orderprocessingModel("31/05/22","2", "3","1", "2"));
        list.add(new orderprocessingModel("01/06/22","1", "4","3", "1"));
        list.add(new orderprocessingModel("31/05/22","2", "3","1", "2"));
        list.add(new orderprocessingModel("01/06/22","1", "4","3", "1"));

    }

    private void initRecyclerView() {

        odRecycle= findViewById(R.id.rv1);
        layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        odRecycle.setLayoutManager(layoutManager);
        adapter = new orderprocessingAdapter(list);
        odRecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

}