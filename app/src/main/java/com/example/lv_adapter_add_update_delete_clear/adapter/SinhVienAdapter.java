package com.example.lv_adapter_add_update_delete_clear.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lv_adapter_add_update_delete_clear.R;
import com.example.lv_adapter_add_update_delete_clear.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return sinhVienList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);

//        Ánh xạ + gán
        TextView tvTen = view.findViewById(R.id.tvTen);
        TextView tvNamSinh = view.findViewById(R.id.tvNamSinh);

        tvTen.setText(sinhVienList.get(position).getTen());
        tvNamSinh.setText(String.valueOf(sinhVienList.get(position).getNamSinh()));
        return view;
    }
}
