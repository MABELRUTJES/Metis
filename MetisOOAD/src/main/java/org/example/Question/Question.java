package org.example.Question;

public abstract class Question {
    private final String question;
    private final String rightAnswer;

    protected Question(String question, String rightAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
    }

    public String getText() {
        return question;
    }

    public boolean validate(String givenAnswer) {
        return rightAnswer != null && rightAnswer.equals(givenAnswer);
    }
}
