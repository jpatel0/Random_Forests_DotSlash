package com.randomforests.saaransh.activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.randomforests.saaransh.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Recoard extends AppCompatActivity {

    public TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoard);
        time=(TextView)findViewById(R.id.texttime);
        new CountDownTimer(600000, 1000) {

            public void onTick(long millisUntilFinished) {
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
                Date currentLocalTime = cal.getTime();
                DateFormat date = new SimpleDateFormat("HH:mm:ss");
                // you can get seconds by adding  "...:ss" to it
                date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));

                String localTime = date.format(currentLocalTime);


                /*String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                Log.d(TAG, "onCreate: " + currentDateTimeString);*/
                time.setText(localTime); // This is your code
            }

            public void onFinish() {
                time.setText("done!");
            }
        }.start();


    }
}
