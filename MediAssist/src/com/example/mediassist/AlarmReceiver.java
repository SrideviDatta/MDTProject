//References :
//http://www.appsrox.com/android/tutorials/remindme/
//http://javapapers.com/android/android-alarm-clock-tutorial/

package com.example.mediassist;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class AlarmReceiver extends WakefulBroadcastReceiver {
	private static MediaPlayer sdrPlayer;

    @Override
    public void onReceive(final Context context, Intent intent) {
    	//context.
    	String medicine = intent.getStringExtra("medicine");
        //this will update the UI with message
     
        String msg = "Time to take "+medicine+" !";
        
      
        if(sdrPlayer == null){
        sdrPlayer = MediaPlayer.create(context, R.raw.alarm);
        

        sdrPlayer.setOnPreparedListener(new OnPreparedListener(){

            public void onPrepared(MediaPlayer arg0) {
                Log.e("ready!","ready!");
                sdrPlayer.start();

            }} );
        }
        else{
        	sdrPlayer.start();
        }
      
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification();
        notification.icon = R.drawable.ic_launcher;
        notification.tickerText = msg;
        String title = context.getString(R.string.app_name);

        Intent notificationIntent = new Intent(context, AlarmActivity.class);
        // set intent so it does not start a new activity
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent intent1 =
                PendingIntent.getActivity(context, 0, notificationIntent, 0);
        notification.setLatestEventInfo(context, title, msg, intent1);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        // Play default notification sound
        notification.defaults |= Notification.DEFAULT_SOUND;

        // Vibrate if vibrate is enabled
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notificationManager.notify(0, notification);      
        

    }
}
