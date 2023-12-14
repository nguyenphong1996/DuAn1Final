package com.example.afinal.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;
import com.example.afinal.model.DonHang;

import java.util.ArrayList;

public class DonHangAdapter extends RecyclerView.Adapter<DonHangAdapter.ViewHolder>{

    private Context context;
    private ArrayList<DonHang> list;

    public DonHangAdapter(Context context, ArrayList<DonHang> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtID.setText("ID:"+list.get(position).getMaDon());
        holder.txtTen.setText(list.get(position).getTenDon());
        holder.txtSoLuong.setText(list.get(position).getKhoiLuong());
        holder.txtGia.setText((int) list.get(position).getGiaDon());
        holder.txtNgayGiao.setText(list.get(position).getNgayNhan());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtID,txtTen,txtSoLuong,txtGia,txtNgayGiao;
        private ImageButton imbtnCT;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtID = itemView.findViewById(R.id.idDon);
            txtTen = itemView.findViewById(R.id.tendon);
            txtSoLuong = itemView.findViewById(R.id.khoiluong);
            txtGia = itemView.findViewById(R.id.giatien);
            txtNgayGiao = itemView.findViewById(R.id.ngaygiao);
            imbtnCT = itemView.findViewById(R.id.btnchitiet);
        }
    }
}
