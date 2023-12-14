package com.example.afinal.ImageViewButton;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.DAO.DonHangDAO;
import com.example.afinal.R;
import com.example.afinal.adapter.DonHangAdapter;
import com.example.afinal.model.DonHang;

import java.util.ArrayList;

public class DonHangActivity extends AppCompatActivity {
    private DonHangDAO donHangDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donhang);

        RecyclerView recyclerView = findViewById(R.id.recycleView);

        //data
        donHangDAO = new DonHangDAO(this);
        ArrayList<DonHang> list = donHangDAO.getDSDonHang();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DonHangAdapter donHangAdapter = new DonHangAdapter(this,list);
        recyclerView.setAdapter(donHangAdapter);


    }
}