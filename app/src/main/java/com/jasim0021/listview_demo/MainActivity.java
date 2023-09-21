package com.jasim0021.listview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIdproof = new ArrayList<>();
    ArrayList<String> arr_city = new ArrayList<>();

    ArrayAdapter<String> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spiner_list);
        autoCompleteTextView = findViewById(R.id.auto_Complete);

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



//        Spiner
        arrIdproof.add("Adhar");
        arrIdproof.add("Voter");
        arrIdproof.add("Pan");
        arrIdproof.add("Driving");
        arrIdproof.add("Polio");
        arrIdproof.add("Admit");

        ArrayAdapter spinerAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,arrIdproof);
        spinner.setAdapter(spinerAdapter);


//        AutoComplete

arr_city.add("Bardhaman");
arr_city.add("Kolkata");
arr_city.add("Purolia");
arr_city.add("Asansol");
arr_city.add("birbhum");
arr_city.add("bankura");

ArrayAdapter actvAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,arr_city);

autoCompleteTextView.setAdapter(actvAdapter);

    }
}