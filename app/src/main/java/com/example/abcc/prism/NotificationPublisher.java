package com.example.abcc.prism;

/**
 * Created by MayuriAnkit on 16-09-2017.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class NotificationPublisher extends BroadcastReceiver {



    public static String NOTIFICATION_ID = "notification-id";

    public static String NOTIFICATION = "notification";



    public void onReceive(Context context, Intent intent) {



        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);



        Notification notification = intent.getParcelableExtra(NOTIFICATION);
        int dfgh=8;
        int id = intent.getIntExtra(NOTIFICATION_ID, 0);
        if(LoginActivity.NotificationFlag==0)
            notificationManager.notify(id, notification);
        int ty=7;




    }

}
