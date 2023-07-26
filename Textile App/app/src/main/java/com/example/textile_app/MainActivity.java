package com.example.textile_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private  static  final  String CHANNEL_ID = "My Channel";
    private  static final  int REQ_CODE = 100;

    private static final int NOTIFICATION_ID =100;
    public static String PREFS_NAME ="MyPrefsFile";

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView addcart;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle!= null)
            Email = (String) bundle.get("email");

        /*-----------Hooks--------------*/

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nevigationview);
        navigationView.setNavigationItemSelectedListener(this);
        toolbar = findViewById(R.id.toolbar);
        addcart = findViewById(R.id.addCart);
        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,cart.class);
                intent.putExtra("email",Email);
                startActivity(intent);
            }
        });
        /*-------------Tool Bar--------------*/

        setSupportActionBar(toolbar);

        /*-------------Navigation Drawer Menu--------------*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        /*------------Notification--------------*/

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.logo1, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Intent iNotify = new Intent(getApplicationContext(),Payment_history.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivities(this,REQ_CODE, new Intent[]{iNotify}, PendingIntent.FLAG_UPDATE_CURRENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification  = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.logo1)
                    .setContentText("2 days left to payment")
                    .setSubText("New message from Textile")
                    .setContentTitle("Payment reminder!")
                    .setContentIntent(pendingIntent)
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel",NotificationManager.IMPORTANCE_HIGH));
        } else{

            notification  = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.logo1)
                    .setContentText("2 days left to payment")
                    .setContentTitle("Payment reminder!")
                    .setSubText("New message from Textile")
                    .setContentIntent(pendingIntent)
                    .build();


        }

        nm.notify(NOTIFICATION_ID,notification);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_menu:
                Intent intent1 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.profile:
                Intent intent2 = new Intent(MainActivity.this,Profile.class);
                startActivity(intent2);
                Toast.makeText(this, "Welcome to Profile Page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.order_details:
                Intent intent3 = new Intent(MainActivity.this,Order_details.class);
                startActivity(intent3);
                Toast.makeText(this, "Welcome to Oder Page ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.order_processing:
                Intent intent4 = new Intent(MainActivity.this,order_processing.class);
                startActivity(intent4);
                Toast.makeText(this, "Welcome to Order processing Page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delivery:
                Intent intent5 = new Intent(MainActivity.this,Delivey.class);
                startActivity(intent5);
                Toast.makeText(this, "Welcome to Delivery Page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wholeseller:
                Intent intent6 = new Intent(MainActivity.this,wholesalercetalogue.class);
                intent6.putExtra("email",Email);
                startActivity(intent6);
                Toast.makeText(this, "Welcome to Wholeseller Catalogue", Toast.LENGTH_SHORT).show();
                break;
            case R.id.grayDetails:
                Intent intent7= new Intent(MainActivity.this,greyDetails.class);
                startActivity(intent7);
                Toast.makeText(this, "Welcome to Gray details page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payments:
                Intent intent8 = new Intent(MainActivity.this,Payment.class);
                startActivity(intent8);
                Toast.makeText(this, "Welcome to Payment page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.payments_history:
                Intent intent9 = new Intent(MainActivity.this,Payment_history.class);
                startActivity(intent9);
                Toast.makeText(this, "Welcome to Payment History page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",false);
                editor.commit();
                Intent intent10 = new Intent(MainActivity.this,login.class);
                startActivity(intent10);
                finish();
                Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawerlayout);
        drawer.closeDrawer(GravityCompat.START);drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}