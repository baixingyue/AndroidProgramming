package com.example.androidtetx16_intentfilter;

import android.Manifest;

import android.content.Intent;

import android.content.pm.PackageManager;

import android.net.Uri;

import android.os.Build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_startThird = (Button) findViewById(R.id.btn_startThird);

        btn_startThird.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW,

                        Uri.parse("schemodemo://edu.bistu/path"));

                startActivity(intent);

            }

        });
    }
}
