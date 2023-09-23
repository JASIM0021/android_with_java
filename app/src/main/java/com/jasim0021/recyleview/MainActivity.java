package com.jasim0021.recyleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> arrContact = new ArrayList<>();
    RecyclerContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton faBtn = findViewById(R.id.flotingBtn);
        RecyclerView recyclerView = findViewById(R.id.recyclar_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

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

         adapter = new RecyclerContactAdapter(this,arrContact);

        recyclerView.setAdapter(adapter);


//        adding click listner on floting btn

        faBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);

                EditText editName,editNumber;

                Button btn;

                editName = dialog.findViewById(R.id.name_add_contact);
                editNumber = dialog.findViewById(R.id.number_add_contact);
                btn = dialog.findViewById(R.id.btn_add_contact);
                
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "",number = "";
                        if(!editName.getText().toString().equals("") && !editNumber.getText().toString().equals("")) {
                             name = editName.getText().toString();
                             number = editNumber.getText().toString();

                             arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,name,number));
                            adapter.notifyItemInserted(arrContact.size()-1);

                            recyclerView.scrollToPosition(arrContact.size()-1);
                            dialog.dismiss();

                        }else {
                            Toast.makeText(MainActivity.this, "Please Enter a Valid Input", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog.show();
            }
        });
    }
}