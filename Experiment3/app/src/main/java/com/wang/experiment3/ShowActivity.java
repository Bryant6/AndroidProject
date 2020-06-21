package com.wang.experiment3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private TextView showUsername;
    private TextView showPassword;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        showUsername = findViewById(R.id.showUsername);
        showPassword = findViewById(R.id.showPassword);

        Intent intent = this.getIntent();
        User user = (User) intent.getSerializableExtra("user");

        showUsername.setText("账      号：" + user.getUsername());
        showPassword.setText("密      码："+user.getPassword());

    }

    public void returnLogin(View view){
        Intent intent = new Intent(view.getContext(),LoginActivity.class);
        startActivity(intent);
    }
}
