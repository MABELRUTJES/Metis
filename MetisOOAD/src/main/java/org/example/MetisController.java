package org.example;

import org.example.Kennistoets.Kennistoets;

public class MetisController {
    private Kennistoets kennistoets;
    public static MetisController getInstance() {
        return null;
    }

    public void startTest(String egbc, String toetsRequirements, String roomEgbc) {
        kennistoets.startTest();
    }

    public void joinTest(String studentname, String roomEgbc) {
    }

    public boolean nextQuestion(String studentname, String roomEgbc) {
        return false;
    }

    public void saveAnswer(String studentname, String roomEgbc, String answer) {
        kennistoets.setAnswer(answer);
    }

    public boolean testFinished(String studentname, String roomEgbc) {
        return false;
    }

    public int calculateScore(String studentname, String roomEgbc) {
        return kennistoets.calculateScore();
    }
}
