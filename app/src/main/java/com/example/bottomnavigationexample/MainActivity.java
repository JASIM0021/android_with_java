package com.example.bottomnavigationexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView = findViewById(R.id.bnView);
//        fragmentChange(new AFragment(),0);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int id = item.getItemId();

               if(id==R.id.navHome){
                   fragmentChange(new AFragment(),0);
               } else if (id==R.id.navContact) {
                   fragmentChange(new BFragment(),1);
               } else if (id==R.id.navSearch) {
                   fragmentChange(new CFragment(),1);
               } else if (id==R.id.navHelp) {
                   fragmentChange(new DFragment(),1);
               } else {  fragmentChange(new EFragment(),1);
               }
    return true;
            }
        });

        bnView.setSelectedItemId(R.id.navHome);
    }

    private void fragmentChange(Fragment fragment,int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag == 0){
            ft.add(R.id.fram_container,fragment);
        }else{
            ft.replace(R.id.fram_container,fragment);
        }
    ft.commit();

    }
}