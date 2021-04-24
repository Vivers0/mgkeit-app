package com.example.mgkeit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimetableAdaptor extends BaseAdapter {
    JSONArray list;//данные для списка
    Context context;//активити на котором появится список
    LayoutInflater inflater;
    public TimetableAdaptor(JSONArray list, Context context)
    {
        this.list = list;
        this.context = context;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.length();
    }

    @Override
    public JSONObject getItem(int position) {
        try {
            return (JSONObject) list.get(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.timetableitem, null);
        }

        try
        {
            JSONObject object= (JSONObject) list.get(position);
            String spl = object.getString("timetable");
            Log.d("res111", String.valueOf(object));
            TextView name = convertView.findViewById(R.id.name);
            name.setText(spl);
//            TextView room = convertView.findViewById(R.id.room);
//            room.setText(spl);
//            TextView time = convertView.findViewById(R.id.time);
//            time.setText(spl);

        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        return convertView;
    }
}
