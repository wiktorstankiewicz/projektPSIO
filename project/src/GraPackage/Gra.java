package GraPackage;

import Grafika.GUI;
import Postacie.Postac;
import Postacie.WZwarciu.WZwarciu;

import java.util.Random;

public class Gra {

    //Constants
    private final int MAX_DISTANCE = 5;
    private boolean GRACZ_WYGRANA = false;
    private boolean PRZECIWNIK_WYGRANA = false;

    //Game fields
    private Postac gracz;
    private Postac przeciwnik;
    private int firstTurn;
    private int turn;
    private int distance;
    private String akcja;

    private GUI gui;

    //Helper fields
    private final Random generator = new Random();

    public void przygotujGre() {
        firstTurn = generator.nextInt(1) + 1;
        distance = generator.nextInt(MAX_DISTANCE) + 1;

        String wybraneImie = WyborKlasy.wybierzImie();
        String wybranaPostac = WyborKlasy.wybierzPostac();
        String wybranaBron = WyborKlasy.wybierzBron(wybranaPostac);
        gracz = WyborKlasy.stworzPostac(wybranaPostac, wybraneImie, wybranaBron);

        String wylosowanaPostacPrzeciwnika = WyborKlasy.generujKlasaBot();
        String wylosowanaBronPrzeciwnika = WyborKlasy.generujBronBot(wylosowanaPostacPrzeciwnika);
        String wylosowaneImiePrzeciwnika = WyborKlasy.generujImieBota();
        przeciwnik = WyborKlasy.stworzPostac(wylosowanaPostacPrzeciwnika, wylosowaneImiePrzeciwnika, wylosowanaBronPrzeciwnika);
        gui = new GUI(this);
    }

    public void bitwa() {

        int graczHp; //Hp z poprzedniej tury
        int przeciwnikHp;

        if (gracz == null || przeciwnik == null) {
            System.out.println("Postacie nie istnieja");
            return;
        }

        gui.inicjalizujEkranGry(this);

        while (!(GRACZ_WYGRANA || PRZECIWNIK_WYGRANA)) {

            graczHp = gracz.getHp();
            przeciwnikHp = przeciwnik.getHp();

            try {
                Thread.sleep(997);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (firstTurn == turn % 2) {

                if (distance > 0 && (gracz instanceof WZwarciu)) {
                    distance--;
                    akcja = gracz.getImie() + " podszedł!";
                } else {
                    gracz.wykonajZwyklyAtak(przeciwnik, gracz.getBron());
                    akcja = gracz.getImie() + " zadał " + (przeciwnikHp - przeciwnik.getHp()) + " HP";
                }

                System.out.println(gracz.getImie() + ": " + gracz.getHp());
            } else {
                if (distance > 0 && (przeciwnik instanceof WZwarciu)) {
                    distance--;
                    akcja = przeciwnik.getImie() + " podszedł!";
                } else {
                    przeciwnik.wykonajZwyklyAtak(gracz, przeciwnik.getBron());
                    akcja = przeciwnik.getImie() + " zadał " + (graczHp - gracz.getHp()) + " HP";
                }

                System.out.println(przeciwnik.getImie() + ": " + przeciwnik.getHp() + " HP");
            }
            checkForWinner();
            gui.update(this);
            System.out.println("\nDystans: " + distance);
            turn++;
        }
    }

    public void gracz_typ() {
        System.out.println(gracz.getClass() + "   " + przeciwnik.getClass());
    }

    /**
     * Checks whether one of the players has <= 0 hp
     * and assigns the winner appropriately
     */

    private void checkForWinner() {
        if (gracz.getHp() <= 0) {
            PRZECIWNIK_WYGRANA = true;
            finishGame();
        }

        if (przeciwnik.getHp() <= 0) {
            GRACZ_WYGRANA = true;
            finishGame();
        }
    }

    private void finishGame() {
        if (GRACZ_WYGRANA) {
            System.out.println("Gratulacje! Wygrales!");
            gui.pokazKomunikatKoncowy(true);
        } else if (PRZECIWNIK_WYGRANA) {
            System.out.println("Niestey, nie udalo ci sie wygrac. Powodzenia nastepnym razem");
            gui.pokazKomunikatKoncowy(false);
        }
    }

    public Postac getGracz() {
        return gracz;
    }

    public Postac getPrzeciwnik() {
        return przeciwnik;
    }

    public int getTurn() {
        return turn;
    }

    public int getDistance() {
        return distance;
    }

    public String getAkcja() {
        return akcja;
    }

}