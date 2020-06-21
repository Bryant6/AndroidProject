package com.wang.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;
    private Button stopButton;

    private Button bindButton;
    private Button unbindButton;

    private Button statusButton;

    private Button start;
    private Button pause;

    private Button stop;


    private MyServiceConnection conn;
    private MyService2.MyBinder binder;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.button_start);
        stopButton = findViewById(R.id.button_stop);
        bindButton = findViewById(R.id.bindButton);
        unbindButton = findViewById(R.id.unbindButton);
        statusButton = findViewById(R.id.statusButton);
        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        bindButton.setOnClickListener(this);
        unbindButton.setOnClickListener(this);
        statusButton.setOnClickListener(this);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

        conn = new MyServiceConnection();

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,MyService.class);
        Intent intent2 = new Intent(this,MyService2.class);
        switch (view.getId()){
            case R.id.button_start:
                this.startService(intent);
                break;
            case R.id.button_stop:
                this.stopService(intent);
                break;
            case R.id.bindButton:
                this.bindService(intent2,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbindButton:
                this.unbindService(conn);
                break;
            case R.id.statusButton:
                int count = binder.getCount();
                break;
            case R.id.start:
                mediaPlayer = MediaPlayer.create(this,R.raw.a);
                mediaPlayer.start();
                break;
            case R.id.pause:
                if(mediaPlayer != null&&mediaPlayer.isPlaying())
                    mediaPlayer.pause();
                break;
            case R.id.stop:
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                break;
        }
    }

    class MyServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binder = (MyService2.MyBinder)iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
