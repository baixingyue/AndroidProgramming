package com.example.androidtext15_intentcallphone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
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
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("startAnotherActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("http://www.mathtop.com.cn/homework"));
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:13911561915"));
                startActivity(intent);
            }
        });
    }
}
