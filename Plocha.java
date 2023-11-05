/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.hra;
import java.util.ArrayList;
/**
 *
 * @author Martin
 */
public class Plocha {
     /**
     * Šířka hrací plochy
     */
    private int sirka;

    /**
     * Výška hrací plochy
     */
    private int vyska;

    /**
     * Hráč/Míček
     */
    private Micek micek;

    /**
     * Cihličky
     */
    private ArrayList<Cihlicka> cihlicky = new ArrayList<>();

    /**
     * Pozadí plochy
     */
    private char pozadi = ' ';

    /**
     * Inicializuje hrací plochu
     *
     * @param sirka Šířka hrací plochy
     * @param vyska Výška hrací plochy
     */
    public Plocha(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
        micek = new Micek(sirka, vyska);
        vyplnCihlicky();
    }

    /**
     * Vykreslí plochu
     */
    public void vykresli() {
        // Dokud existují cihličky, opakuj cyklus
        while (!cihlicky.isEmpty()) {
            micek.posunSe();
            kontrolaStranPlochy();
            kontrolaKolizi();

            // Začínáme u -1 abychom omylem nekolidovali s hracím polem
            for (int y = -1; y < vyska + 1; y++) {
                for (int x = -1; x < sirka + 1; x++) {
                    // Kreslení okrajů
                    if (x == -1 && y == -1) System.out.print("+"); // levý horní roh
                    else if (x == -1 && y == vyska) System.out.print("+"); // levý dolní roh
                    else if (x == sirka && y == vyska) System.out.print("+"); // pravý dolní roh
                    else if (x == sirka && y == -1) System.out.print("+"); // pravý horní roh
                    else if (x == -1 || x == sirka) System.out.print("|"); // levá a pravá hrana
                    else if (y == -1 || y == vyska) System.out.print("-"); // dolní hrana
                    else {
                        // Vykreslení hrací plochy
                        Kostka kostka = vratKostku(x, y);
                        if (kostka != null) {
                            System.out.print(kostka.getZnak());
                        } else {
                            System.out.print(pozadi);
                        }
                    }
                }
                System.out.println();
            }

            // vyčistí obrazovku
            for (int i = 0; i < 3; i++) {
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // Fail silently like a ninja!
            }
        }
        System.out.println("Game over!");
    }

    /**
     * Vyplní hrací pole cihličkami
     */
    private void vyplnCihlicky() {
        for (int i = 3; i < sirka - 3; i++) {
            for (int j = 4; j < vyska - 1; j++) {
                cihlicky.add(new Cihlicka(i, vyska - j));
            }
        }
    }

    /**
     * Vrátí objekt nacházející se na souřadnici
     * 
     * @param x Souřadnice X
     * @param y Souřadnice Y
     * @return  Vrátí objekt nacházející se na souřadnici
     */
    private Kostka vratKostku(int x, int y) {
        Kostka kostkaMicku = micek.vratKostku();
        if (kostkaMicku.getX() == x && kostkaMicku.getY() == y)
            return kostkaMicku;

        for (Cihlicka cihlicka : cihlicky) {
            Kostka iterovanaCihlicka = cihlicka.vratKostku();
            if (iterovanaCihlicka.getX() == x && iterovanaCihlicka.getY() == y)
                return iterovanaCihlicka;
        }
        return null;
    }

    /**
     * Zkontroluje strany plochy s objekty
     */
    private void kontrolaStranPlochy() {
        Kostka kostka = micek.vratKostku();

        if (kostka.mimoKonzoliDolni(vyska))
            micek.nastavSmerY(1);
        else if (kostka.mimoKonzoliHorni())
            micek.nastavSmerY(-1);

        if (kostka.mimoKonzoliLeva())
            micek.nastavSmerX(1);
        else if (kostka.mimoKonzoliPrava(sirka))
            micek.nastavSmerX(-1);
    }

    /**
     * Zkontroluje kolizi plochy s objekty
     */
    private void kontrolaKolizi() {
        Kostka kostka = micek.vratKostku();
        Cihlicka cihlickaKeSmazani = null;
        for (Cihlicka cihlicka : cihlicky) {
            if (kostka.kolizeVertikalni(cihlicka.vratKostku())) {
                cihlickaKeSmazani = cihlicka;
                micek.nastavSmerY(micek.vratSmerY() * -1);
                break;
            } else if (kostka.kolizeHoriznotalni(cihlicka.vratKostku())) {
                cihlickaKeSmazani = cihlicka;
                micek.nastavSmerX(micek.vratSmerX() * -1);
                break;
            }
        }
        if (cihlickaKeSmazani == null) {
            for (Cihlicka cihlicka : cihlicky) {
                if (kostka.kolizeDiagonalne(cihlicka.vratKostku(), micek.vratSmerX(), micek.vratSmerY())) {
                    cihlickaKeSmazani = cihlicka;
                    micek.nastavSmerY(micek.vratSmerY() * -1);
                    micek.nastavSmerX(micek.vratSmerX() * -1);
                    break;
                }
            }
        }
        cihlicky.remove(cihlickaKeSmazani);
    }
}