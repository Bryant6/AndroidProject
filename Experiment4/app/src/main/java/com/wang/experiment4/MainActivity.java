package com.wang.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    private TextView nameText;
    private TextView phoneText;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this,"experiment.db",null,1);
        nameText = findViewById(R.id.nameText);
        phoneText = findViewById(R.id.phoneText);
        listView = findViewById(R.id.listView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper = null;
    }

    public void add(View view){
        User user = new User(nameText.getText().toString(),phoneText.getText().toString());
        if(user.getName()!=null){
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name",user.getName());
            values.put("phone",user.getPhone());
            db.insert("user",null,values);
            db.close();
            Toast.makeText(view.getContext(),"信息已添加！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(view.getContext(),"用户名不能为空！",Toast.LENGTH_SHORT).show();
        }

    }
    public void query(View view){
        db = dbHelper.getReadableDatabase();
        List<User> userList = new ArrayList<User>();
        Cursor cursor = db.query("user",null,null,null,null,null,null);
        if(cursor.getCount() == 0){
            Toast.makeText(view.getContext(),"没有数据！",Toast.LENGTH_SHORT).show();
        }else {
            cursor.moveToFirst();
        }
        while (cursor.moveToNext()){
            User user = new User(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
            userList.add(user);
        }

        cursor.close();
        db.close();

        List<HashMap<String,Object>> listitems = new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<userList.size();i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("id",userList.get(i).getId());
            map.put("name",userList.get(i).getName());
            map.put("phone",userList.get(i).getPhone());
            listitems.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitems,R.layout.listviewitem,
                new String[]{"id","name","phone"},new int[]{R.id.textView3,R.id.textView4,R.id.textView5});

        listView.setAdapter(simpleAdapter);
    }
    public void update(View view){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone",phoneText.getText().toString());
        db.update("user",values,"name=?",new String[]{nameText.getText().toString()});
        Toast.makeText(view.getContext(),"信息已修改！",Toast.LENGTH_SHORT).show();
        db.close();
    }
    public void delete(View view){
        db = dbHelper.getWritableDatabase();
        db.delete("user","name=?",new String[]{nameText.getText().toString()});
        Toast.makeText(view.getContext(),"信息已删除！",Toast.LENGTH_SHORT).show();
        db.close();
    }
}
