package org.example;

import org.example.Kennistoets.Kennistoets;
import org.example.Lokaal.Lokaal;

import java.util.HashMap;
import java.util.Map;

public class MetisController {
    private Kennistoets kennistoets;
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
        kt.startTest();
        Lokaal lokaal = getOfMaakLokaal(roomId);
        lokaal.setKennistoets(kt);
        System.out.println("Toets \"" + title + "\" (code: " + code + ") ligt in " + roomId);
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
