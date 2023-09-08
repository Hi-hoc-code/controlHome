package com.example.bft_vietname.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.bft_vietname.R;
import com.example.bft_vietname.adapter.RecycleIntroAdapter;
import com.example.bft_vietname.adapter.UserAdapter;
import com.example.bft_vietname.model.Banner;
import com.example.bft_vietname.dao.UserDAO;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rcvIntro;
    RecycleIntroAdapter recycleIntroAdapter;
    ArrayList<Banner> listBanner;
    ImageView btnYourAccount;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addControls();
        addEvents();
    }


    private void addEvents() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false);
        rcvIntro.setLayoutManager(layoutManager);
        listBanner= new ArrayList<>();
        listBanner.add(new Banner(R.drawable.intro,1));
        recycleIntroAdapter = new RecycleIntroAdapter(HomeActivity.this,listBanner);
        rcvIntro.setAdapter(recycleIntroAdapter);
        btnYourAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });


    }
    private void addControls() {
        rcvIntro = findViewById(R.id.rcvIntro);
        btnYourAccount = findViewById(R.id.btnYourAccount);
        toolbar = findViewById(R.id.toolBar);
        drawerLayout = findViewById(R.id.drawer_layout);

    }
}