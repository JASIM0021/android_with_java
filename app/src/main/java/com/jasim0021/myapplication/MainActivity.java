package com.jasim0021.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnNext;
        btnNext = findViewById(R.id.next_btn);

        Intent intent ;
        intent = new Intent(MainActivity.this,Activity2.class);
        intent.putExtra("title","Home");
        intent.putExtra("name","Sk Jasimuddin");
        intent.putExtra("roll_no",4);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);
            }
        });
    }
}