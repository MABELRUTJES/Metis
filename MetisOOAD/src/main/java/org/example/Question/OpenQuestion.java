package org.example.Question;

import java.util.Arrays;

public class OpenQuestion extends Question {
    String[] rightAnswers;

    @Override
    boolean validate(String givenAnswer) {
        return rightAnswers;
    }
}
