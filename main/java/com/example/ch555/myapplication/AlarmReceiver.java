package com.example.ch555.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver{

    public void onReceive(Context context, Intent intent) {

        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.start();
        Log.d("MyAlarmBelal","Alarm just Fired");

        Toast.makeText(context,"약 복용 시간입니다.",Toast.LENGTH_SHORT).show();

        Intent intent1 = new Intent(context, TestPageWrite.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent1);

    }


    public void stop(Context context){
        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.stop();
        Log.d("MyAlarmBelal","Alarm just Fired");
    }



}
