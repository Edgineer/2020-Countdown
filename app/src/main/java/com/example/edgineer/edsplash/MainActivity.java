package com.example.edgineer.edsplash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Day, Hour, Minute, Second;
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Day = (TextView) findViewById(R.id.txtTimerDay);
        Hour = (TextView) findViewById(R.id.txtTimerHour);
        Minute = (TextView) findViewById(R.id.txtTimerMinute);
        Second = (TextView) findViewById(R.id.txtTimerSecond);
        countDownStart();
    }
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
// Please here set your event date//YYYY-MM-DD
                    Date futureDate = dateFormat.parse("2020-11-3");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        Day.setText("" + String.format("%02d", days));
                        Hour.setText("" + String.format("%02d", hours));
                        Minute.setText(""
                                + String.format("%02d", minutes));
                        Second.setText(""
                                + String.format("%02d", seconds));
                    } else {
                        textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }
    public void textViewGone() {
        findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
    }
}