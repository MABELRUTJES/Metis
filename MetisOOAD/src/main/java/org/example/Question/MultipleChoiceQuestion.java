package org.example.Question;

public class MultipleChoiceQuestion extends Question {
    private final String[] options;

    public MultipleChoiceQuestion(String question, String[] options, String correctOption) {
        super(question, correctOption); // basis validate gebruikt dit
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }
}
