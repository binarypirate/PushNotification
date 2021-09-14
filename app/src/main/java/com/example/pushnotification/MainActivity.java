package com.example.pushnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, intent,0);

                Notification notification = new Notification.Builder(MainActivity.this)
                        .setTicker("Notification")
                        .setContentTitle("Important message")
                        .setContentText("Hello this is my first notification type app")
                        .setSmallIcon(R.drawable.notify)
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setDefaults(Notification.DEFAULT_LIGHTS)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentIntent(pIntent)
                        .build();

                notification.flags = Notification.FLAG_AUTO_CANCEL;

                NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nManager.notify(0,notification);
            }
        });
    }
}