package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class greyDetails extends AppCompatActivity {

    RecyclerView greyRecyclerView;
    LinearLayoutManager layoutManager;
    List<greyModel> list;
    greyAdapter adapter;
    TextView srNo, grayType,dNumber, grayLot, dDate;

    String[][] imgs = { {"1A","cotton","1","1","01-06-22"},{"1A","cotton","1","1","01-06-22"},{"1A","cotton","1","1","01-06-22"},
            {"1A","cotton","1","1","01-06-22"},{"1A","cotton","1","1","01-06-22"},{"1A","cotton","1","1","01-06-22"},{"1A","cotton","1","1","01-06-22"}
            ,{"1A","cotton","1","1","01-06-22"},{"1A","cotton","1","1","01-06-22"},{"1A","cotton","1","1","01-06-22"}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grey_details);

        initData();
        initRecycleView();
    }

    private void initData() {
        list = new ArrayList<>();

        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));
        list.add(new greyModel("1A","cotton","1","01-06-22","1"));


    }

    private void initRecycleView() {
        greyRecyclerView=findViewById(R.id.rvgrey_details);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        greyRecyclerView.setLayoutManager(layoutManager);
        adapter = new greyAdapter(list);
        greyRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}