package com.example.abcc.prism;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by MayuriAnkit on 18-09-2017.
 */

public class SampleBootReceiver extends BroadcastReceiver {

@Override
 public void onReceive(Context context, Intent intent) {
 if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
// Set the alarm here.

     Intent notificationIntent = new Intent(context.getApplicationContext(), NotificationPublisher.class);

     notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
     Intent notifIntent= new Intent(context.getApplicationContext(), LoginActivity.class);

     PendingIntent pNotifIntent = PendingIntent.getActivity(context.getApplicationContext(),0,notifIntent,PendingIntent.FLAG_UPDATE_CURRENT);

     Notification.Builder builder = new Notification.Builder(context.getApplicationContext());

     builder.setContentTitle("Prism Notification");

     builder.setContentText("Please fill your prism after reboot");
     builder.setContentIntent(pNotifIntent);
     builder.setSmallIcon(R.drawable.allstatelogo);

     notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, builder.build());

     PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

     // Setting the Calendar for Notification to be generated every Thursday
     Calendar calendar = Calendar.getInstance();
     calendar.setTimeInMillis(System.currentTimeMillis());

     //calendar.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
     //calendar.set(Calendar.HOUR_OF_DAY, 9);


     LoginActivity.alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

     LoginActivity.alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),60*1000,pendingIntent);
}
}

}