package com.example.bft_vietname.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bft_vietname.R;
import com.example.bft_vietname.model.HuongDan;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecycleKiThuatAdapter extends RecyclerView.Adapter<RecycleKiThuatAdapter.MyViewHoler> {
    List<HuongDan> list;
    Context context;

    public RecycleKiThuatAdapter(List<HuongDan> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_huong_dan_ki_thuat, parent, false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        HuongDan u = list.get(position);
        Picasso.get().load(u.getImg()).into(holder.imgKiThuat);
        holder.tvTitleKiThuat.setText(u.getTitle());

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHoler extends RecyclerView.ViewHolder{
        ImageView imgKiThuat;
        TextView tvTitleKiThuat;

        public MyViewHoler(View view){
            super(view);
            imgKiThuat = view.findViewById(R.id.imgKiThuat);
            tvTitleKiThuat = view.findViewById(R.id.tvTitleKiThuat);
        }
    }
}
