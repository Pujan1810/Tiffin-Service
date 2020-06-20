package com.example.myapplication345;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<DataModel> dataModelArrayList;
    public MyBaseAdapter(Context context, ArrayList<DataModel> dataModelArrayList) {

        this.dataModelArrayList = dataModelArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(R.layout.raw_grid,null);

        TextView tvData = convertView.findViewById(R.id.grid_data);
        ImageView imgData = convertView.findViewById(R.id.img_data);


        tvData.setText(dataModelArrayList.get(position).getStrLang());
        imgData.setImageResource(dataModelArrayList.get(position).getImgLang());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strData = dataModelArrayList.get(position).getStrLang();
                Toast.makeText(context, ""+strData, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
