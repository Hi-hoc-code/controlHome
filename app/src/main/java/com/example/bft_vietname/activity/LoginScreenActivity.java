package com.example.bft_vietname.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bft_vietname.R;
import com.example.bft_vietname.dao.UserDAO;
import com.example.bft_vietname.model.User;

public class LoginScreenActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtSdtLogin,edtPassLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        addControls();
        addEvents();
    }
    private void addEvents() {
      btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String sdt = edtSdtLogin.getText().toString();
              String pass = edtPassLogin.getText().toString();
              if(TextUtils.isEmpty(sdt)||TextUtils.isEmpty(pass)){
                  Toast.makeText(LoginScreenActivity.this,"Please fill all",Toast.LENGTH_LONG).show();
                  return;
              }
              if (sdt.length() != 10) {
                  edtSdtLogin.setError("Phone number must be 10 digits");
                  edtSdtLogin.setText("");
                  return;
              }
              UserDAO dao = new UserDAO(LoginScreenActivity.this);
              if (dao.checkLogin(sdt, pass)) {
                  Toast.makeText(LoginScreenActivity.this, "Login sucessfull", Toast.LENGTH_LONG).show();
                  Intent intent = new Intent(LoginScreenActivity.this, HomeActivity.class);
                  startActivity(intent);
              } else {
                  Toast.makeText(LoginScreenActivity.this, "Login fail", Toast.LENGTH_LONG).show();
                  edtSdtLogin.setText("");
                  edtPassLogin.setText("");
              }
          }
      });
    }

    private void addControls() {
        btnLogin = findViewById(R.id.btnLoginScreen);
        edtSdtLogin = findViewById(R.id.edtSdtLoginScreen);
        edtPassLogin = findViewById(R.id.edtPassLoginScreen);
    }
}