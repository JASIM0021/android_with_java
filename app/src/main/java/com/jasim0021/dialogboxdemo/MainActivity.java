package com.jasim0021.dialogboxdemo;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Terms and Conditon");
        alertDialog.setIcon(R.drawable.baseline_info_24);
        alertDialog.setMessage("Have you read all term and condion");

        alertDialog.setButton("Yes , i've Read", (DialogInterface.OnClickListener) (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Yes , you can proceed now", Toast.LENGTH_SHORT).show());
        alertDialog.show();

//        with morethan one button
//      AlertDialog.Builder deletedialog = new AlertDialog.Builder(MainActivity.this);
//      deletedialog.setTitle("Delete");
//      deletedialog.setIcon(R.drawable.baseline_delete_24);
//      deletedialog.setMessage("Are you sure want to delete ?");
//      deletedialog.setNegativeButton("No",new DialogInterface.OnClickListener(){
//
//          @Override
//          public void onClick(DialogInterface dialogInterface, int i) {
//              finish();
//          }
//      });
//
//      deletedialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//          @Override
//          public void onClick(DialogInterface dialogInterface, int i) {
//              Toast.makeText(MainActivity.this, "Item Deleted Successfull", Toast.LENGTH_SHORT).show();
//          }
//      });
//      deletedialog.setNeutralButton("Okey", new DialogInterface.OnClickListener() {
//          @Override
//          public void onClick(DialogInterface dialogInterface, int i) {
//              Toast.makeText(MainActivity.this, "Newton button clicked", Toast.LENGTH_SHORT).show();
//          }
//      });
//      deletedialog.show();



    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder onExitDialog = new AlertDialog.Builder(MainActivity.this);
        onExitDialog.setTitle("Exit?");
        onExitDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        onExitDialog.setMessage("Are you sure want to exit ?");
        onExitDialog.setNegativeButton("No",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome back", Toast.LENGTH_SHORT).show();
            }
        });

        onExitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        onExitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel button clicked", Toast.LENGTH_SHORT).show();
            }
        });
        onExitDialog.show();
    }
}