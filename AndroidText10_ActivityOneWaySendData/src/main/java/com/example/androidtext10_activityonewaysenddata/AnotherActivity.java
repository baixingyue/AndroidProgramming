package com.example.androidtext10_activityonewaysenddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnotherActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Integer age = intent.getIntExtra("age", 20);
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(name + age);
        Toast.makeText(this, name + age, Toast.LENGTH_LONG).show();
    }
}
