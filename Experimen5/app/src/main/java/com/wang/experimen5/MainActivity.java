package com.wang.experimen5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button get;

    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;

    private MyService.MyBinder myBinder;
    private MyConn myconn;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        get = findViewById(R.id.get);
        t1 = findViewById(R.id.textView11);
        t2 = findViewById(R.id.textView12);
        t3 = findViewById(R.id.textView21);
        t4 = findViewById(R.id.textView22);

        intent = new Intent(this,MyService.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myconn = new MyConn();
                bindService(intent,myconn,BIND_AUTO_CREATE);
                Toast.makeText(view.getContext(),"地震监测服务绑定成功",Toast.LENGTH_SHORT).show();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myconn == null){
                    Toast.makeText(view.getContext(),"请先绑定地震监测服务",Toast.LENGTH_SHORT).show();
                }
                else{
                    System.out.println(myBinder.getInfo1());
                    t1.setText(myBinder.getInfo1());
                    t2.setText(myBinder.getInfo2());
                    t3.setText(myBinder.getInfo3());
                    t4.setText(myBinder.getInfo4());
                }
            }
        });
    }

    private class MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyService.MyBinder) iBinder;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
