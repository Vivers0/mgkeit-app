package com.example.mgkeit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimetableAdaptor extends BaseAdapter {
    ArrayList<JSONObject> list;//данные для списка
    Context context;//активити на котором появится список
    LayoutInflater inflater;
    public TimetableAdaptor(ArrayList<JSONObject> list, Context context)
    {
        this.list = list;
        this.context = context;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.timetableitem,null);
        }
        TextView name = convertView.findViewById(R.id.name);
        try {
            name.setText(list.get(position).getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        TextView room = convertView.findViewById(R.id.room);

//        TextView time = convertView.findViewById(R.id.time);
        return convertView;
    }
}
