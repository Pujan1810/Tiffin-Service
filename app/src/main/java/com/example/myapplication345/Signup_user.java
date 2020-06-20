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
import android.widget.RadioButton;
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

public class Signup_user extends AppCompatActivity {

    private EditText edtuname;
    private EditText edtroleid;

    private EditText edtemailid;
    private EditText edtpasswd;
    private EditText edtphonenumber;
    private EditText edtaddr;
    private EditText edtcity;
    final String emailPattern1 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    final String num = "[0-9]";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);

        edtuname = (EditText) findViewById(R.id.edt_uname);
        edtroleid = (EditText) findViewById(R.id.edt_roleid);

        edtemailid = (EditText) findViewById(R.id.edt_emailid);
        edtpasswd = (EditText) findViewById(R.id.edt_passwd);
        edtphonenumber = (EditText) findViewById(R.id.edt_phonenumber);
        edtaddr = (EditText) findViewById(R.id.edt_addr);
        edtcity = (EditText) findViewById(R.id.edt_city);

        Button btn2 = (Button) findViewById(R.id.button2);





        btn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                final String struname = edtuname.getText().toString();
                final String strroleid = "4";

                final String stremailid = edtemailid.getText().toString();
                final String strpasswd = edtpasswd.getText().toString();
                final String strphone = edtphonenumber.getText().toString();
                final String straddr = edtaddr.getText().toString();
                final String strcity = edtcity.getText().toString();


                if (struname.equals("")) {
                    Toast.makeText(Signup_user.this, "Enter First Name", Toast.LENGTH_SHORT).show();

                } else if (stremailid.equals("")) {
                    Toast.makeText(Signup_user.this, "Enter Email ID", Toast.LENGTH_SHORT).show();

                } else if (!stremailid.matches(emailPattern1)) {
                    Toast.makeText(Signup_user.this, "Enter valid Email Id", Toast.LENGTH_SHORT).show();
                } else if (strphone.equals("")) {
                    Toast.makeText(Signup_user.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();

                } else if (strphone.length() < 10) {
                    Toast.makeText(Signup_user.this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                }


                     else if (strpasswd.equals("")) {
                    Toast.makeText(Signup_user.this, "Enter Password", Toast.LENGTH_SHORT).show();

                } else if (straddr.equals("")) {
                    Toast.makeText(Signup_user.this, "Enter the address", Toast.LENGTH_SHORT).show();

                } else if (strcity.equals("")) {
                    Toast.makeText(Signup_user.this, "Enter the city", Toast.LENGTH_SHORT).show();

                } else {
                    loadUrlData(struname, stremailid, strpasswd, strphone, straddr, strcity, strroleid);


                }


            }

            private void loadUrlData(final String struname, final String stremailid, final String strpasswd, final String strphone, final String straddr, final String strcity, final String strroleid) {
                final ProgressDialog progressDialog = new ProgressDialog(Signup_user.this);
                progressDialog.setMessage("Loading");
                progressDialog.show();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, Util.URL_User_signup, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();
                        Log.e("TAG", "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);



                            Toast.makeText(Signup_user.this, "Signed up Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Signup_user.this, LoginActivity.class));

                            /*SharedPreferences sharedPreferences = getSharedPreferences("MyApplication345", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("User_uname", struname);
                            editor.putString("User_email1", stremailid);

                            editor.putString("User_contact_no", strphone);
                            editor.putString("User_password", strpasswd);
                            editor.putString("User_addr", straddr);
                            editor.putString("User_city", strcity);
                            editor.commit();

                            Intent i = new Intent(Signup_user.this, LoginActivity.class);
                            startActivity(i);

                            finish();
*/


                            // imgDp1.setImageBitmap(bitmap);

                            //  dataDisplay(strPath);


                           /* runOnUiThread(new Runnable() {
                                @Override
                                public void run() {


                                     i = new Intent(LoginActivity.this,ImageDisplayActivity.class);
                                    i.putExtra("IMAGE_PATH",strPath);
                                    startActivity(i);
                                }
                            }*/


                            // tvName.setText(strName);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(Signup_user.this, "" + response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Signup_user.this, "" + error, Toast.LENGTH_SHORT).show();

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();
                        params.put("userName", struname);
                        params.put("emailId", stremailid);
                        params.put("password", strpasswd);
                        params.put("phone", strphone);
                        params.put("address", straddr);
                        params.put("city", strcity);
                        params.put("roleId",strroleid);

                        return params;
                    }
                };

                VolleySingleton.getInstance(Signup_user.this).addToRequestQueue(stringRequest);


            }


        });

    }


}
