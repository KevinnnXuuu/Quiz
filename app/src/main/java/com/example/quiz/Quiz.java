package com.example.quiz;

import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;


public class Quiz {
    private int currentQuestion;
    private List<Question> questions;
    int score = 0;

    public Quiz (List<Question> questionList){
        questions = questionList;
    }

    public Question getQuestions(int numberOfQ) {
        return questions.get(numberOfQ);
    }

    public boolean hasMoreQs() {
        return (currentQuestion != questions.size()-2);
    }

    public boolean checkAnswer(boolean response){
        if (response == questions.get(currentQuestion).getAnswer()){
            score++;
            return true;
        }
        else{
            return false;
        }

    }

    public Question nextQuestion() {
        currentQuestion++;
        return questions.get(currentQuestion);

    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
