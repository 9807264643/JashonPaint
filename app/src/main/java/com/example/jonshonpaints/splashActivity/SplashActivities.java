package com.example.jonshonpaints.splashActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.jonshonpaints.ClientInfoActivity.ClientInfoActivities;
import com.example.jonshonpaints.MainActivity;
import com.example.jonshonpaints.R;

public class SplashActivities extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    RelativeLayout layout;

    private ImageView imgLogo;

    private String Status, LoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activities);

        getWindow().setFlags(WindowManager
                .LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        layout = findViewById(R.id.splash);
        imgLogo = findViewById(R.id.engreader_text);

        SharedPreferences mypref = getSharedPreferences("UserLogin", MODE_PRIVATE);
        Status = mypref.getString("Status", null);
        LoggedIn = mypref.getString("LoggedIn", null);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(SplashActivities.this, ClientInfoActivities.class));

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}
