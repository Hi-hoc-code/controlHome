package com.example.bft_vietname.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bft_vietname.R;
import com.example.bft_vietname.model.Banner;

import java.util.ArrayList;

public class RecycleIntroAdapter extends RecyclerView.Adapter<RecycleIntroAdapter.MyViewHoler> {
    Context context;
    ArrayList<Banner> list;

    public RecycleIntroAdapter(Context context, ArrayList<Banner> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_info,parent,false);
        MyViewHoler viewHoler = new MyViewHoler(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        Banner banner = list.get(position);
        holder.banner.setImageResource(banner.getImgIntro());
        holder.banner.setImageResource(banner.getImgIntro());
        holder.card_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String googleLink = "https://www.facebook.com/NYH04";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleLink));
                context.startActivity(intent); // Sử dụng context ở đây
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHoler extends RecyclerView.ViewHolder{
        ImageView banner;
        CardView card_banner;
        public MyViewHoler(View view){
            super(view);
            banner = view.findViewById(R.id.banner);
            card_banner = view.findViewById(R.id.card_banner);
        }
    }
}
