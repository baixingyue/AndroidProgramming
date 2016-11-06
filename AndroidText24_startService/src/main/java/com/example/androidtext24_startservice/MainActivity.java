package com.example.androidtext24_startservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart=(Button)findViewById(R.id.button);
        Button btnEnd=(Button)findViewById(R.id.button2);
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(MainActivity.this,MyService.class);
                intent.putExtra("num",10);
                startService(intent);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });
    }
}

