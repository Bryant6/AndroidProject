package com.wang.storagedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        SharedPreferences sp = this.getSharedPreferences("dataSP",this.MODE_PRIVATE);
        String username = sp.getString("username","null");
        if (username != "null")
            editText.setText(username);

        myHelper = new MyHelper(this,"test.db",null,1);
    }

    public void login(View view){
        String username = editText.getText().toString().trim();
        SharedPreferences sp = this.getSharedPreferences("dataSP",this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",username);
        editor.commit();
    }

    public void insert(){
        SQLiteDatabase db = myHelper.getWritableDatabase();
        db.execSQL("insert into info(name,password) values(?,?)",new String[]{"james","123"});
    }

    public void query(){
        SQLiteDatabase db = myHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from info where name =?",new String[]{"james"});
    }

    class MyHelper extends SQLiteOpenHelper{

        public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table info(id integer primary key autoincrement,name varchar(20) not null,password varchar(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
