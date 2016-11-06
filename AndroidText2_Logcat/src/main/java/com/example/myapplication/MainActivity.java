package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="My test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //用logcat调试，当触发button监听器时，检查是否出错

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("触发了button")//显示的消息内容
                        .setTitle("提示");//对话框标题
                Log.v(TAG,"test button");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    //当按下确定按钮，logcat检查是否出错
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();
                        Log.v(TAG,"click PositiveButton");
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    //当按下取消按钮，logcat检查是否出错
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();
                        Log.v(TAG,"Click NegativeButton");
                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    //当按下忽略按钮，logcat检查是否出错
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();
                        Log.v(TAG,"Click NeutralButton");
                    }

                });
                builder.show();
            }
        });
    }
}
