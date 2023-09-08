package com.example.bft_vietname.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.bft_vietname.MainActivity;
import com.example.bft_vietname.R;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity after the splash screen
                Intent intent = new Intent(LogoActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}