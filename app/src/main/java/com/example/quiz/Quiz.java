package com.example.quiz;

import java.util.List;


public class Quiz {
    private int currentQuestion;
    private List<Question> questions;
    private int score;

    public Quiz (List<Question> questionList){
        questions = questionList;
    }

    public Question getQuestions(int numberOfQ) {
        return questions.get(numberOfQ);
    }

    public boolean hasMoreQs() {
        return (currentQuestion != questions.size());
    }

    public void checkAnswer(boolean response){
        if (response == questions.get(currentQuestion).getAnswer()){
            score++;
        }

    }

    public Question nextQuestion() {
        currentQuestion =+ 1;
        return questions.get(currentQuestion);

    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }
}
