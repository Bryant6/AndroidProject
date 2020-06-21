package com.wang.experiment1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;

    private CheckBox checkBox;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        textView = findViewById(R.id.textView7);

        spinner.getSelectedItem();
        spinner.setSelection(2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("选择专业：")
                        .setMessage(spinner.getSelectedItem().toString())
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new spinnerListener())
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("用户名：");
                stringBuffer.append(editText1.getText());
                stringBuffer.append("\n");
                stringBuffer.append("密码:");
                stringBuffer.append(editText2.getText());
                stringBuffer.append("\n");
                stringBuffer.append("电话:");
                stringBuffer.append(editText3.getText());
                stringBuffer.append("\n");
                stringBuffer.append("性别:");
                radioButton1 = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                stringBuffer.append(radioButton1.getText().toString());
                stringBuffer.append("\n");
                stringBuffer.append("爱好:");
                if(checkBox.isChecked())
                    stringBuffer.append(checkBox.getText().toString()+" ");
                if(checkBox2.isChecked())
                    stringBuffer.append(checkBox2.getText().toString()+" ");
                if(checkBox3.isChecked())
                    stringBuffer.append(checkBox3.getText().toString());
                stringBuffer.append("\n");
                stringBuffer.append("专业：");
                stringBuffer.append(spinner.getSelectedItem().toString());

                textView.setText(stringBuffer);
            }
        });

    }

    private class spinnerListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"你选择了"+spinner.getSelectedItem().toString()+"专业",Toast.LENGTH_SHORT).show();
        }
    }

    public void click(View v){
        editText1.setText("");
        editText2.setText("请输入六位数字密码");
        editText3.setText("");

        radioButton2.setChecked(true);
        checkBox.setChecked(false);
        checkBox2.setChecked(true);
        checkBox3.setChecked(false);

        spinner.setSelection(2);

        textView.setText("西华大学是一所学科门类齐全、多学科协调发展的省属综合性大学，是国家中西部高校基础能力建设工程重点支持高校，教育部本科教学工作水平评估优秀高校，四川省首批深化创新创业教育改革示范高校，四川省首批文明校园，四川省绿化先进单位。  学校始建于1960年，时名四川农业机械学院，是当时全国7个大区布点建立的农业机械本科院校之一。1978年被四川省政府列为省属重点大学。1983年更名为四川工业学院。2003年四川工业学院与成都师范高等专科学校合并组建西华大学，2008年四川经济管理学院整体并入。  学校1982年成为国务院学位委员会首批学士学位授予权单位，1985年开始招收硕士研究生，1990年具有硕士学位授予权。  学校现有校本部、彭州、人南、宜宾四个校区，校园面积近3000亩。图书馆面积5万余平方米，纸质文献260余万册，电子书刊800余万册，是全国收藏《中华再造善本丛书》的100所高校之一。  学校在省属高校中先行先试“首席科学家”模式，拥有高级专业技术职务人员 960余名，其中，国家杰出青年基金获得者、教育部“长江学者”特聘教授、新世纪百千万人才工程国家级人选、国务院政府特殊津贴专家及四川省“千人计划”引进人才、学术和技术带头人等各类专家150余人。聘请了一批中国科学院院士、中国工程院院士以及国内外著名专家担任学校特聘教授。唐丹老师以总分第一名的优异成绩获得全国青年教师教学竞赛文科组一等奖，荣获四川省“五一”劳动奖章；吴昌东老师获得全国高校青年教师电子技术基础、电子线路课程授课竞赛一等奖。");

    }

}





