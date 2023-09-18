package com.jasim0021.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent fromActivityMain = getIntent();

      String title =  fromActivityMain.getStringExtra("title");
       String name =  fromActivityMain.getStringExtra("name");
        int roll_no =  fromActivityMain.getIntExtra("roll_no",0);

        TextView textView,tvname,tvroll;
        textView = findViewById(R.id.text_view);
        tvname = findViewById(R.id.tv_name);
        tvroll = findViewById(R.id.tv_roll_no);
        textView.setText("title : "+title);
        tvname.setText("name :" +name);
        tvroll.setText("roll: "+roll_no);
    }
}