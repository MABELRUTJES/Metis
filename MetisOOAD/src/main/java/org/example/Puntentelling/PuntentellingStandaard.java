package org.example.Puntentelling;

public class PuntentellingStandaard implements PuntentellingStrategie {
    @Override
    public int calculateScore(int totalTime, int rightAsnwers) {
        return totalTime / rightAsnwers;
    }
}
