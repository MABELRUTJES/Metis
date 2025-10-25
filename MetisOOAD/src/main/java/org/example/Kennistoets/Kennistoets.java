package org.example.Kennistoets;

import org.example.Puntentelling.PuntentellingStandaard;
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
    private HashMap<Question, String> givenAnswers = new HashMap<>();
    private final PuntentellingStrategie puntentellingStrategie;
    private Question currentQuestion;
    private final String code;
    private final String title;
    private final List<Question> questions = new ArrayList<>();

    public Kennistoets(String code, String title) {
        this.code = code;
        this.title = title;
        puntentellingStrategie = new PuntentellingStandaard();
    }

    public int calculateScore(){
        stopTimer();
        int amountOfRightAnswers = amountOfRightAnswers();
        int score = puntentellingStrategie.calculateScore(totalTime, amountOfRightAnswers);
        this.score = score;
        return score;
    }

    public void startTest(){
        questions.clear();
        questions.addAll(MockKennistoets.loadDefaultQuiz(title));
    }

    public Question nextQuestion(){
        int currentIndex = questions.indexOf(currentQuestion);
        if(currentIndex == 0){
            startTimer();
        }
        var nextQuestion = questions.get(currentIndex + 1);
        currentQuestion = nextQuestion;
        return nextQuestion;
    }

    public boolean isFinished(){
        return currentQuestion == questions.get(questions.size() - 1);
    }

    public void setAnswer(String answer){
        givenAnswers.put(currentQuestion, answer);
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

    private void startTimer(){
        startTime = System.currentTimeMillis();
    }

    private void stopTimer(){
        totalTime = System.currentTimeMillis() - startTime;
    }
}
