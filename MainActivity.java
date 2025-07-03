package com.example.batsmansrandaveragecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText BallsSR, RunsSR, RunsAvg, Dismissals;
    Button SR, Avg;
    TextView SR_display, Avg_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BallsSR = findViewById(R.id.Balls_SR);
        RunsSR = findViewById(R.id.Runs_SR);
        RunsAvg = findViewById(R.id.RunsAvgEdit);
        Dismissals = findViewById(R.id.OutCount);
        SR = findViewById(R.id.SR_Button);
        Avg = findViewById(R.id.AvgButton);
        SR_display = findViewById(R.id.SR_Shown);
        Avg_display = findViewById(R.id.Avg_Shown);

        SR.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int balls = Integer.parseInt(BallsSR.getText().toString());
                int runs = Integer.parseInt(RunsSR.getText().toString());
                if (BallsSR.getText().toString().isEmpty() || RunsSR.getText().toString().isEmpty()) {
                    SR_display.setText("Please enter both runs and balls.");
                    return;
                }

                double strikeRate = ((double) runs / balls) * 100;
                @SuppressLint("DefaultLocale") String SRResult = String.format("%.2f", strikeRate);
                SR_display.setText("Strike rate of batsman is " + SRResult);
            }

        });
        Avg.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                int avg = Integer.parseInt(RunsAvg.getText().toString());
                int out = Integer.parseInt(Dismissals.getText().toString());
                if (RunsAvg.getText().toString().isEmpty() || Dismissals.getText().toString().isEmpty()) {
                    SR_display.setText("Please enter both runs and dismissals.");
                    return;
                }
                double average = (double) avg / out;
                @SuppressLint("DefaultLocale") String AvgResult = String.format("%.2f", average);
                Avg_display.setText("Average of batsman is " + AvgResult);
            }
        });

    }
}
