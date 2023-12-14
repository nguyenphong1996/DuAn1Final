package com.example.afinal.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.afinal.database.DbHelper;

public class UserDAO   {
    DbHelper dbhelper;
    public UserDAO(Context context){
        dbhelper = new DbHelper(context);
    }
    public boolean checkLogin(String username,String password) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE user=? AND pass=?", new String[]{username, password});
        return cursor.getCount() > 0;
    }
    public String ForgotPassword(String email){
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT pass FROM NGUOIDUNG WHERE user=?", new String[]{email});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            return cursor.getString(0);
        }else {
            return "";
        }
        //
    }
}
