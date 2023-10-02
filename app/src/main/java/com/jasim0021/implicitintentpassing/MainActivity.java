package com.jasim0021.implicitintentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button dial,message,email,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dial = findViewById(R.id.btnDial);
        message = findViewById(R.id.btnMessage);
        email = findViewById(R.id.btnEmail);
        share = findViewById(R.id.btnShare);

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:+911234567890"));
                startActivity(dialIntent);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent msgIntent = new Intent(Intent.ACTION_SENDTO);
                msgIntent.setData(Uri.parse("smsto:"+Uri.encode("1234567890")));
//                sms_body is key which is mandatary for sending body also its static by message provider its not from program end its depend on messaging app
                msgIntent.putExtra("sms_body","This is sms body ");
                startActivity(msgIntent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"example@gmail.com","new@gmail.com","xyz@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"This is Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"This is email message");
                startActivity(Intent.createChooser(emailIntent,"Email via"));
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"download this app from , https://www.playstore.com/store/freefire");
                startActivity(Intent.createChooser(iShare,"Share Via"));
            }
        });
    }
}