package com.example.navigationdrawerexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);

        loadfragment(new AFragment(),0);
//        step 1
//        set actionBar
        setSupportActionBar(toolbar);

//        step 2
//        set drawer toggleing
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
//    adding listner on drawer layout
        drawerLayout.addDrawerListener(toogle);

//        syncing the toogle
        toogle.syncState();

//        adding click listner on menu item

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id==R.id.drawerHome){
                    loadfragment(new AFragment(),1);
                } else if (id==R.id.brawarNotes) {
                    loadfragment(new BFragment(),1);
                } else if (id==R.id.drawerSetting) {
                    loadfragment(new CFragment(),1);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });





    }
    private  void loadfragment(Fragment fragment,int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
       if(flag == 0){
           ft.add(R.id.fram_container,fragment );
       }else{
           ft.replace(R.id.fram_container,fragment );
       }
       ft.commit();
    }

    @Override
    public void onBackPressed() {
       if(drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
       }else{
           super.onBackPressed();
       }
    }
}