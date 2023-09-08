package com.example.bft_vietname.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bft_vietname.R;
import com.example.bft_vietname.dao.UserDAO;
import com.example.bft_vietname.model.User;

import java.util.ArrayList;

public class SignUpScreenActivity extends AppCompatActivity {
    EditText edtSdtSignUp,edtPassSignUp,edtRePassSignUp,edtTenSignUp;
    TextView btnToLoginFromSignUp;
    Button btnSignUpScreens;
    UserDAO userDAO;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnToLoginFromSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpScreenActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSignUpScreens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taoAccMoi();
            }
        });
    }

    private void taoAccMoi() {
        String sdt = edtSdtSignUp.getText().toString();
        String pass = edtPassSignUp.getText().toString();
        String rePass = edtRePassSignUp.getText().toString();
        String name = edtTenSignUp.getText().toString();
        if(TextUtils.isEmpty(sdt)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(rePass)||TextUtils.isEmpty(name)){
            Toast.makeText(SignUpScreenActivity.this,"Please fill all",Toast.LENGTH_LONG).show();
            return;
        }
        if (sdt.length() != 10) {
            edtSdtSignUp.setError("Phone number must be 10 digits");
            edtSdtSignUp.setText("");
            return;
        }
        if(!isValidPassword(pass)){
            edtPassSignUp.setError("Least 1 digit, 1 uppercase letter, 1 lowercase letter, and has a minimum length of 8 characters.");
            edtPassSignUp.setText("");
            return;
        }
        if(!pass.equals(rePass)){
            edtRePassSignUp.setError("Password does not match");
            edtRePassSignUp.setText("");
            return;
        }
        if(!isValuesName(name)){
            edtTenSignUp.setText("");
            edtTenSignUp.setError("[a-zA-Z ]+");
            return;
        }
        User item = new User(name,sdt,rePass);
        if(userDAO.createAcc(item)){
            Toast.makeText(SignUpScreenActivity.this, "CREATE ACCOUNT SUCCESSFULL", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignUpScreenActivity.this,LoginActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(SignUpScreenActivity.this, "FAIL", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isValuesName(String name) {
        return name.matches("[a-zA-Z ]+");
    }
    private boolean isValidPassword(String password) {
        //ít nhất 1 kí tự, 1 viết hoa, 1 viết thường, độ dài tối thiểu 8
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    }

    private void addControls() {
        edtSdtSignUp = findViewById(R.id.edtSdtSignUp);
        edtPassSignUp = findViewById(R.id.edtPassSignUp);
        edtRePassSignUp = findViewById(R.id.edtRePassSignUp);
        edtTenSignUp = findViewById(R.id.edtTenSignUp);
        btnToLoginFromSignUp = findViewById(R.id.btnToLoginFromSignUp);
        btnSignUpScreens = findViewById(R.id.btnSignUpScreens);
        userDAO = new UserDAO(SignUpScreenActivity.this);
    }
}