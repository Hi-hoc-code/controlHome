package com.example.bft_vietname.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bft_vietname.database.DbHelper;
import com.example.bft_vietname.model.User;

import java.util.ArrayList;

public class UserDAO {
    DbHelper helper;
    SQLiteDatabase db;

    public UserDAO(Context context) {
        helper = new DbHelper(context);
    }

    public ArrayList<User> getAll(){
        ArrayList<User> list = new ArrayList<>();
        db = helper.getReadableDatabase();
        String sql = "SELECT*FROM USER";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Integer id = cursor.getInt(0);
            String name = cursor.getString(1);
            String sdt = cursor.getString(2);
            String pass = cursor.getString(3);
            User item = new User(id,name, sdt, pass);
            list.add(item);
            cursor.moveToNext();
        }
        db.close();
        return list;

    }

    public boolean createAcc(User item){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten",item.getUsername());
        values.put("sdt",item.getSdt());
        values.put("pass",item.getPassword());
        long row = db.insert("USER",null,values);
        return row>0;
    }

    public boolean checkLogin(String sdt, String password){
        db=helper.getReadableDatabase();
        String sql="SELECT* FROM USER WHERE sdt=? AND pass =?";
        Cursor cursor =db.rawQuery(sql,new String[]{sdt,password});
        int count = cursor.getCount();
        db.close();
        return  count>0;
    }
    public boolean deleteAccount(Integer index){
        db = helper.getWritableDatabase();
        int row = db.delete("USER","id=?",new String[]{String.valueOf(index)});
        return row>0;
    }

}
