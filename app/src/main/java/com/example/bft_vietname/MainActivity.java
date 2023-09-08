package com.example.bft_vietname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bft_vietname.adapter.UserAdapter;
import com.example.bft_vietname.dao.UserDAO;
import com.example.bft_vietname.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}