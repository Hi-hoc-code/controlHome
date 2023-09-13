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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.bft_vietname.R;
import com.example.bft_vietname.adapter.RecycleIntroAdapter;
import com.example.bft_vietname.adapter.RecycleKiThuatAdapter;
import com.example.bft_vietname.adapter.UserAdapter;
import com.example.bft_vietname.model.Banner;
import com.example.bft_vietname.dao.UserDAO;
import com.example.bft_vietname.model.HuongDan;
import com.example.bft_vietname.model.User;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rcvIntro, rcvKiThuat;
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
        rcvKiThuat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        // Khởi tạo HttpClient để lấy dữ liệu
        OkHttpClient client= new OkHttpClient();
        // Khởi tạo Moshi adapter để đổi file JSOIN thành dữ liệu (Add vào user)
        Moshi moshi = new Moshi.Builder().build();
        Type userType = Types.newParameterizedType(List.class, HuongDan.class);
        final JsonAdapter<List<HuongDan>> jsonAdapter =moshi.adapter(userType);
        // Tạo yêu cầu lên sever
        Request request = new Request.Builder().url("https://65008ff018c34dee0cd51afd.mockapi.io/api/products").build();
        //Thực thi request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Lấy thông tin JSON trả về.
                String json = response.body().string();
                final List<HuongDan> huongDans = jsonAdapter.fromJson(json);
                // Gán lên recycleView
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rcvKiThuat.setAdapter(new RecycleKiThuatAdapter(huongDans, HomeActivity.this));
                    }
                });
            }
        });

    }
    private void addControls() {
        rcvIntro = findViewById(R.id.rcvIntro);
        rcvKiThuat = findViewById(R.id.rcvKiThuat);
        btnYourAccount = findViewById(R.id.btnYourAccount);
        toolbar = findViewById(R.id.toolBar);
        drawerLayout = findViewById(R.id.drawer_layout);

    }
}