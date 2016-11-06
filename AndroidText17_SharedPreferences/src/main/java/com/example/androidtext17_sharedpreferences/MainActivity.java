package com.example.androidtext17_sharedpreferences;

import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private final static  String SharedPreferences="config";
    private final static String MyFileName="myfile";
    //
    private final static  String Key_UserId="UserId";
    private final static  String Key_UserName="UserName";
    android.content.SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences(SharedPreferences,MODE_PRIVATE);
        editor=preferences.edit();
        Button btnWrite=(Button)findViewById(R.id.button);
        Button btnRead=(Button)findViewById(R.id.button2);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                OutputStream out=null;
                try{
                    FileOutputStream fileOutputStream=openFileOutput(MyFileName,MODE_PRIVATE);
                    out=new BufferedOutputStream(fileOutputStream);
                    String UserId="2014011417";
                    String UserName="Baixingyue";
                    try{
                        out.write(UserId.getBytes(StandardCharsets.UTF_8));
                        out.write(UserId.getBytes(StandardCharsets.UTF_8));
                    }
                    finally {
                        if(out!=null)
                            out.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                //写入键值对
                editor.putString(Key_UserId,"2014011417");
                editor.putString(Key_UserName, "baixingyue");


                //提交修改，此处换成commit()也可以
                editor.apply();

            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = preferences.getString(Key_UserName, null);
                String strUserId = preferences.getString(Key_UserId, null);
                InputStream in=null;
                try{
                    FileInputStream fileInputStream=openFileInput(MyFileName);
                    in=new BufferedInputStream(fileInputStream);
                    int c;
                    StringBuilder stringBuilder=new StringBuilder("");
                    try{
                        while((c=in.read())!=-1){
                            stringBuilder.append((char)c);
                        }
                        Toast.makeText(MainActivity.this,stringBuilder.toString(),Toast.LENGTH_SHORT).show();
                    }
                    finally {
                        if(in!=null)
                            in.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                if (strUserName != null && Key_UserId != null)
                    Toast.makeText(MainActivity.this, "学号:" + strUserId + "姓名：" + strUserName, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });

    }
}

