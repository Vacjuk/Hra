/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.hra;

/**
 *
 * @author Martin
 */
public class Micek {
        private Kostka kostka;

    /**
     * Směr míčku X 1 (Pravá), -1 (Levá)
     */
    private int smerX;

    /**
     * Směr míčku Y 1 (Nahoru), -1 (Dolů)
     */
    private int smerY;

    /**
     * Znak, který bude reprezentovat míček
     */
    private char znakMicku = 'O';

    /**
     * Inicializuje instanci
     * 
     * @param sirkaPlochy Šířka plochy
     * @param vyskaPlochy Výška plochy
     */
    public Micek(int sirkaPlochy, int vyskaPlochy) {
        smerX = 1;
        smerY = 1;

        kostka = new Kostka(sirkaPlochy / 2, vyskaPlochy - 1, znakMicku);
    }

    /**
     * Vrátí směr souřadnice X
     * 
     * @return Souřadnice X
     */
    public int vratSmerX() {
        return smerX;
    }

    /**
     * Vrátí směr souřadnice Y
     * 
     * @return Souřadnice Y
     */
    public int vratSmerY() {
        return smerY;
    }

    /**
     * Nastaví směr po ose X
     * 
     * @param smerX Směr po ose X (1: doprava, -1: doleva)
     */
    public void nastavSmerX(int smerX) {
        this.smerX = smerX;
    }

    /**
     * Nastaví směr po ose Y
     * 
     * @param smerY Směr po ose Y (1: nahoru, -1: dolů)
     */
    public void nastavSmerY(int smerY) {
        this.smerY = smerY;
    }

    /**
     * Posune míček podle směru
     */
    public void posunSe() {
        // Posunutí míčku podle směru
        if (smerX == 1)
            kostka.setX(kostka.getX() + 1);
        if (smerX == -1)
            kostka.setX(kostka.getX() - 1);
        if (smerY == 1)
            kostka.setY(kostka.getY() - 1);
        if (smerY == -1)
            kostka.setY(kostka.getY() + 1);
    }

    /**
     * Vrátí instanci kostky
     * 
     * @return Instance kostky
     */
    public Kostka vratKostku() {
        return kostka;
    }
}
