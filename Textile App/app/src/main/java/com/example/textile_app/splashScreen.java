package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class splashScreen extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    Intent intent;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        lottieAnimationView = findViewById(R.id.lottie);
        imageView = findViewById(R.id.img);

        lottieAnimationView.animate().setDuration(1000).setStartDelay(3000);
        imageView.animate().setDuration(1000).setStartDelay(3000);

        final Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences(lfunction.PREFS_NAME,MODE_PRIVATE);
                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn", false);

                if (hasLoggedIn){
                    Intent intent = new Intent(splashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {

                    Intent intent = new Intent(splashScreen.this, login.class);
                    startActivity(intent);
                    finish();

                }
//                intent = new Intent(splashScreen.this, login.class);
//                startActivity(intent);
//                finish();
            }
        }, 3000);
    }
}