package com.example.bft_vietname.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bft_vietname.R;
import com.example.bft_vietname.model.HuongDanKiThuat;

import java.util.ArrayList;

public class RecycleKiThuat extends RecyclerView.Adapter<RecycleKiThuat.MyViewHolder> {
    Context context;
    ArrayList<HuongDanKiThuat> list;

    public RecycleKiThuat(Context context, ArrayList<HuongDanKiThuat> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_card_huong_dan_ki_thuat,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.tvTitle.setText(list.get(position).getTitle());
//        holder.img_thong_tin.setImageResource(list.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        ImageView img_thong_tin;
        public MyViewHolder(View view){
            super(view);
            tvTitle = view.findViewById(R.id.tvTitleKiThuat);
            img_thong_tin = view.findViewById(R.id.imgKiThuat);
        }
    }
}
