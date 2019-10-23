package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonFalse;
    private Button buttonTrue;
    private TextView textQuestion;
    private Quiz volleyQuiz;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream jsonFileInputStream = getResources().openRawResource(R.raw.question);
        String question = readTextFile(jsonFileInputStream);

        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questions =  gson.fromJson(question, Question[].class);
        // convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
        // verify that it read everything properly
        Log.d(TAG, "onCreate: " + questionList.toString());

        Quiz volleyQuiz = new Quiz(questionList);
        this.volleyQuiz = volleyQuiz;
        WireWidegets();
        SetLitseners();
        textQuestion.setText(volleyQuiz.getQuestions(volleyQuiz.getCurrentQuestion()).getQuestionText());
    }

    public void SetLitseners() {
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volleyQuiz.checkAnswer(true);
                volleyQuiz.nextQuestion();
                textQuestion.setText(volleyQuiz.getQuestions(volleyQuiz.getCurrentQuestion()).getQuestionText());
            }
        });
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volleyQuiz.checkAnswer(false);
                textQuestion.setText(volleyQuiz.getQuestions(volleyQuiz.getCurrentQuestion()).getQuestionText());
            }
        });
    }

    public void WireWidegets() {
        buttonFalse = findViewById(R.id.button_main_false);
        buttonTrue = findViewById(R.id.button_main_ture);
        textQuestion = findViewById(R.id.textview_center_question);
    }

    // reading the text file from
    // https://stackoverflow.com/questions/15912825/how-to-read-file-from-res-raw-by-name
    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }


}
