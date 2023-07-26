package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class Order_details extends AppCompatActivity {

    RecyclerView odRecycle;
    LinearLayoutManager layoutManager;
    List<order_detail_model> list;
    oder_detail_adapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        initData();
        initRecyclerView();




    }


    private void initData() {

        list = new ArrayList<>();
        list.add(new order_detail_model("30/05/22","1", "1","cotton", "1", "1","200","200","pending"));
        list.add(new order_detail_model("30/05/22","2", "2","synthetic", "2", "2","400","800","pending"));
        list.add(new order_detail_model("30/05/22","1", "1","cotton", "1", "1","200","200","pending"));
        list.add(new order_detail_model("30/05/22","1", "1","cotton", "1", "1","200","200","pending"));

    }

    private void initRecyclerView() {

        odRecycle= findViewById(R.id.rv1);
        layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        odRecycle.setLayoutManager(layoutManager);
        adapter = new oder_detail_adapter(list);
        odRecycle.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}