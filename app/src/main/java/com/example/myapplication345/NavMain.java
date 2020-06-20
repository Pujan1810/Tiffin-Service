package com.example.myapplication345;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class NavMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener



        {



   private DrawerLayout drawer;


            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_nav);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


         drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(NavMain.this,drawer,toolbar,R.string.navigation_app_bar_open_drawer_description,R.string.navigation_app_bar_close_drawer_description);
        drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

                View navView = navigationView.getHeaderView(0);
                /*CircleImageView circleImageView =  navView.findViewById(R.id.profile_image) ;
                circleImageView.setImageResource(R.drawable.ic_profile_default);*/
        SharedPreferences sharedPreferences = getSharedPreferences("MyApplication345",MODE_PRIVATE);
        String strUser = sharedPreferences.getString("User_email1","");
        String strUname = sharedPreferences.getString("User_uname","");

        TextView tvUseremail = navView.findViewById(R.id.textView2);
        TextView tvUserUname = navView.findViewById(R.id.textView1);

        tvUseremail.setText(strUser);
        tvUserUname.setText(strUname);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.framelayout, homeFragment);
                fragmentTransaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {



        Fragment fragment = null;
        if (menuItem.getItemId() == R.id.nav_home){

            fragment = new HomeFragment();
         //   Toast.makeText(this, "HOME", Toast.LENGTH_SHORT).show();

        } else if (menuItem.getItemId() == R.id.nav_profile){


            fragment = new ProfileFragment();

           //Toast.makeText(this, "PROFILE", Toast.LENGTH_SHORT).show();

        }else if (menuItem.getItemId() == R.id.nav_list){

            fragment = new ListFragment();
            //Toast.makeText(this, "List", Toast.LENGTH_SHORT).show();
        }else if (menuItem.getItemId() == R.id.nav_logout){

            startActivity(new Intent(NavMain.this, LoginActivity.class));
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences = getSharedPreferences("MyApplication345",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

        }

        if (fragment != null) {


            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayout, fragment);
            fragmentTransaction.commit();

        }





        drawer.closeDrawer(GravityCompat.START);


        return false;
    }


            }

