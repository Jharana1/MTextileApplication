package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import android.os.Bundle;

public class login extends AppCompatActivity {
    TextView emailid, password,fp1;
    Button loginbtn, signupbtn, rtcatalog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailid = findViewById(R.id.emailid);
        password = findViewById(R.id.password);
        fp1= findViewById(R.id.fp1);
        loginbtn = findViewById(R.id.loginbtn);
        signupbtn = findViewById(R.id.signupbtn);
        rtcatalog = findViewById(R.id.retailcatalog);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailid.getText().toString();
                String password1 = password.getText().toString();
                String type = "login";

                lfunction function1 = new lfunction(login.this);
                function1.execute(type, email, password1);

//

                // Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this, registration.class);
                startActivity(intent);
            }
        });

        fp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, forgot_password.class);
                startActivity(intent);
            }
        });

        rtcatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, Retail_catalog.class);
                startActivity(intent);
            }
        });

    }

}