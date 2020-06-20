package com.example.myapplication345;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {


    private EditText edtuname;
    private EditText edtpassword;



    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtuname = (EditText) findViewById(R.id.edt_email);
        edtpassword = (EditText) findViewById(R.id.edt_password);



        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                final String struname = edtuname.getText().toString();
                final String strpassword = edtpassword.getText().toString();

                if (struname.equals("")) {

                    //Toast.makeText(LoginActivity.this, "Enter Email ID", Toast.LENGTH_SHORT).show();
                    edtuname.setError("Enter Email ID");
                }
                else if(!struname.matches(emailPattern)) {
                    edtuname.setError("Enter valid Email address");
                }
                else if (strpassword.equals("")) {
                    //Toast.makeText(LoginActivity.this, "Enter Password ", Toast.LENGTH_SHORT).show();
                    edtpassword.setError("Enter password");
                }
                else
                {



                    loadUrlData(struname,strpassword);



 /**/





                    /*startActivity(new Intent(LoginActivity.this,NavMain.class));
                    Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();*/


                }



            }
            private void loadUrlData(final String struname,final String strpassword)
            {
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Loading");
                progressDialog.show();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, Util.URL_User_authenticate, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();
                        Log.e("TAG", "onResponse: "+response );
                        try {
                            JSONObject jsonObject = new JSONObject(response);
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

                            Intent i = new Intent(LoginActivity.this, NavMain.class);
                            startActivity(i);

                            finish();





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                          //Toast.makeText(LoginActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, ""+error, Toast.LENGTH_SHORT).show();

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();
                        // params.put("first_name", strFn);
                        // params.put("last_name", strLn);
                        params.put("email", struname);
                        params.put("password", strpassword);
                        // params.put("picurl", strImage);
                        // params.put("gender", "female");

                        return params;
                    }
                };

                VolleySingleton.getInstance(LoginActivity.this).addToRequestQueue(stringRequest);



        }





            });

        Button btn1 =(Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, Signup.class));

            }
        });

        }



}







