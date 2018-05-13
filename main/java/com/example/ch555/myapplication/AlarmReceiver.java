package com.example.ch555.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver{
    public void onReceive(Context context, Intent intent) {

        MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.start();
        Log.d("MyAlarmBelal","Alarm just Fired");

        AudioManager mAudioManager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);

    }

}
