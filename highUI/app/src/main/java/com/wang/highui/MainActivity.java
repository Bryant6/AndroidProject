package com.wang.highui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;
    private ListView listView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);

        String[] data = getResources().getStringArray(R.array.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,data);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(listView.getCheckedItemCount());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listView2 = findViewById(R.id.listView2);

        int[] icons = new int[]{R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};

        List<HashMap<String,Object>> listItem = new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<Math.min(icons.length,data.length);i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("nickName",data[i]);
            map.put("icon",icons[i]);
            listItem.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItem,R.layout.layout,new String[]{"nickName","icon"},
                new int[]{R.id.itemTitle,R.id.itemImage});
        listView2.setAdapter(simpleAdapter);


    }
}




























