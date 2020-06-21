package com.wang.basicuidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private EditText editText2;
    private String userName;

    private Button bt1;
    private Button bt2;

    private RadioGroup radioGroup;

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = this.findViewById(R.id.editText);
        editText2 = this.findViewById(R.id.editText2);

        editText.setTextColor(0x22334455);

        bt1 = findViewById(R.id.bt1);
        //bt1.setOnClickListener(this);
        bt2 = findViewById(R.id.bt2);
        //bt2.setOnClickListener(this);

//        MyClickListener myClickListener = new MyClickListener();
//        bt2.setOnClickListener(myClickListener);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = editText.getText().toString();
                editText2.setText(userName+"bt2");
                editText2.setTextColor(0xF0FF0000);

                radioGroup = findViewById(R.id.genderrg);
                radioGroup.getCheckedRadioButtonId();
                ((RadioButton)radioGroup.getChildAt(0)).setChecked(true);
            }
        });

        radioGroup = findViewById(R.id.genderrg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioButton2){
                    editText.setText("man");
                }else{
                    editText.setText("woman");
                }
            }
        });


        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Toast.makeText(MainActivity.this,checkBox.getText()+"-"+compoundButton.getText(),Toast.LENGTH_SHORT).show();
                if(b){
                    Toast.makeText(MainActivity.this,compoundButton.getText()+"checked",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,compoundButton.getText()+"unchecked",Toast.LENGTH_SHORT).show();
                }
            }
        })

    }

    public void click(View view){
        userName = editText.getText().toString();
        editText2.setText(userName);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bt1){
            userName = editText.getText().toString();
            editText2.setText(userName+"bt1");
            editText2.setTextColor(0xF0FF0000);
        }else{
            userName = editText.getText().toString();
            editText2.setText(userName+"bt2");
            editText2.setTextColor(0xF0FF0000);
        }
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            userName = editText.getText().toString();
            editText2.setText(userName+"bt2");
            editText2.setTextColor(0xF0FF0000);
        }
    }
}
