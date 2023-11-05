/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.hra;

/**
 *
 * @author Martin
 */
public class Kostka {
        /**
     * Vodorovná souřadnice
     */
    private int x;

    /**
     * Svislá souřadnice
     */
    private int y;

    /**
     * Vzhled kostky reprezentován jako znakCihlicky
     */
    private char znak;

    /**
     * Zda je mimo hrací plochy z pravé strany
     * 
     * @param sirka Šířka plochy
     * @return Zda je mimo hrací plochu z pravé strany
     */
    public boolean mimoKonzoliPrava(int sirka) {
        return x >= sirka - 1;
    }

    /**
     * Zda je mimo hrací plochu z levé strany
     * 
     * @return Zda je mimo hrací plochu z levé strany
     */
    public boolean mimoKonzoliLeva() {
        return x < 1;
    }

    /**
     * Zda je mimo hrací plochu z horní strany
     * 
     * @return Zda je mimo hrací plochu z horní strany
     */
    public boolean mimoKonzoliHorni() {
        return y < 1;
    }

    /**
     * Zda je mimo hrací plochy z dolní strany
     * 
     * @param vyska Výška plochy
     * @return Zda je mimo hrací plochu z dolní strany
     */
    public boolean mimoKonzoliDolni(int vyska) {
        return y >= vyska - 1;
    }

    /**
     * Vrátí souřadnici X
     * 
     * @return Vrátí souřadnici X
     */
    public int getX() {
        return x;
    }

    /**
     * Vrátí souřadnici Y
     * 
     * @return Vrátí souřadnici Y
     */
    public int getY() {
        return y;
    }

    /**
     * Nastaví souřadnici X
     * 
     * @param x Nastaví souřadnici X
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Nastaví souřadnici Y
     * 
     * @param y Nastaví souřadnici Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Konstruktor dílku
     *
     * @param x    Vodorovná souřadnice
     * @param y    Svislá souřadnice
     * @param znak Znak
     */
    public Kostka(int x, int y, char znak) {
        this.x = x;
        this.y = y;
        this.znak = znak;
    }

    /**
     * Vratí znak kostky
     *
     * @return Znak
     */
    public char getZnak() {
        return znak;
    }

    /**
     * Zjistí, zda kostka koliduje s jinou kostkou v herním poli
     *
     * @param kostka Jiná kostka
     * @return Zda tato kostka koliduje s jinou kostkou
     */
    public boolean kolize(Kostka kostka) {
        return (x == kostka.x && y == kostka.y);
    }

    /**
     * Zda kostka koliduje na horizontální ose s jinou kostkou v herním poli
     * 
     * @param kostka Druhá kostka/dílek
     * @return Zda koliduje
     */
    public boolean kolizeHoriznotalni(Kostka kostka) {
        return (x == kostka.x - 1 && y == kostka.y) || (x == kostka.x + 1 && y == kostka.y);
    }

    /**
     * Zda kostka koliduje na vertikální ose s jinou kostkou v herním poli
     * 
     * @param kostka Druhá kostka/dílek
     * @return Zda koliduje
     */
    public boolean kolizeVertikalni(Kostka kostka) {
        return (x == kostka.x && y == kostka.y - 1) || (x == kostka.x && y == kostka.y + 1);
    }

    /**
     * Zda kostka koliduje na diagonále s jinou kostkou v herním poli
     * 
     * @param kostka Druhá kostka/dílek
     * @param smerX  Směr na ose X
     * @param smerY  Směr na ose Y
     * @return
     */
    public boolean kolizeDiagonalne(Kostka kostka, int smerX, int smerY) {
        return (x == kostka.x + smerX && y == kostka.y + smerY);
    }
}
