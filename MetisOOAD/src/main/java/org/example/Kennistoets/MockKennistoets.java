package org.example.Kennistoets;

import org.example.Question.MultipleChoiceQuestion;
import org.example.Question.OpenQuestion;
import org.example.Question.Question;

import java.util.ArrayList;
import java.util.List;


final class MockKennistoets {

    private MockKennistoets() {}

    static List<Question> loadDefaultQuiz(String title) {
        String p = (title == null || title.isBlank()) ? "" : "[" + title + "] ";

        List<Question> qs = new ArrayList<>(5);

        // 1) MC
        qs.add(new MultipleChoiceQuestion(
                p + "Wat is 2 + 2?",
                new String[]{"3", "4", "5", "22"},
                "4"
        ));
        // 2) MC
        qs.add(new MultipleChoiceQuestion(
                p + "Welke hoort NIET bij niet-functionele eisen?",
                new String[]{"Performance", "Security", "Use-case", "Availability"},
                "Use-case"
        ));
        // 3) MC (Juist/Onjuist als MC)
        qs.add(new MultipleChoiceQuestion(
                p + "UML staat voor Unified Modeling Language.",
                new String[]{"Juist", "Onjuist"},
                "Juist"
        ));
        // 4) Open
        qs.add(new OpenQuestion(
                p + "Noem één niet-functionele eis.",
                new String[]{"performance", "beveiliging", "security", "availability", "betrouwbaarheid"}
        ));
        // 5) Open
        qs.add(new OpenQuestion(
                p + "Wat betekent 'requirements' in software (1 woord is voldoende)?",
                new String[]{"eisen", "requirements", "specificaties", "behoeften"}
        ));

        return qs;
    }
}
