package org.example.Lokaal;

import org.example.Kennistoets.Kennistoets;
import org.example.Student.Student;

import java.util.ArrayList;
import java.util.List;

public class Lokaal {
    public static final int CAPACITEIT = 50;
    private final String roomId;
    private Kennistoets kennistoets;
    private List<Student> studenten = new ArrayList<>();

    public Lokaal(String roomId) { this.roomId = roomId; }

    public Kennistoets getKennistoets() { return kennistoets; }
    public void setKennistoets(Kennistoets kt) { this.kennistoets = kt; }
    public void setStudenten(Student s) {
        if(studenten.size() >= CAPACITEIT) {
            System.out.println("Dit lokaal is vol");
        }
        else {
            studenten.add(s);
        }
    }
}
