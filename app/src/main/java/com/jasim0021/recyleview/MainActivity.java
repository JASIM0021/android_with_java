package com.jasim0021.recyleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> arrContact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclar_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ContactModel model = new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890");
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"Jasim","1234567890"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"Jasim1","1234567890"));
        arrContact.add(new ContactModel(com.google.android.material.R.drawable.abc_btn_borderless_material,"Jasim2","1234567890"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(getApplicationContext(),arrContact);

        recyclerView.setAdapter(adapter);
    }
}