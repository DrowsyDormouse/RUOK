package com.example.ch555.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class timealarm2 extends AppCompatActivity {
    private final String[] sTime = {"1","2","3","4","5","6","7","8","9","10","11","12"};

    Spinner spinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timealarm2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, sTime);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        final String[] data = getResources().getStringArray(R.array.times);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner2);
        spinner1.setAdapter(adapter1);

        Button confrin = (Button)findViewById(R.id.confirn);
        confrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(timealarm2.this, alarmlist.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });
    }

}
