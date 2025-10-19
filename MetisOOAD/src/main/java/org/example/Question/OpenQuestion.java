package org.example.Question;

import java.util.Arrays;

public class OpenQuestion extends Question {
    private final String[] rightAnswers;

    public OpenQuestion(String question, String[] rightAnswers) {
        super(question, null);
        this.rightAnswers = rightAnswers;
    }

    @Override
    public boolean validate(String givenAnswer) {
        return givenAnswer != null && Arrays.asList(rightAnswers).contains(givenAnswer);
    }
}
