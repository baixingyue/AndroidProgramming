package com.example.androidtext28_mediaplayer;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myTag";
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        mediaPlayer = new MediaPlayer();

        /*如果需要播放完停止，则需要注册OnCompletionListener监听器
        在本示例中，用户可以选择是否循环播放，如果选择了循环播放，则播放完后会自动转到Started状态，再次播放
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.v(TAG,"setOnCompletionListener");
                mp.release();
            }
        });*/


        final TextView txtLoopState = (TextView) findViewById(R.id.txtLoopState);

        final Button buttonStart = (Button) findViewById(R.id.buttonStart);
        final Button buttonPause = (Button) findViewById(R.id.buttonPause);
        final Button buttonStop = (Button) findViewById(R.id.buttonStop);
        final Button buttonLoop = (Button) findViewById(R.id.buttonLoop);

        buttonPause.setEnabled(false);
        buttonStop.setEnabled(false);
        buttonLoop.setEnabled(false);

        //开始播放
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Log.v(TAG, "start");
                    mediaPlayer.reset();
                    txtLoopState.setText("开始播放");
                    AssetManager assetManager = getAssets();
                    AssetFileDescriptor assetFileDescriptor = assetManager.openFd("Carly Rae Jepsen - I Really Like You.mp3");
                    mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                    buttonPause.setEnabled(true);
                    buttonStop.setEnabled(true);
                    buttonLoop.setEnabled(true);

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        //暂停播放
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    buttonPause.setText("Play");
                    mediaPlayer.pause();
                    txtLoopState.setText("暂停播放");
                } else {
                    buttonPause.setText("Pause");
                    mediaPlayer.start();
                    txtLoopState.setText("继续播放");
                }

            }
        });

        //停止播放
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                txtLoopState.setText("停止播放");

            }
        });

        //循环播放
        buttonLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Looping");

                boolean loop = mediaPlayer.isLooping();
                mediaPlayer.setLooping(!loop);


                if (!loop)
                    txtLoopState.setText("循环播放");
                else
                    txtLoopState.setText("一次播放");


            }
        });
    }

}
