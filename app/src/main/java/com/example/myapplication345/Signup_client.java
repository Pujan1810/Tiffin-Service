package com.example.myapplication345;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Signup_client extends AppCompatActivity {

    private EditText edtcuname;
    private EditText edtcresname;
    private EditText edtcemail;
    private EditText edtcpasswd;
    private EditText edtcresemail;
    private EditText edtccontact;
    private EditText edtcrescontact;
    private EditText edtcaddress;
    private EditText edtcresaddress;
    private EditText edtccity;
    final String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    final String num="[0-9]";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_signup_client);

        edtcuname = (EditText) findViewById(R.id.c_name);
        edtcresname = (EditText) findViewById(R.id.c_resname);
        edtcemail = (EditText) findViewById(R.id.c_email);
        edtcpasswd = (EditText) findViewById(R.id.c_passwd);
        edtcresemail = (EditText) findViewById(R.id.c_resemail);
        edtccontact = (EditText) findViewById(R.id.c_contactno);
        edtcrescontact = (EditText) findViewById(R.id.c_rescontactno);
        edtcaddress = (EditText) findViewById(R.id.c_addr);
        edtcresaddress = (EditText) findViewById(R.id.c_resaddr);
        edtccity = (EditText) findViewById(R.id.c_city);

        Button btn3 = (Button) findViewById(R.id.btn_csignup);

        btn3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                final String strcuname = edtcuname.getText().toString();
                final String strcresname = edtcresname.getText().toString();
                final String strcemail = edtcemail.getText().toString();
                final String strcpasswd = edtcpasswd.getText().toString();
                final String strcresemail = edtcresemail.getText().toString();
                final String strccontact = edtccontact.getText().toString();
                final String strcrescontact = edtcrescontact.getText().toString();
                final String strcaddr = edtcaddress.getText().toString();
                final String strcresaddr = edtcresaddress.getText().toString();
                final String strccity = edtccity.getText().toString();


                if (strcuname.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter User Name", Toast.LENGTH_SHORT).show();
                } else if (strcresname.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter Restaurant Name", Toast.LENGTH_SHORT).show();
                } else if (strcemail.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter Email ID", Toast.LENGTH_SHORT).show();
                } else if (strcresemail.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter Restaurant Email ID", Toast.LENGTH_SHORT).show();
                } else if (!strcemail.matches(emailPattern)) {
                    Toast.makeText(Signup_client.this, "Enter valid Email Id", Toast.LENGTH_SHORT).show();
                } else if (!strcresemail.matches(emailPattern)) {
                    Toast.makeText(Signup_client.this, "Enter valid Email Id", Toast.LENGTH_SHORT).show();
                } else if (strccontact.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter Client Phone Number", Toast.LENGTH_SHORT).show();
                } else if (!strccontact.matches(num)) {
                    Toast.makeText(Signup_client.this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                } else if (strccontact.length() < 10) {
                    Toast.makeText(Signup_client.this, "Enter Valid Client Phone Number", Toast.LENGTH_SHORT).show();
                } else if (strccontact.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter Client Phone Number", Toast.LENGTH_SHORT).show();
                } else if (!strcrescontact.matches(num)) {
                    Toast.makeText(Signup_client.this, "Enter Valid Restaurant Phone Number", Toast.LENGTH_SHORT).show();
                } else if (strcrescontact.length() < 10) {
                    Toast.makeText(Signup_client.this, "Enter Valid Restaurant Phone Number", Toast.LENGTH_SHORT).show();
                } else if (strcaddr.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter Password", Toast.LENGTH_SHORT).show();

                } else if (strcresaddr.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter the address", Toast.LENGTH_SHORT).show();

                } else if (strccity.equals("")) {
                    Toast.makeText(Signup_client.this, "Enter the city", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(Signup_client.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Signup_client.this,LoginActivity.class));
                }

            }
        });
    }
}
