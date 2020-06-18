package com.example.myapplication345;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication345.DataModel;
import com.example.myapplication345.MyBaseAdapter;
import com.example.myapplication345.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    GridView gridView ;
    String strLang[]={"Android","Java",".net","PHP","Python"};
    int imgLang[]={R.mipmap.ic_launcher,R.drawable.ic_logo,R.drawable.ic_profile_default,R.drawable.ic_logout,R.drawable.ic_person};
    ArrayList<DataModel> dataModelArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_home,container,false);
        gridView = rootview.findViewById(R.id.grid);
        dataModelArrayList= new ArrayList<DataModel>();

        for (int i=0;i<strLang.length;i++)
        {
            DataModel dataModel = new DataModel(strLang[i],imgLang[i]);
            dataModelArrayList.add(dataModel);
        }

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(getActivity(),dataModelArrayList);
        gridView.setAdapter(myBaseAdapter);

        return rootview;
    }
}
