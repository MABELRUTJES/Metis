package org.example;

import org.example.Puntentelling.PuntentellingStrategie;
import org.example.Question.Question;

import java.util.Map;

public class MetisController {
    private int totalTime;
    private int score;
    private Map<Question, String> givenAnswers;
    private PuntentellingStrategie puntentellingStrategie;
    public static MetisController getInstance() {
        return null;
    }

    public void startTest(String egbc, String toetsRequirements, String roomEgbc) {
    }

    public void joinTest(String studentname, String roomEgbc) {
    }

    public boolean nextQuestion(String studentname, String roomEgbc) {
        return false;
    }

    public void saveAnswer(String studentname, String roomEgbc, String answer) {
    }

    public boolean testFinished(String studentname, String roomEgbc) {
        return false;
    }

    public int calculateScore(String studentname, String roomEgbc) {
        int rightAnswers = amountOfRightAnswers();
        return puntentellingStrategie.calculateScore(totalTime, rightAnswers);
    }

    private int amountOfRightAnswers() {
        // Question.validate(string givenAnswer)
        return 0;
    }
}
