package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // Sử dụng Handler để đặt thời gian chuyển đổi
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Tạo Intent để chuyển đến activity_login
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);

                // Đóng activity hiện tại sau khi chuyển đến activity_login
                finish();
            }
        }, 3000); // 3000 là thời gian chờ 3 giây (3000 milliseconds)
    }
}