package com.wang.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView2);

        Intent intent = new Intent();
        int num = intent.getIntExtra("mess1",0);
        String str = intent.getStringExtra("mess2");
        textView.setText(num + ":"+str);

        User user = (User) intent.getSerializableExtra("user");
        Toast.makeText(this,user.toString(),Toast.LENGTH_SHORT).show();

    }
}
