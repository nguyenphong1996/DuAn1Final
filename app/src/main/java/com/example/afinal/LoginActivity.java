package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.afinal.DAO.UserDAO;


public class LoginActivity extends AppCompatActivity {
    private String userRegister="",passRegister="";
    private EditText edtUser, edtPassword;
    private Button btnLogin;
    private TextView txtSingUp, txtForgetPassword;
    private UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtSingUp = findViewById(R.id.txtSingUp);
        txtForgetPassword = findViewById(R.id.txtForgetPassword);

        userDAO = new UserDAO(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPassword.getText().toString();

                boolean checkLogin = userDAO.checkLogin(user, pass);
                if (checkLogin){
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class); // chuyển màn hình
                    startActivity(intent);
                }else if (user.equals(userRegister)&& pass.equals(passRegister)){
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class); // chuyển màn hình
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class); // chuyển màn hình
                myLauncher.launch(intent);
            }
        });
        txtForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogForgot();
            }
        });
    }
    private void showDialogForgot(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_forgot,null);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        //findviewID
        EditText emailKhoiPhuc = view.findViewById(R.id.edtEmailKhoiPhuc);
        Button btnGui = view.findViewById(R.id.btnGui);
        Button btnQuayLai = view.findViewById( R.id.btnQuayLai);

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailKhoiPhuc.getText().toString();
                String matkhau = userDAO.ForgotPassword(email);
                Toast.makeText(LoginActivity.this, matkhau, Toast.LENGTH_SHORT).show();
            }
        });

    }
    private ActivityResultLauncher<Intent> myLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()==1){
                Intent intent = result.getData();
                userRegister = intent.getStringExtra("user");
                passRegister = intent.getStringExtra("pass");
            }
        }
    });

}