package com.wang.experiment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView uLoginText;
    private TextView pLoginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uLoginText = findViewById(R.id.uLoginText);
        pLoginText = findViewById(R.id.pLoginText);

    }

    public void login(View view){
        if(uLoginText.getText().toString().equals("")){
            Toast.makeText(LoginActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
        }
        if(pLoginText.getText().toString().equals("")){
            Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
        }

        String username = uLoginText.getText().toString();
        String password = pLoginText.getText().toString();
        SharedPreferences sp = this.getSharedPreferences("info", MODE_PRIVATE);
        String name = sp.getString("username",null);
        String pwd = sp.getString("password",null);
        if(username.equals(name)){
            if(password.equals(pwd)){
                Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
            }
        }else if(!(username.equals(""))){
            Intent intent = new Intent(view.getContext(),RegisterActivity.class);
            startActivity(intent);
        }
    }
}
