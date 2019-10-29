package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    private TextView textScore;
    private Button buttonRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        wireWidegets();
        setListeners();

        Intent lastIntent = getIntent();

        int score = lastIntent.getIntExtra(MainActivity.SCORE,0);

        textScore.setText(getString(R.string.Congratulation) + score);
    }

    private void setListeners() {
        buttonRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(Score.this, MainActivity.class);
                startActivity(Intent);
                finish();
            }
        });
    }


    private void wireWidegets() {
        textScore = findViewById(R.id.textview_score);
        buttonRetry = findViewById(R.id.button_retry);
    }


}
