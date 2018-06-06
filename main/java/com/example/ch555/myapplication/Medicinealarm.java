package com.example.ch555.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.util.Calendar;

public class Medicinealarm extends AppCompatActivity{

    TimePicker timePicker;
    public static final String ALARM_ALERT_ACTION = "com.example.ch555.myapplication.ALARM_ALERT";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicinealarm);

        timePicker = (TimePicker)findViewById(R.id.time);

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Calendar calendar = Calendar.getInstance();
                if(Build.VERSION.SDK_INT>=23){
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
                    , timePicker.getHour(),timePicker.getMinute(),0);
                }else {
                    calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),
                            timePicker.getCurrentHour(),timePicker.getMinute(),0);
                }

                setAlarm(calendar.getTimeInMillis());
            }
        });



    }

    private void setAlarm(long time){
        AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(this, AlarmReceiver.class);

        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);

        am.setRepeating(AlarmManager.RTC_WAKEUP,time,AlarmManager.INTERVAL_DAY,pi);//반복알람
        Toast.makeText(this, "알람이 설정 되었습니다.", Toast.LENGTH_SHORT).show();
    }



}
