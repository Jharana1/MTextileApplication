package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class forgot_password extends AppCompatActivity {
    TextView email1;
    Button restbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email1 = findViewById(R.id.remail1);
        restbtn = findViewById(R.id.resbtn);



        restbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = email1.getText().toString();
                String type = "Forget";

                fpfunction function1 = new fpfunction(forgot_password.this);
                function1.execute(type, email);

                //Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

            }
        });


    }

}
