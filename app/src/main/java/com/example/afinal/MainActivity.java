package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.afinal.ImageViewButton.DonHangActivity;
import com.example.afinal.ImageViewButton.TaoDonActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imgTaodon,imgDonHang;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgTaodon = findViewById(R.id.imgTaoDon);
        imgDonHang = findViewById(R.id.imgDonHang);

        imgTaodon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaoDonActivity.class);
                startActivity(intent);
            }
        });
        imgDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DonHangActivity.class);
                startActivity(intent);
            }
        });

    }
}