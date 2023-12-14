package com.example.afinal.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.afinal.database.DbHelper;
import com.example.afinal.model.DonHang;

import java.util.ArrayList;

public class DonHangDAO {
    private DbHelper dbHelper;
    public DonHangDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<DonHang> getDSDonHang(){
        ArrayList<DonHang> list = new ArrayList<>();
        SQLiteDatabase sqLiteOpenHelper = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteOpenHelper.rawQuery("select * from DonHang",null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new DonHang(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(4)));
            }while (cursor.moveToNext());
        }
        return list;
    }
}
