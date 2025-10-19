package org.example.Kennistoets;

import org.example.Puntentelling.PuntentellingStrategie;
import org.example.Question.Question;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Kennistoets {
    private long startTime;
    private long totalTime;
    private int score;
    private HashMap<Question, String> givenAnswers;
    private PuntentellingStrategie puntentellingStrategie;
    private Question currentQuestion;

    public int calculateScore(){
        stopTimer();
        int amountOfRightAnswers = amountOfRightAnswers();
        return puntentellingStrategie.calculateScore(totalTime, amountOfRightAnswers);
    }

    public void startTest(){
        startTimer();
        //start test
        //set first question as current question
    }

    public void setAnswer(String answer){
        givenAnswers.put(currentQuestion, answer);
    }

    private void startTimer(){
        startTime = System.currentTimeMillis();
    }

    private int amountOfRightAnswers() {
        AtomicInteger amountOfRightAnswers = new AtomicInteger();
        givenAnswers.forEach(
                (question, answer) -> {
                    if (question.validate(answer)){
                        amountOfRightAnswers.getAndIncrement();
                    };
                }
        );
        return amountOfRightAnswers.get();
    }

    private int stopTimer(){
        totalTime = System.currentTimeMillis() - startTime;
    }
}
