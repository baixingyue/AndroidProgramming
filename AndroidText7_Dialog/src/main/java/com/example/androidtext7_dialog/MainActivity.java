package com.example.androidtext7_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //弹出登录对话框
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                final View login_view= inflater.inflate(R.layout.login_dialog,null);
                builder.setView(login_view).setTitle("Login").setPositiveButton("login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText editTextUserId = (EditText) login_view.findViewById(R.id.editTextUserId);
                        EditText editTextPassword = (EditText) login_view.findViewById(R.id.editTextPwd);
                        Log.v("text1","text");
                        String userId=editTextUserId.getText().toString();
                        String password=editTextPassword.getText().toString();
                        if (userId.equals("abc") && password.equals("123")) {
                            Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        Button btn = (Button) this.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()

                               {

                                   public void onClick(View view) {
                                       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                       builder.setMessage("这是一个普通的提示对话框").setTitle("提示对话框");//对话框标题
                                       builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                           public void onClick(DialogInterface dialog, int which) {
                                               Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();
                                           }
                                       });
                                       builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                           public void onClick(DialogInterface dialog, int which) {
                                               Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();
                                           }


                                       });
                                       builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                                           public void onClick(DialogInterface dialog, int which) {
                                               Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();
                                           }
                                       });
                                       builder.show();
                                   }
                               }

        );
    }
}