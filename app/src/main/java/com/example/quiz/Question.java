package com.example.quiz;

public class Question {
    private boolean answer;
    private String questionText;

    public Question(String question, boolean answer) {
        this.questionText = question;
        this.answer = answer;
    }
    public String getQuestionText() {
        return questionText;
    }
    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "answer=" + answer +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}
