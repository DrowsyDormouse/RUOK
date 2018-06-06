package com.example.ch555.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity{

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,settinglist.class));
        finish();
    }
}
