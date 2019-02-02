package com.randomforests.saaransh.activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.randomforests.saaransh.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Recoard extends AppCompatActivity {

    String TAG="Recoard";
    public TextView time;
    long  s =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoard);
        time=(TextView)findViewById(R.id.texttime);

        new CountDownTimer(600000, 1000) {

            public void onTick(long millisUntilFinished) {

                //long s=millisUntilFinished;
                s=s+1000;

                Log.d(TAG, "onTick: "+s);

                String hms = String.format("%02d:%02d",  TimeUnit.MILLISECONDS.toMinutes(s) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(s)), TimeUnit.MILLISECONDS.toSeconds(s) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(s)));
                time.setText(hms); // This is your code
            }

            public void onFinish() {
                time.setText("done!");
            }
        }.start();


    }
}
