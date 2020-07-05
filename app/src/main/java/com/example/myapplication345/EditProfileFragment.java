package com.example.myapplication345;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.w3c.dom.Text;

public class EditProfileFragment extends Fragment {


    public View onCreateView( @Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_edit_profile,container,false);

        TextView edt_pr_password =  rootview.findViewById(R.id.edt_profile_password);
        String edt_profile_password = edt_pr_password.getText().toString();
        final Fragment updatePasswordFragment = new UpdatePasswordFragment();
        /*edt_pr_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, updatePasswordFragment); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });*/



        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyApplication345", Context.MODE_PRIVATE);
        String edt_profile_fname = sharedPreferences.getString("User_uname","");
        String edt_profile_emaild1 = sharedPreferences.getString("User_email1","");
        String edt_profile_contact_no = sharedPreferences.getString("User_contact_no","");
      //  String profile_password = sharedPreferences.getString("User_password","");
        String edt_profile_addr = sharedPreferences.getString("User_addr","");
        String edt_profile_city = sharedPreferences.getString("User_city","");

     /*   Bundle idbundle = null;
         idbundle = getArguments();
        String myid = idbundle.getString("id");
*/

        TextView edt_pr_uname = rootview.findViewById(R.id.edt_profile_uname);
        TextView edt_pr_email = rootview.findViewById(R.id.edt_profile_emailid);
        TextView edt_pr_contact_no = rootview.findViewById(R.id.edt_profile_contact_no);
        // TextView Pr_password = rootview.findViewById(R.id.profile_password);
        TextView edt_pr_addr = rootview.findViewById(R.id.edt_profile_addr);
        TextView edt_pr_city = rootview.findViewById(R.id.edt_profile_city);


        edt_pr_uname.setText(edt_profile_fname);
        edt_pr_email.setText(edt_profile_emaild1);
        edt_pr_contact_no.setText(edt_profile_contact_no);
        // Pr_password.setText(profile_password);
        edt_pr_addr.setText(edt_profile_addr);
        edt_pr_city.setText(edt_profile_city);

        return rootview;





    }
}
