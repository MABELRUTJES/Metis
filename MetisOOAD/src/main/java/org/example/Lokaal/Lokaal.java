package org.example.Lokaal;

import org.example.Kennistoets.Kennistoets;

public class Lokaal {
    public static final int CAPACITEIT = 50;
    private final String roomId;
    private Kennistoets kennistoets;

    public Lokaal(String roomId) { this.roomId = roomId; }

    public String getRoomId() { return roomId; }
    public Kennistoets getKennistoets() { return kennistoets; }
    public void setKennistoets(Kennistoets kt) { this.kennistoets = kt; }
    public boolean heeftKennistoets() { return kennistoets != null; }
}
