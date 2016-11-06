package com.example.androidtext24_startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="ServiceTag!";
    public MyService() {
    }
    @Override
    public void onCreate(){
        Log.v(TAG,"onCreate()");
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.v(TAG,"onStartCommand()");
        int n=intent.getIntExtra("num",0);
        Log.v(TAG,"INT IS:"+n);
        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy(){
        Log.v(TAG,"onDestroy()");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}