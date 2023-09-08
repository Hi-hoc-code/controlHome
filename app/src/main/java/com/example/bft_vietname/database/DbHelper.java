package com.example.bft_vietname.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.bft_vietname.R;

import java.io.ByteArrayOutputStream;

public class DbHelper extends SQLiteOpenHelper {
    private Context context;
    public DbHelper(Context context) {
        super(context, "BFT_VIET_NAM", null, 3);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_user = "CREATE TABLE USER(id integer primary key autoincrement," +
                "ten text," +
                "sdt text," +
                "pass text)";
        db.execSQL(sql_user);
        sql_user ="INSERT INTO USER(ten,sdt, pass)VALUES('Admin','0708332716','Admin@123')";
        db.execSQL(sql_user);


        String sql_intro = "CREATE TABLE BANNER(id integer primary key autoincrement," +
                "image text)";
        db.execSQL(sql_intro);

        String sql_huong_dan_ki_thuat="CREATE TABLE HUONGDANKITHUAT(id_huong_dan integer primary key autoincrement," +
                "img_huong_dan BLOB," +
                "title_huong_dan text)";
        db.execSQL(sql_huong_dan_ki_thuat);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        db.execSQL("DROP TABLE IF EXISTS BANNER");
        db.execSQL("DROP TABLE IF EXISTS HUONGDANKITHUAT");
        onCreate(db);
    }
}
