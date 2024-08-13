package com.example.layoutdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OlympicsGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Olympics> olympicsList;

    public OlympicsGridAdapter(Context context, ArrayList<Olympics> olympicsList) {
        this.context = context;
        this.olympicsList = olympicsList;
    }

    @Override
    public int getCount() {
        return olympicsList.size();
    }

    @Override
    public Object getItem(int position) {
        return olympicsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item_olympics, parent, false);
        }

        Olympics currentItem = olympicsList.get(position);

        ImageView imageView = convertView.findViewById(R.id.olympicsImage);
        TextView textView = convertView.findViewById(R.id.olympicsSport);

        imageView.setImageResource(currentItem.getOlympicsImage());
        textView.setText(currentItem.getOlympicsSport());

        return convertView;
    }
}