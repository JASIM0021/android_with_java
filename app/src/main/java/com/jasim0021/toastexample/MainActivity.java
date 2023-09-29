package com.jasim0021.toastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        Toast toast = new Toast(getApplicationContext());
       View view =  getLayoutInflater().inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.Custom_toast));
        toast.setView(view);
        TextView tfToast = view.findViewById(R.id.textView);
        tfToast.setText("Custopm Toast");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "This is example Toast", Toast.LENGTH_SHORT).show();
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER|Gravity.END,0,0);
                toast.show();
            }
        });
    }
}