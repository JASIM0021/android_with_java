package com.jasim0021.notificationexample;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static  final  String CHANEL_ID="Channel ID Here";
    private static  final  int NOTIFICATION_ID=100;
    private static  final  int REQUEST_CODE=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.lg,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();
        Notification notification;
        Intent notiFicationIntend = new Intent(this, MainActivity.class);
//        clear the previus same screen if user alrady present in the app
        notiFicationIntend.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,REQUEST_CODE,notiFicationIntend,PendingIntent.FLAG_IMMUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentText("New Message")
                    .setSubText("New Message from jasim")
                     .setContentIntent(pendingIntent)
                    .setChannelId(CHANEL_ID)
                    .build();
             nm.createNotificationChannel(new NotificationChannel(CHANEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
        }else{
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText("New Message")
                    .setContentIntent(pendingIntent)
                    .setSubText("New Message from jasim")

                    .build();
        }

//        nm.notify(NOTIFICATION_ID,notification);  ---> direct implimentation for test don`t do like this  but when you need to listen from backend then do this from an bgservice

//        notifying with click event

        Button notify = findViewById(R.id.btnNotify);

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nm.notify(NOTIFICATION_ID,notification);

            }
        });


    }
}