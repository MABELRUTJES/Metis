package org.example.Puntentelling;

public class PuntentellingStandaard implements PuntentellingStrategie {
    @Override
    public int calculateScore(long totalTime, int rightAsnwers) {
        return (int) (totalTime / rightAsnwers);
    }
}
