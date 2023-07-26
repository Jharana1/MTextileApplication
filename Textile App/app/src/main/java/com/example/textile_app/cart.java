package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {

    private RecyclerView cardRecycleView;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private RecyclerView.Adapter adapter;
    List<cardModel> list;
    String Email;
    int id;

    Button b1;

//    RequestQueue rq;

    private String request_url = "http://192.168.254.5/textile/cartAPI.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null)
            Email = (String) bundle.get("email");

//        rq = Volley.newRequestQueue(this);

        cardRecycleView = findViewById(R.id.rv5);
        b1 = findViewById(R.id.orderBtn);

    /*    list = new ArrayList<>();
        adapter = new cardsdapter(getApplicationContext(),list,id);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration =new DividerItemDecoration(cardRecycleView.getContext(),layoutManager.getOrientation());

//        cardRecycleView = (RecyclerView) findViewById(R.id.rv5);
        cardRecycleView.setHasFixedSize(true);
        cardRecycleView.setLayoutManager(layoutManager);
        cardRecycleView.addItemDecoration(dividerItemDecoration);
        cardRecycleView.setAdapter(adapter);*/


        getData();
//        initData();
        initRecyclerView();
    }

    private void getData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(request_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String email = jsonObject.getString("email");

                        if (Email.equals(email)==true) {
                            id = jsonObject.getInt("ID");
                            cardModel cardModel = new cardModel();

                            cardModel.setCatalogueN(jsonObject.getString("catalogue"));
                            cardModel.setDesignN(jsonObject.getString("design"));
                            cardModel.setImg(jsonObject.getInt("image"));

                            list.add(cardModel);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
//
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    private void initRecyclerView() {
        list = new ArrayList<>();
        adapter = new cardsdapter(list, id);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(cardRecycleView.getContext(), layoutManager.getOrientation());

//      cardRecycleView = (RecyclerView) findViewById(R.id.rv5);
        cardRecycleView.setHasFixedSize(true);
        cardRecycleView.setLayoutManager(layoutManager);
        cardRecycleView.addItemDecoration(dividerItemDecoration);
        cardRecycleView.setAdapter(adapter);
    }
}

//            @Override
//            public void onResponse(JSONArray response) {
//
//                for(int i = 0; i < response.length(); i++){
//
//                    cardModel cardModel = new cardModel();
//
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(i);
//
//                        cardModel.setCatalogueN(jsonObject.getString("cataloug"));
//                        cardModel.setDesignN(jsonObject.getString("design"));
////                        cardModel.getImg1(jsonObject.getString("image"));
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                    list.add(cardModel);
//
//                }
//
//
//
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.i("Volley Error: ", String.valueOf(error));
//            }
//        });
//
//        rq.add(jsonArrayRequest);
//
//    }
//
//}


//    private void initData() {
//        list = new ArrayList<>();
//        list.add(new cardModel(R.drawable.cotton,"1","1","100",R.drawable.delete));
//        list.add(new cardModel(R.drawable.silk,"2","2","100",R.drawable.delete));
//        list.add(new cardModel(R.drawable.linen,"3","3","100",R.drawable.delete));
//        list.add(new cardModel(R.drawable.silk,"2","2","100",R.drawable.delete));
//        list.add(new cardModel(R.drawable.linen,"3","3","100",R.drawable.delete));
//        list.add(new cardModel(R.drawable.silk,"2","2","100",R.drawable.delete));
//        list.add(new cardModel(R.drawable.linen,"3","3","100",R.drawable.delete));
//
//    }
//
//    private void initRecyclerView() {
//        cardRecycleView=findViewById(R.id.rv5);
//        layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        cardRecycleView.setLayoutManager(layoutManager);
//        adapter = new cardsdapter(list);
//        cardRecycleView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//    }
//}