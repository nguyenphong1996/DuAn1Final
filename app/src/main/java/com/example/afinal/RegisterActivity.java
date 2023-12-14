package com.example.afinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText edt1,edt2,edt3;
    Button btn1,btn2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edt1.getText().toString();
                String pass = edt2.getText().toString();
                String repass = edt3.getText().toString();
                if (user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(RegisterActivity.this, "NHẬP ĐẦY ĐỦ THÔNG TIN", Toast.LENGTH_SHORT).show();
                    if (user.equals("")){
                        edt1.setError("VUI LÒNG NHẬP USERNAME");
                    }
                    if(pass.equals("")){
                        edt2.setError("VUI LÒNG NNẬP PASSWORD");
                    }
                    if(repass.equals("")){
                        edt3.setError("VUI LÒNG NHẬP LẠI PASSWORD");
                    }
                }else if (!pass.equals(repass)){
                    Toast.makeText(RegisterActivity.this, "MẬT KHẨU KHÔNG TRÙNG KHỚP", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("user",user);
                    intent.putExtra("pass",pass);
                    setResult(1,intent);
                    finish();
                }
            }
        });
    }
    private void init(){
        edt1=findViewById(R.id.edtRegisterEmail);
        edt2=findViewById(R.id.edtRegisterPass);
        edt3=findViewById(R.id.edtRePass);
        btn1=findViewById(R.id.btn_back);
        btn2=findViewById(R.id.btn_register);
    }
}
