package com.wang.experiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private Button bt2;
    private Button bt3;
    private ImageView imageView;

    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Resources res = this.getResources();

        bt = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        imageView = findViewById(R.id.imageView);

        final TypedArray img = res.obtainTypedArray(R.array.img);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageView.getAlpha()>=0.2){
                    imageView.setAlpha((float) (imageView.getAlpha()-0.1));
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageView.getAlpha()<=0.8){
                    imageView.setAlpha((float) (imageView.getAlpha()+0.1));
                }
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = (count+1)%5;
                imageView.setImageResource(img.getResourceId(count,0));
            }
        });
    }
}
