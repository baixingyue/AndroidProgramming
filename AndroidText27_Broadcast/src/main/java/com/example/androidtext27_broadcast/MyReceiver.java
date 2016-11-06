package com.example.androidtext27_broadcast;

/**
 * Created by DELL on 2016/11/6.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String strMsg=intent.getStringExtra("broadcastmsg");
        Toast.makeText(context,strMsg, Toast.LENGTH_LONG).show();
    }

}
