package com.example.ch555.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class memolist extends AppCompatActivity {
    ListView listView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memolist);

        listView = (ListView)findViewById(R.id.mylistview);

        dataSetting();


        Button e = findViewById(R.id.button11);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(memolist.this, memo.class);
                startActivity(intent);
            }
        });
    }

    private void dataSetting(){

        MyAdapter myAdapter = new MyAdapter();

        for (int i=0;i<10;i++){
            myAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pen), "name_" + i, "contents_" + i);
        }

        listView.setAdapter(myAdapter);
    }
}
