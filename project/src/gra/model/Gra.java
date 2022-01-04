package gra.model;

import gra.controller.GameController;
import gra.model.bron.Bron;
import gra.model.observers.Observable;
import gra.model.observers.Observer;
import gra.model.postacie.Postac;
import gra.model.postacie.wZwarciu.WZwarciu;
import utilities.Utils;
import utilities.WyborKlasy;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gra implements IGameModel, Observable, Runnable {

    //Constants
    private final int MAX_DISTANCE = 5;
    private final String POSTACIE_NAZWA_PLIKU = "postacie.ser";
    private final String WCZYTYWANIE_Z_PLIKU_POSTACI_Nazwa = "wczyt_postaci.txt"; //schemat zapisu w pliku: klasa;imie;bron

    //Game fields
    private Postac gracz;
    private Postac przeciwnik;
    private ArrayList<Postac> postacieTab;
    private boolean GRACZ_WYGRANA = false;
    private boolean PRZECIWNIK_WYGRANA = false;
    private boolean wykonanoAkcje;
    private int firstTurn;
    private int turn;
    private int distance;
    private String akcja;

    private ArrayList<Observer> observers;

    //Helper fields
    private final Random generator = new Random();
    private final Scanner scan = new Scanner(System.in);
    private ArrayList<Postac> postacieZPlikuTab;

    public Gra(Postac gracz, Postac przeciwnik) {
        this.gracz = gracz;
        this.przeciwnik = przeciwnik;
        postacieTab = new ArrayList<>();
        postacieZPlikuTab = new ArrayList<>();
        observers = new ArrayList<>();
        deserialize();
    }

    public void run() {
        przygotujGre();
        bitwa();
    }

    public void przygotujGre() {
        firstTurn = generator.nextInt(2);
        distance = generator.nextInt(MAX_DISTANCE) + 1;
        serialize();
        new GameController(this);
    }

    /*private void createPostacie() {
        //---------------------------------------------------------
        //          Generuj Gracza
        //---------------------------------------------------------
        if (postacieTab.size() == 0) {
            stworzGracz();
        } else {
            System.out.println("1. Stworz nowa postac");
            System.out.println("2. Wybierz postac z juz stworzonych");

            int wybor = getUserInputInt(1, 2);

            if (wybor == 1) {
                stworzGracz();
            } else {
                gracz = wybierzPostac();
                postacieTab.remove(gracz); //usun postac ktora wybral gracz, zeby nie wylosowac jej jako przeciwnika
            }
        }

        //---------------------------------------------------------
        //          Generuj Przeciwnika
        //---------------------------------------------------------
        if (postacieTab.size() == 0) {
            generujPrzeciwnik();
        } else {
            System.out.println("1. Generuj nowego przeciwnika");
            System.out.println("2. Wybierz przeciwnika z juz stworzonych");
            System.out.println("3. Wylosuj przeciwnika z juz stworzonych");

            int wybor = getUserInputInt(1, 3);

            if (wybor == 1) generujPrzeciwnik();
            else if (wybor == 2) przeciwnik = wybierzPostac();
            else wylosujPrzeciwnika();
        }

        //dodaj gracza z powrotem do tablicy, w celu serializacji calej tablicy
        if (!postacieTab.contains(gracz))
            postacieTab.add(gracz);
        serialize();
    }

    private void stworzGracz() {
        String wybraneImie = WyborKlasy.wybierzImie();
        String wybranaPostac = WyborKlasy.wybierzPostac();
        String wybranaBron = WyborKlasy.wybierzBron(wybranaPostac);
        gracz = WyborKlasy.stworzPostac(wybranaPostac, wybraneImie, wybranaBron);
    }

    private Postac wybierzPostac() {
        for (int i = 0; i < postacieTab.size(); i++) {
            System.out.println((i + 1) + "." + postacieTab.get(i));
        }

        int wybor = getUserInputInt(1, postacieTab.size());

        return postacieTab.get(wybor - 1);
    }*/

    public static Postac generujPrzeciwnik() {
        String wylosowanaPostacPrzeciwnika = WyborKlasy.generujKlasaBot();
        String wylosowanaBronPrzeciwnika = WyborKlasy.generujBronBot(wylosowanaPostacPrzeciwnika);
        String wylosowaneImiePrzeciwnika = WyborKlasy.generujImieBota();
        return WyborKlasy.stworzPostac(wylosowanaPostacPrzeciwnika, wylosowaneImiePrzeciwnika, wylosowanaBronPrzeciwnika);
    }

    /*private void wylosujPrzeciwnika() {
        int randomIndex = generator.nextInt(postacieTab.size()); //zasieg [0, size)
        przeciwnik = postacieTab.get(randomIndex);
    }*/

    private void deserialize() {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(POSTACIE_NAZWA_PLIKU))) {
            Object tab = is.readObject();
            if (tab instanceof ArrayList)
                postacieTab = (ArrayList<Postac>) tab;
        } catch (IOException | ClassNotFoundException e) {
        }

        ArrayList arr = Utils.readArrayListFromTXTFile(new File(WCZYTYWANIE_Z_PLIKU_POSTACI_Nazwa));
        if (arr == null || arr.size() <= 0 || !(arr.get(0) instanceof Postac)) return;

        for (int i = 0; i < this.postacieZPlikuTab.size(); i++) {
            postacieTab.add((Postac) arr.get(i));
            postacieZPlikuTab.add((Postac) arr.get(i));
        }
    }

    private void serialize() {

        for (int i = 0; i < postacieZPlikuTab.size(); i++) {
            postacieTab.remove(postacieZPlikuTab.get(i));
        }

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(POSTACIE_NAZWA_PLIKU))) {
            os.writeObject(postacieTab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bitwa() {

        if (gracz == null || przeciwnik == null) {
            System.out.println("Postacie nie istnieja");
            return;
        }

        while (!(GRACZ_WYGRANA || PRZECIWNIK_WYGRANA)) {
            try {
                Thread.sleep(997);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (firstTurn == turn % 2) {
                while (!wykonanoAkcje) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                wykonanoAkcje = false;
            } else enemyTurn();

            damageFromFire();
            checkForWinner();
            notifyObservers();
            turn++;
        }

    }

    public void normalAttack(int attackType) {
        int enemyHp = przeciwnik.getHp();
        if (distance > 0 && gracz instanceof WZwarciu) {
            akcja = "Jestes za daleko!";
        } else {
            zmianaAtaku(gracz, przeciwnik, gracz.getBron(), attackType);
            setAkcja(gracz.getImie() + " zadał " + (enemyHp - przeciwnik.getHp()) + " HP");
        }
        wykonanoAkcje = true;
    }

    public void walkUpAction() {
        if (getDistance() > 0) {
            distance--;
            akcja = getGracz().getImie() + " podszedł!";
        }else{
            akcja = getGracz().getImie() + " traci turę!";
        }
        wykonanoAkcje = true;
    }

    public void enemyTurn() {
        int playerHp = gracz.getHp();
        if (distance > 0 && przeciwnik instanceof WZwarciu) {
            distance--;
            akcja = przeciwnik.getImie() + " podszedł!";
        } else {
            zmianaAtaku(przeciwnik, gracz, przeciwnik.getBron(), (generator.nextInt(2)) + 1);

            akcja = przeciwnik.getImie() + " zadał " + (playerHp - gracz.getHp()) + " HP";
        }
    }

    public void damageFromFire() {
        if (gracz.getCzyPodpalony()) gracz.setHp(gracz.getHp() - 5);
        if (przeciwnik.getCzyPodpalony()) przeciwnik.setHp(przeciwnik.getHp() - 5);
    }

    public void zmianaAtaku(Postac x, Postac y, Bron b, int rodzajAtaku) { //rodzaj ataku: 1-Zwykły, 2-Specjalny, 0-brak wyboru
        if (rodzajAtaku == 2) x.wykonajSpecjalnyAtak(y, b);
        else x.wykonajZwyklyAtak(y, b);
    }

    /**
     * Checks whether one of the players has <= 0 hp
     * and assigns the winner appropriately
     */

    private void checkForWinner() {
        if (gracz.getHp() <= 0) {
            PRZECIWNIK_WYGRANA = true;
        }

        if (przeciwnik.getHp() <= 0) {
            GRACZ_WYGRANA = true;
        }
        finishGame();
    }

    private void finishGame() {
        if (GRACZ_WYGRANA) {
            System.out.println("Gratulacje! Wygrales!");
        } else if (PRZECIWNIK_WYGRANA) {
            System.out.println("Niestey, nie udalo ci sie wygrac. Powodzenia nastepnym razem");
        }
        notifyObservers();
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this);
        }
    }

    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
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

    public boolean getGRACZ_WYGRANA() {
        return GRACZ_WYGRANA;
    }

    public boolean getPRZECIWNIK_WYGRANA() {
        return PRZECIWNIK_WYGRANA;
    }

    public void setAkcja(String akcja) {
        this.akcja = akcja;
    }

    public ArrayList<Postac> getPostacieTab() {
        return postacieTab;
    }

    //Pobiera wartosc od uzytkownika
    //Ponawia probe jesli wprowadzono zle dane
    //zle dane -> wartosc nie jest intem && nie jest w zakresie [lower, upper]
    private int getUserInputInt(int lowerBound, int upperBound) { // [lower, upper]
        int wybor = 0;

        while (true) {
            try {
                wybor = Integer.parseInt(scan.next());
            } catch (Exception e) {
                System.out.println("Nieprawidlowa opcja, sprobuj ponownie");
                continue;
            }

            if (wybor < lowerBound || wybor > upperBound) {
                System.out.println("Nieprawidlowa opcja, sprobuj ponownie");
                continue;
            }

            break;
        }
        return wybor;
    }

    /*private void wypiszTab(ArrayList<? extends Postac> tab) {
        for (Postac p : tab) {
            System.out.println(p);
        }
    }*/
}