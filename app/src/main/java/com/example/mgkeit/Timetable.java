package com.example.mgkeit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Timetable extends AppCompatActivity {

    ListView listView;
    ArrayList<String> timetables = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActionBar().setTitle("Расписание");
        setContentView(R.layout.activity_timetable);
        listView = findViewById(R.id.lv);

//        SharedPreferences prefs = getSharedPreferences("com.example.mgkeit.PREFERENCE", Context.MODE_PRIVATE);
//        if (prefs.getInt("test1", -1) == -1) {
//            EditText text = (EditText)findViewById(R.id.editText1);
//            text.setText("NO");
//            prefs.edit().putInt("test1", 0).putString("test2", "agot").commit();
//        } else {
//            EditText text = (EditText)findViewById(R.id.editText1);
//            text.setText(prefs.getString("test2", "-1"));
//        };
//        SharedPreferences.Editor editor = prefs.edit();
//        edit.put
    TimetableAdaptor timetableAdaptor = new TimetableAdaptor(timetables,Timetable.this);
    listView.setAdapter(timetableAdaptor);
    }
}