package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText minutes;
    TextView timerText;
    Button startButton;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minutes = findViewById(R.id.minutes);
        timerText = findViewById(R.id.timer_text);
        startButton = findViewById(R.id.timer_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long millisInFuture = 1000 * 60 * Integer.valueOf(minutes.getText().toString());

                if (timer != null){
                    timer.cancel();
                }

                timer = new CountDownTimer(millisInFuture, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long minutes = millisUntilFinished / 1000 / 60;
                        long seconds = (millisUntilFinished / 1000) % 60;
                        timerText.setText(minutes + ":" + seconds);
                    }

                    @Override
                    public void onFinish() {
                        timerText.setText("Take a break! :)");
                    }
                };
                timer.start();
            }
        });
    }
}