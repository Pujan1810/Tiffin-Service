package com.example.myapplication345;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import de.hdodenhof.circleimageview.CircleImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View rootview = inflater.inflate(R.layout.fragment_profile,container,false);
CircleImageView circleImageView =  rootview.findViewById(R.id.profile_image) ;
                circleImageView.setImageResource(R.drawable.ic_profile_default);

        Button btn_profile = rootview.findViewById(R.id.button_profile);


        btn_profile.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    Toast.makeText(getContext(),"Saved Data Successfully",Toast.LENGTH_SHORT).show();
                }
            }

        })
               );
       SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyApplication345", Context.MODE_PRIVATE);
        String profile_fname = sharedPreferences.getString("User_uname","");
        String profile_emaild1 = sharedPreferences.getString("User_email1","");
        String profile_contact_no = sharedPreferences.getString("User_contact_no","");
      //  String profile_password = sharedPreferences.getString("User_password","");
        String profile_addr = sharedPreferences.getString("User_addr","");
        String profile_city = sharedPreferences.getString("User_city","");


        TextView Pr_uname = rootview.findViewById(R.id.profile_uname);
        TextView Pr_email = rootview.findViewById(R.id.profile_emailid);
        TextView Pr_contact_no = rootview.findViewById(R.id.profile_contact_no);
       // TextView Pr_password = rootview.findViewById(R.id.profile_password);
        TextView Pr_addr = rootview.findViewById(R.id.profile_addr);
        TextView Pr_city = rootview.findViewById(R.id.profile_city);


        Pr_uname.setText(profile_fname);
        Pr_email.setText(profile_emaild1);
        Pr_contact_no.setText(profile_contact_no);
       // Pr_password.setText(profile_password);
        Pr_addr.setText(profile_addr);
        Pr_city.setText(profile_city);

        return rootview;



    }




}
