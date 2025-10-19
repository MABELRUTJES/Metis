package org.example.Question;

public abstract class Question {
    private String question;
    private String rightAnswer;

    public boolean validate(String givenAnswer) {
        return rightAnswer.equals(givenAnswer);
    }
}
