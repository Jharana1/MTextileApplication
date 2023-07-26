package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class registration extends AppCompatActivity {

    TextView firmname1,gst1,firstname1,lastname1,email1,phonenumber1,password1,cpassword1,pancard1,address1,pincode1,dob1,doa1,login1;
    Button regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firmname1 = findViewById(R.id.FirmEt);
        gst1 = findViewById(R.id.GstEt);
        firstname1 = findViewById(R.id.FirstNameEt);
        lastname1 = findViewById(R.id.LastNameEt);
        email1 = findViewById(R.id.emailEt);
        phonenumber1 = findViewById(R.id.PhoneEt);
        password1 = findViewById(R.id.PasswordEt);
        cpassword1 = findViewById(R.id.cpasswordEt);
        pancard1 = findViewById(R.id.PanEt);
        address1 = findViewById(R.id.addressEt);
        pincode1 = findViewById(R.id.PinEt);
        dob1 = findViewById(R.id.DobEt);
        doa1 = findViewById(R.id.DoaEt);
        // login1 = findViewById(R.id.login1);
        regbtn = findViewById(R.id.registerBtn);


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firmname = firmname1.getText().toString();
                String gst = gst1.getText().toString();
                String firstname = firstname1.getText().toString();
                String lastname = lastname1.getText().toString();
                String email = email1.getText().toString();
                String phonenumber = phonenumber1.getText().toString();
                String password = password1.getText().toString();
                String cpassword = cpassword1.getText().toString();
                String pancard = pancard1.getText().toString();
                String address = address1.getText().toString();
                String pincode = pincode1.getText().toString();
                String dob = dob1.getText().toString();
                String doa = doa1.getText().toString();


                String type = "Registration";

                rfunction function1 = new rfunction(registration.this);
                function1.execute(type,firmname,gst,firstname,lastname,email,phonenumber, password,cpassword,pancard,address,pincode,dob,doa);

                // Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

            }
        });

   /*     login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registration.this,MainActivity.class);
                startActivity(intent);
            }
        });
*/
    }
}