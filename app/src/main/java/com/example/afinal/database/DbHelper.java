package com.example.afinal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {



    public DbHelper(Context context) {
        super(context,"final",null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String nguoidung = "CREATE TABLE NGUOIDUNG(id_nguoidung integer primary key autoincrement, user text, pass text, email text)";
        sqLiteDatabase.execSQL(nguoidung);
        String data = "INSERT INTO NGUOIDUNG (user, pass, email) VALUES" +
                "('phong', '123', 'phong@example.com')," +
                "('quy', '123', 'quy@example.com')," +
                "('tien', '123', 'tien@example.com')," +
                "('kien', '123', 'kien@example.com')," +
                "('bao', '123', 'bao@example.com')";
        sqLiteDatabase.execSQL(data);
        sqLiteDatabase.execSQL("CREATE TABLE DichVu(" +
                "Id_DV integer primary key autoincrement," +
                "Ten_DV text," +
                "GiaTien float," +
                "KhoiLuong text,"+
                "NgayGiao text)"
        );
        data = "INSERT INTO DichVu VALUES" +
                "(null, 'Giặt sấy đồ thun', 45000, null,'14/03/2023')," +
                "(null, 'Giặt sấy đồ thun', 45000, null,'14/03/2023')," +
                "(null, 'Giặt sấy đồ cotton', 75000, null,'14/03/2023')";
        sqLiteDatabase.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DichVu");
        onCreate(sqLiteDatabase);
    }
}
