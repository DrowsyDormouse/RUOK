package com.example.ch555.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText idtext = (EditText)findViewById(R.id.idtext);
        EditText pwtext = (EditText)findViewById(R.id.pwtext);
        EditText nametext = (EditText)findViewById(R.id.nametext);
        EditText phonenum = (EditText)findViewById(R.id.phonenum);

        EditText ptname = (EditText)findViewById(R.id.ptname);
        EditText agetext = (EditText)findViewById(R.id.agetext);
        EditText addtext = (EditText)findViewById(R.id.addtext);
        EditText ratingtext = (EditText)findViewById(R.id.ratingtext);

        Button SignIn = (Button) findViewById(R.id.SingIn);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, settinglist.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });
    }
}
