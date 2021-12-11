package GraPackage;

import AtakiInterfejs.*;
import Bron.Lowcy.Luk;
import Bron.Maga.Rozdzka;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.Sztylet;
import Grafika.GUI;
import Postacie.Dystansowe.Lowca;
import Postacie.Dystansowe.Mag;
import Postacie.Postac;
import Postacie.WZwarciu.WZwarciu;
import Postacie.WZwarciu.Wojownik;
import Postacie.WZwarciu.Zabojca;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Gra {

    //Constants
    private final int MAX_DISTANCE = 5;
    private boolean GRACZ_WYGRANA = false;
    private boolean PRZECIWNIK_WYGRANA = false;
    private final String POSTACIE_NAZWA_PLIKU = "postacie.ser";
    private final String WCZYTYWANIE_Z_PLIKU_POSTACI_Nazwa = "wczyt_postaci.txt"; //schemat zapisu w pliku: klasa;imie;bron

    //Game fields
    private Postac gracz;
    private Postac przeciwnik;
    private ArrayList<Postac> postacieTab;
    private int firstTurn;
    private int turn;
    private int distance;
    private String akcja;

    private GUI gui;

    //Helper fields
    private final Random generator = new Random();
    private final Scanner scan = new Scanner(System.in);

    public Gra(){
        postacieTab = new ArrayList<>();
        deserialize();
        wypiszTab(postacieTab); //todo usunac metode do debugu
    }

    public void przygotujGre() {
        firstTurn = generator.nextInt(1) + 1;
        distance = generator.nextInt(MAX_DISTANCE) + 1;

        createPostacie();

        gui = new GUI(this);
    }

    private void createPostacie(){
        boolean nowaPostac = false;
    //---------------------------------------------------------
    //          Generuj Gracza
    //---------------------------------------------------------
        if (postacieTab.size() == 0) {
            nowaPostac = true;
            stworzGracz();
        }
        else {
            System.out.println("1. Stworz nowa postac");
            System.out.println("2. Wybierz postac z juz stworzonych");

            int wybor = getUserInputInt(1, 2);

            if (wybor == 1) {
                nowaPostac = true;
                stworzGracz();
            }
            else {
                gracz = wybierzPostac();
                postacieTab.remove(gracz); //usun postac ktora wybral gracz, zeby nie wylosowac jej jako przeciwnika
            }
        }

    //---------------------------------------------------------
    //          Generuj Przeciwnika
    //---------------------------------------------------------
        if (postacieTab.size() == 0){
            generujPrzeciwnik();
        }
        else {
            System.out.println("1. Generuj nowego przeciwnika");
            System.out.println("2. Wybierz przeciwnika z juz stworzonych");
            System.out.println("3. Wylosuj przeciwnika z juz stworzonych");

            int wybor = getUserInputInt(1, 3);

            if (wybor == 1) generujPrzeciwnik();
            else if (wybor == 2) przeciwnik = wybierzPostac();
            else wylosujPrzeciwnika();
        }

        //dodaj gracza spowrotem do tablicy, jesli nie tworzono nowego, w celu serializacji calej tablicy
        if (!nowaPostac)
            postacieTab.add(gracz);
        serialize();
    }

    private void stworzGracz(){
        String wybraneImie = WyborKlasy.wybierzImie();
        String wybranaPostac = WyborKlasy.wybierzPostac();
        String wybranaBron = WyborKlasy.wybierzBron(wybranaPostac);
        gracz = WyborKlasy.stworzPostac(wybranaPostac, wybraneImie, wybranaBron);

        if (!postacieTab.contains(gracz)) {
            postacieTab.add(gracz);
        }
    }

    private Postac wybierzPostac(){
        for (int i=0; i<postacieTab.size(); i++){
            System.out.println((i+1) + "." + postacieTab.get(i));
        }

        int wybor = getUserInputInt(1, postacieTab.size());

        return postacieTab.get(wybor - 1);
    }

    private void generujPrzeciwnik(){
        String wylosowanaPostacPrzeciwnika = WyborKlasy.generujKlasaBot();
        String wylosowanaBronPrzeciwnika = WyborKlasy.generujBronBot(wylosowanaPostacPrzeciwnika);
        String wylosowaneImiePrzeciwnika = WyborKlasy.generujImieBota();
        przeciwnik = WyborKlasy.stworzPostac(wylosowanaPostacPrzeciwnika, wylosowaneImiePrzeciwnika, wylosowanaBronPrzeciwnika);
    }

    private void wylosujPrzeciwnika(){
        int randomIndex = generator.nextInt(postacieTab.size()); //zasieg [0, size)
        przeciwnik = postacieTab.get(randomIndex);
    }

    private void deserialize(){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(POSTACIE_NAZWA_PLIKU))){
            Object tab = is.readObject();
            if (tab instanceof ArrayList)
                postacieTab = (ArrayList<Postac>) tab;
        } catch (IOException | ClassNotFoundException e) {
        }

        for (int i = 0; i < postacieTab.size(); i++) {
            if (postacieTab.get(i).getAtak() == null){
                AtakiInterfejs_I atak = null;
                Postac p = postacieTab.get(i);

                if (p instanceof Lowca) atak = new LowcaAtak();
                else if (p instanceof Mag) atak = new MagAtak();
                else if (p instanceof Wojownik) atak = new WojownikAtak();
                else if (p instanceof Zabojca) atak = new ZabojcaAtak();

                postacieTab.get(i).setAtak(atak);
            }
        }


        try (BufferedReader breader = new BufferedReader(new FileReader(WCZYTYWANIE_Z_PLIKU_POSTACI_Nazwa))){

            String wiersz = "";
            String[] staty;

            while ((wiersz = breader.readLine()) != null){
                wiersz = (wiersz.toLowerCase()).trim();
                staty = wiersz.split(";");

                switch (staty[0]){
                    case "zabojca":
                        if(staty[2].equals("sztylet")) {
                            postacieTab.add(new Zabojca(staty[1], new Sztylet()));
                        }
                    case "lowca":
                        if (staty[2].equals("luk")) {
                            postacieTab.add(new Lowca(staty[1], new Luk()));
                        }
                    case "wojownik":
                        if(staty[2].equals("miecz")) {
                            postacieTab.add(new Wojownik(staty[1], new Miecz()));
                        }
                        if(staty[2].equals("mlot")) {
                            postacieTab.add(new Wojownik(staty[1], new Mlot()));
                        }
                    case "mag":
                        if (staty[2].equals("rozdzka")) {
                            postacieTab.add(new Mag(staty[1], new Rozdzka()));
                        }
                }
            }
        } catch (Exception e){

        }
    }

    private void serialize(){
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(POSTACIE_NAZWA_PLIKU))){
            os.writeObject(postacieTab);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                    gracz.Atak(przeciwnik, gracz.getBron());
                    akcja = gracz.getImie() + " zadał " + (przeciwnikHp - przeciwnik.getHp()) + " HP";
                }

                System.out.println(gracz.getImie() + ": " + gracz.getHp());
            } else {
                if (distance > 0 && (przeciwnik instanceof WZwarciu)) {
                    distance--;
                    akcja = przeciwnik.getImie() + " podszedł!";
                } else {
                    przeciwnik.Atak(gracz, przeciwnik.getBron());
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

    //Pobiera wartosc od uzytkownika
    //Ponawia probe jesli wprowadzono zle dane
    //zle dane -> wartosc nie jest intem && nie jest w zakresie [lower, upper]
    private int getUserInputInt(int lowerBound, int upperBound){ // [lower, upper]
        int wybor = 0;

        while(true){
            try {
                wybor = Integer.parseInt(scan.next());
            } catch (Exception e){
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

    private void wypiszTab(ArrayList<? extends Postac> tab){
        for (Postac p: tab) {
            System.out.println(p);
        }
    }
}