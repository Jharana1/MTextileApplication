package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class wholesalercetalogue extends AppCompatActivity {
    RecyclerView wholesalerRecyclerView;
    LinearLayoutManager layoutManager;
    List<wholesalerModel> list;
    wholesalerAdapter adapter;
    String  Email;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wholesalercetalogue);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!= null)
            Email = (String) bundle.get("email");


        initData();
        initRecyclerView();
    }


    private void initData() {
        list = new ArrayList<>();
        list.add(new wholesalerModel(R.drawable.cotton,"1","1"));
        list.add(new wholesalerModel(R.drawable.silk,"2","2"));
        list.add(new wholesalerModel(R.drawable.linen,"3","3"));
        list.add(new wholesalerModel(R.drawable.polyster,"4","4"));
        list.add(new wholesalerModel(R.drawable.nylon,"5","5"));
        list.add(new wholesalerModel(R.drawable.muslin,"6","6"));
        list.add(new wholesalerModel(R.drawable.velvet,"7","7"));
        list.add(new wholesalerModel(R.drawable.wool,"8","8"));
        list.add(new wholesalerModel(R.drawable.rayon,"9","9"));
        list.add(new wholesalerModel(R.drawable.terrycloth,"10","10"));

    }

    private void initRecyclerView() {
        wholesalerRecyclerView=findViewById(R.id.wholesalerpage);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        wholesalerRecyclerView.setLayoutManager(layoutManager);
        adapter = new wholesalerAdapter(list,Email);
        wholesalerRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}