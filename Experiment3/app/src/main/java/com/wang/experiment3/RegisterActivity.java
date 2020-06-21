package com.wang.experiment3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText uRegisterText;
    private EditText pRegisterText;
    private EditText rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uRegisterText = findViewById(R.id.uRegisterText);
        pRegisterText = findViewById(R.id.pRegisterText);
        rePassword = findViewById(R.id.rePassword);

    }

    public void register(View view){
        if(uRegisterText.getText().toString().equals("")){
            Toast.makeText(RegisterActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
        }
        if(pRegisterText.getText().toString().equals("")){
            Toast.makeText(RegisterActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
        }
        if(rePassword.getText().toString().equals("")){
            Toast.makeText(RegisterActivity.this,"请再次输入密码",Toast.LENGTH_SHORT).show();
        }else if(pRegisterText.getText().toString().equals(rePassword.getText().toString())){
            User user = new User();
            user.setUsername(uRegisterText.getText().toString());
            user.setPassword(pRegisterText.getText().toString());

            SharedPreferences sp = this.getSharedPreferences("info", MODE_PRIVATE);
            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sp.edit();
            editor.putString("username",uRegisterText.getText().toString());
            editor.putString("password",pRegisterText.getText().toString());
            editor.commit();

            Intent intent = new Intent();
            intent.setAction("android.intent.action.ANSWER");
            intent.addCategory("android.intent.category.DEFAULT");

            intent.putExtra("user",user);
            startActivity(intent);

        }else{
            Toast.makeText(RegisterActivity.this,"两次输入密码不一致",Toast.LENGTH_SHORT).show();
        }
    }
}
