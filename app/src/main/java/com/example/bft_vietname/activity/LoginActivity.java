package com.example.bft_vietname.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bft_vietname.R;

public class LoginActivity extends AppCompatActivity {
    TextView btnNextLogin;
    Button btnLogin,btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControls();
        addEvents(); // Hàm xử lí btn login, nextlogin, signup
    }

    private void addEvents() {
        btnNextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,LoginScreenActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpScreenActivity.class);
                startActivity(intent);
            }
        });
    }


    private void addControls() {
        btnNextLogin = findViewById(R.id.btnNextLogin);
        btnLogin= findViewById(R.id.btnLogin);
        btnSignUp= findViewById(R.id.btnSignUp);
    }
}