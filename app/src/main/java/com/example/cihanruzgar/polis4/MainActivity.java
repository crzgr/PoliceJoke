package com.example.cihanruzgar.polis4;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RelativeLayout iv;



    int red = 1, green = 1, blue = 1;
    int i = 0;
    int a = 0;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 22) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_main);

        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.

        final MediaPlayer voice = MediaPlayer.create(getApplicationContext(),R.raw.polissiren);


        start = (Button) findViewById(R.id.button);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice.start();
                voice.setLooping(true);
                start.setVisibility(View.INVISIBLE);
                iv = (RelativeLayout) findViewById(R.id.back);
                // m.postScale(2f, 2f);
                Timer t = new Timer();
                t.scheduleAtFixedRate(new TimerTask() {

                    public void run() {

                        runOnUiThread(new Runnable() {

                            public void run() {
                                a = 255;

                                i++;

                                if (i == 1) {

                                    red = 7;
                                    green = 10;
                                    blue = 189;
                                }
                                if (i == 2) {

                                    red = 181;
                                    green = 40;
                                    blue = 40;

                                }

                                if (i == 3) {
                                    i = 0;
                                }

                                iv.setBackgroundColor(Color.argb(a, red, green, blue));



                            }

                        });
                    }
                }, 0, 120);
            }


        });



    }
}