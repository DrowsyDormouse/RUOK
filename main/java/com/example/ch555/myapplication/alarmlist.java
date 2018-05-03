package com.example.ch555.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class alarmlist extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmlist);

        Button e = findViewById(R.id.button8);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alarmlist.this, Medicinealarm.class);
                startActivity(intent);
            }
        });

        Button f = findViewById(R.id.button12);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alarmlist.this, reliefarea.class);
                startActivity(intent);
            }
        });

        Button g = findViewById(R.id.button6);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(alarmlist.this, timealarm2.class);
                startActivity(intent);
            }
        });
    }
}
