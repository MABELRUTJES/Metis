package org.example.Kennistoets;

import org.example.Puntentelling.PuntentellingStrategie;
import org.example.Question.Question;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Kennistoets {
    private int totalTime;
    private int score;
    private Map<Question, String> givenAnswers;
    private PuntentellingStrategie puntentellingStrategie;

    public int calculateScore(){
        int amountOfRightAnswers = amountOfRightAnswers();
        return puntentellingStrategie.calculateScore(totalTime, amountOfRightAnswers);
    }

    public void startTest(){

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
}
