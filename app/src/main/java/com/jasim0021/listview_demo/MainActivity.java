package com.jasim0021.listview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrNames = new ArrayList<>();

    ArrayAdapter<String> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");
        arrNames.add("Jasim");

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 1 ){
                    Toast.makeText(MainActivity.this, "Position 1 clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}