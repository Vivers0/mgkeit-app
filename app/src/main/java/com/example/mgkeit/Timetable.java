package com.example.mgkeit;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Timetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
//        getActionBar().setTitle("Расписание");


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
        Parser task = new Parser();
        task.execute();
    }

    //

    class Parser extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            Log.d("res111", "doInBackground");
            String res_request="";
            Request request = new Request.Builder().url("https://vivers0.pythonanywhere.com/api/timetable/").build();
            try {
                Response response = client.newCall(request).execute();
                res_request=response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
         return res_request;
        }
        @Override
        protected void onPostExecute(String json)
        {
            ListView listView;
            listView = findViewById(R.id.lv);
            try {
//                JSONArray
                ArrayList<JSONArray> timetables = new ArrayList<>();
                JSONArray array = new JSONObject(json).getJSONArray("timetable");
                timetables.add(array);
                Log.d("asdf",array.get(0).toString());
                TimetableAdaptor timetableAdaptor = new TimetableAdaptor(array, Timetable.this);
                listView.setAdapter(timetableAdaptor);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    }
