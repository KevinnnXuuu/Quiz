package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    private TextView textScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        WireWidegets();

        Intent lastIntent = getIntent();

        int score = lastIntent.getIntExtra(MainActivity.SCORE,11);

        textScore.setText("Congratulation! You have finished the quiz! Your score is " + score);

    }

    private void WireWidegets() {
        textScore = findViewById(R.id.textview_score);
    }


}
