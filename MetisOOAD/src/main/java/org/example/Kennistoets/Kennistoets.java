package org.example.Kennistoets;

import org.example.Puntentelling.PuntentellingStrategie;
import org.example.Question.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Kennistoets {
    private long startTime;
    private long totalTime;
    private int score;
    private HashMap<Question, String> givenAnswers;
    private PuntentellingStrategie puntentellingStrategie;
    private Question currentQuestion;

    private final String code;
    private final String title;
    private final List<Question> questions = new ArrayList<>();

    public Kennistoets(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public int calculateScore(){
        stopTimer();
        int amountOfRightAnswers = amountOfRightAnswers();
        return puntentellingStrategie.calculateScore(totalTime, amountOfRightAnswers);
    }


    public void startTest(){
        questions.clear();
        questions.addAll(MockKennistoets.loadDefaultQuiz(title));
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

    private void stopTimer(){
        totalTime = System.currentTimeMillis() - startTime;
    }
}
