package com.example.bft_vietname.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bft_vietname.R;
import com.example.bft_vietname.model.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    Context context;
    ArrayList<User> list;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoler holer;
        if(view==null){
            holer = new ViewHoler();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(R.layout.layout_account,null);
            holer.tvTen = view.findViewById(R.id.tvTen);
            holer.tvSdt = view.findViewById(R.id.tvSdt);
            holer.tvPass = view.findViewById(R.id.tvPass);
            view.setTag(holer);
        }else{
            holer = (ViewHoler) view.getTag();
        }
        holer.tvTen.setText(list.get(i).getUsername());
        holer.tvSdt.setText(list.get(i).getSdt());
        holer.tvPass.setText(list.get(i).getPassword());
        return view;
    }
    private static class ViewHoler{
        TextView tvTen, tvSdt, tvPass;
    }
}
