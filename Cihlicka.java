/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.hra;

/**
 *
 * @author Martin
 */
public class Cihlicka {
       /**
     * Znač cihličky
     */
    char znakCihlicky = '#';

    /**
     * Jeden dílek pole
     */
    private Kostka kostka;

    /**
     * Konstruktor, vytvoří dílek cihličky na souřadnicích X a Y
     * 
     * @param x Souřadnice X
     * @param y Souřadnice Y
     */
    public Cihlicka(int x, int y) {
        kostka = new Kostka(x, y, znakCihlicky);
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
