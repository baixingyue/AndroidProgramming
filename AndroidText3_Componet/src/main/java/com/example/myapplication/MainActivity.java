package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText show;
    Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (EditText) findViewById(R.id.editText);
        bn = (Button) findViewById(R.id.button);
        // 直接使用Activity作为事件监听器
        bn.setOnClickListener(new View.OnClickListener()		{
            // 实现事件处理方法
            @Override
            public void onClick(View v)			{
                show.setText("测试按钮被单击了！");
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        TextView textView = (TextView) findViewById(R.id.textView3);

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButtonMale:
                if (checked)
                {    textView.setText("您的性别为男");}


                break;
            case R.id.radioButtonFemale:
                if (checked)
                {   textView.setText("您的性别为女");}
                break;
        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        TextView textView=(TextView)findViewById(R.id.textView4);

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox:
                if(checked){
                    textView.setText("您的专业是计算机科学与技术");
                    Toast.makeText(this,"您的专业是计算机科学与技术",Toast.LENGTH_LONG).show();
                }else{
                    textView.setText("您取消了选择专业是计算机科学与技术");
                    Toast.makeText(this,"您取消了选择专业是计算机科学与技术",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.checkBox2:
                if(checked){
                    textView.setText("您的专业是软件工程");
                    Toast.makeText(this,"您的专业是软件工程",Toast.LENGTH_LONG).show();
                }else{
                    textView.setText("您取消了选择专业是软件工程");
                    Toast.makeText(this,"您取消了选择专业是软件工程",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.checkBox3:
                if(checked){
                    textView.setText("您的专业是网络工程");
                    Toast.makeText(this,"您的专业是网络工程",Toast.LENGTH_LONG).show();
                }else{
                    textView.setText("您取消了选择专业是网络工程");
                    Toast.makeText(this,"您取消了选择专业是网络工程",Toast.LENGTH_LONG).show();
                }

        }
    }

}
