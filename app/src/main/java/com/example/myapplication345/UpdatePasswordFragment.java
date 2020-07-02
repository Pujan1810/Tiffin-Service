package com.example.myapplication345;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UpdatePasswordFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_update_password,container,false);

        final EditText edt_password_email = rootview.findViewById(R.id.edt_passwd_email);
        final String str_password_email = edt_password_email.getText().toString();

        final EditText edt_old_password = rootview.findViewById(R.id.edt_passwd_old);
        final String str_old_password = edt_old_password.getText().toString();

        final EditText edt_new_password = rootview.findViewById(R.id.edt_passwd_new);
        final String str_new_password = edt_new_password.getText().toString();

        final EditText edt_new_confirm_password = rootview.findViewById(R.id.edt_passwd_new_confirm);
        final String str_new_confirm_password = edt_new_confirm_password.getText().toString();

        Button update_password = rootview.findViewById(R.id.btn_update_password);

        final Fragment editProfileFragment = new EditProfileFragment();

        update_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyApplication345", Context.MODE_PRIVATE);

                final String profile_password = sharedPreferences.getString("User_password","");
                final String profile_email = sharedPreferences.getString("User_email1","");

                if(str_password_email=="")
                {
                    edt_password_email.setError("Enter Email ID");
                }



                else if(str_old_password=="")
                {
                        edt_old_password.setError("Enter Old Password");
                }


                else if(str_new_password=="")
                {
                    edt_new_password.setError("Enter New Password");
                }
                else if(str_new_confirm_password=="")
                {
                    edt_new_confirm_password.setError("Confirm New Password");
                }

                /*else if(!str_password_email.equals(profile_email) )
                {
                    edt_password_email.setError("Enter correct email");
                }*/

                else if(str_old_password.equals(profile_password) && str_password_email.equals(profile_email)) {
                    loadUrlData(str_password_email, str_old_password, str_new_password, str_new_confirm_password);

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.framelayout, editProfileFragment); // give your fragment container id in first parameter
                    transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                    transaction.commit();
                    Toast.makeText(getActivity(), "Changes saved successfully", Toast.LENGTH_SHORT).show();
                }
            } private void loadUrlData(final String password_email,final String old_password,final String new_password,final String confirm_new_password)
                {
                    final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                    progressDialog.setMessage("Loading");
                    progressDialog.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Util.URL_User_update_password, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            progressDialog.dismiss();
                            Log.e("TAG", "onResponse: "+response );
                            try {
                                JSONObject jsonObject = new JSONObject(response);
/*
                                JSONObject dataObject = jsonObject.getJSONObject("data");
                                String userId = dataObject.getString("userId");
                                String roleId = dataObject.getString("roleId");
                                String userName = dataObject.getString("userName");
                                String address = dataObject.getString("address");
                                String city = dataObject.getString("city");
                                String emailId = dataObject.getString("emailId");
                                String phone = dataObject.getString("phone");
                                SharedPreferences sharedPreferences = getSharedPreferences("MyApplication345", Context.MODE_PRIVATE);

                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("User_uname", userName);
                                editor.putString("User_email1", emailId);
                                editor.putString("User_contact_no", phone);
                                editor.putString("User_addr", address);
                                editor.putString("User_city", city);
                                editor.commit();

                                Intent i = new Intent(getActivity(), NavMain.class);
                                startActivity(i);

                                finish();
*/





                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            //Toast.makeText(LoginActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity(), ""+error, Toast.LENGTH_SHORT).show();

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> params = new HashMap<String, String>();
                            // params.put("first_name", strFn);
                            params.put("email", password_email);
                            params.put("oldPassword", old_password);
                            params.put("newPassword", new_password);
                             params.put("confirmNewPassword", confirm_new_password);
                            // params.put("gender", "female");

                            return params;
                        }
                    };

                    VolleySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);



                }

        });
        return rootview;



    }
}
