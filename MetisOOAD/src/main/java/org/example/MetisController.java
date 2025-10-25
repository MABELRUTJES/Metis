package org.example;

import org.example.Kennistoets.Kennistoets;
import org.example.Lokaal.Lokaal;
import org.example.Question.MultipleChoiceQuestion;
import org.example.Question.OpenQuestion;
import org.example.Student.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MetisController {
    private static final MetisController INSTANCE = new MetisController();
    public static MetisController getInstance() {
        return INSTANCE; // ← nooit null
    }

    // roomId naar Lokaal
    private final Map<String, Lokaal> lokalen = new HashMap<>();

    private Lokaal getOfMaakLokaal(String roomId) {
        return lokalen.computeIfAbsent(roomId, Lokaal::new);
    }

    public void startTest(String code, String title, String roomId) {
        Kennistoets kt = new Kennistoets(code, title);
        Lokaal lokaal = getOfMaakLokaal(roomId);
        lokaal.setKennistoets(kt);
        kt.startTest();
        System.out.println("Toets \"" + title + "\" (code: " + code + ") ligt in " + roomId);
    }

    public void joinTest(String studentname, String roomEgbc) {
        var lokaal = lokalen.get(roomEgbc);
        Student student = new Student(studentname);
        lokaal.setStudenten(student);
    }

    public boolean nextQuestion(String studentname, String roomEgbc) {
        var lokaal = lokalen.get(roomEgbc);
        var kennistoets = lokaal.getKennistoets();
        var question = kennistoets.nextQuestion();
        if(question == null) {
            return false;
        }
        if(question instanceof OpenQuestion){
            System.out.println("Question: " + question.getText());
        } else if(question instanceof MultipleChoiceQuestion){
            System.out.println("Question: " + question.getText());
            System.out.println("Answers: " + Arrays.toString(((MultipleChoiceQuestion) question).getOptions()));
        }
        return true;
    }

    public void saveAnswer(String studentname, String roomEgbc, String answer) {
        var lokaal = lokalen.get(roomEgbc);
        var kennistoets = lokaal.getKennistoets();
        kennistoets.setAnswer(answer);
    }

    public boolean testFinished(String studentname, String roomEgbc) {
        var lokaal = lokalen.get(roomEgbc);
        var kennistoets = lokaal.getKennistoets();
        return kennistoets.isFinished();
    }

    public int calculateScore(String studentname, String roomEgbc) {
        var lokaal = lokalen.get(roomEgbc);
        var kennistoets = lokaal.getKennistoets();
        return kennistoets.calculateScore();
    }
}
