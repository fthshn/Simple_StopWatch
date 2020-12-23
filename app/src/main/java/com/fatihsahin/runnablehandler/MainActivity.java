package com.fatihsahin.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.LogRecord;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        number=0;
    }

    public void start(View view)
    {
       handler = new Handler();

       runnable = new Runnable() {
           @Override
           public void run() {

               textView.setText("Time: " + number);
               number++;
               textView.setText("Time: " + number);
               handler.postDelayed(runnable,1000);
               button.setEnabled(false);

           }
       };

       handler.post(runnable);

    }

    public void stop(View view)
    {
        button.setEnabled(true);

        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("Time: " + number);
    }

    public void pause(View view)
    {
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        textView.setText("Time: " + number);
    }
}