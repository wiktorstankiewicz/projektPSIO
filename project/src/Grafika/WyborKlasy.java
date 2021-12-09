package Grafika;

import Bron.Bron;
import Bron.Lowcy.BronLowcy;
import Bron.Lowcy.Luk;
import Bron.Maga.BronMaga;
import Bron.Maga.Rozdzka;
import Bron.Woja.BronWoja;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.BronZabojcy;
import Bron.Zabojcy.Sztylet;
import Postacie.Dystansowe.Lowca;
import Postacie.Dystansowe.Mag;
import Postacie.Postac;
import Postacie.WZwarciu.Wojownik;
import Postacie.WZwarciu.Zabojca;

import java.util.Random;
import java.util.Scanner;

public abstract class WyborKlasy {
    static String[] listaKlas = {"Wojownik", "Zabojca", "Lowca", "Mag"};
    static String[] listaBroniLowcy = {"Luk"};
    static String[] listaBroniZabojcy = {"Sztylet"};
    static String[] listaBroniMaga = {"Rozdzka"};
    static String[] listaBroniWojownika = {"Miecz", "Mlot"};
    static String[] listaBroni;
    static String[] listaImionBota = {"Ziemowit Bździągwa", "Koszmar Dziekana", "Java Senior Developer", "Garbage Collector"};
    static Random random = new Random();

    public static String generujKlasaBot() {
        Random generator = new Random();

        return listaKlas[generator.nextInt(listaKlas.length)];
    }

    public static String generujBronBot(String klasaBot) {

        switch (klasaBot) {
            case "Wojownik":
                listaBroni = listaBroniWojownika;
                break;
            case "Zabojca":
                listaBroni = listaBroniZabojcy;
                break;
            case "Lowca":
                listaBroni = listaBroniLowcy;
                break;
            case "Mag":
                listaBroni = listaBroniMaga;
                break;
        }

        return listaBroni[random.nextInt(listaBroni.length)];

    }

    public static String wybierzImie() {

        String imie;
        System.out.print("Podaj imie:");
        Scanner czytnik = new Scanner(System.in);
        imie = czytnik.nextLine();

        return imie;
    }

    public static String wybierzPostac() {
        System.out.println("Wybierz klase:");
        for (int i = 0; i < listaKlas.length; i++) {
            System.out.println((i + 1) + "." + listaKlas[i]);
        }

        Scanner czytnik = new Scanner(System.in);
        int wyborPostaci = czytnik.nextInt();

        if (wyborPostaci < listaKlas.length + 1 && wyborPostaci > 0) return listaKlas[wyborPostaci - 1];
        else return "Wojownik";

    }


    public static String wybierzBron(String wyborGracza) {
        Scanner czytnik = new Scanner(System.in);

        switch (wyborGracza) {
            case "Wojownik":
                listaBroni = listaBroniWojownika;
                break;
            case "Zabojca":
                listaBroni = listaBroniZabojcy;
                break;
            case "Lowca":
                listaBroni = listaBroniLowcy;
                break;
            case "Mag":
                listaBroni = listaBroniMaga;
                break;
            default:
                break;
        }
        System.out.println("Wybierz bron:");
        for (int i = 0; i < listaBroni.length; i++) {
            System.out.println((i + 1) + "." + listaBroni[i]);
        }
        int wyborBroni = czytnik.nextInt();
        return listaBroni[wyborBroni - 1];
    }

    public static Postac stworzPostac(String wybranaPostac, String imie, String bron) {
        switch (wybranaPostac) {
            case "Wojownik":
                return new Wojownik(imie, (BronWoja) WyborKlasy.stringNaBron(bron));
            case "Lowca":
                return new Lowca(imie, (BronLowcy) WyborKlasy.stringNaBron(bron));
            case "Zabojca":
                return new Zabojca(imie, (BronZabojcy) WyborKlasy.stringNaBron(bron));
            case "Mag":
                return new Mag(imie, (BronMaga) WyborKlasy.stringNaBron(bron));
        }
        return new Wojownik("BLAD", (BronWoja) new Miecz());
    }

    private static Bron stringNaBron(String bron) {
        Bron wynik;
        switch (bron) {
            case "Miecz":
                wynik = (BronWoja) new Miecz();
                break;
            case "Mlot":
                wynik = (BronWoja) new Mlot();
                break;
            case "Luk":
                wynik = (BronLowcy) new Luk();
                break;
            case "Rozdzka":
                wynik = (BronMaga) new Rozdzka();
                break;
            case "Sztylet":
                wynik = (BronZabojcy) new Sztylet();
                break;
            default:
                wynik = (BronWoja) new Miecz();
        }
        return wynik;
    }

    public static String generujImieBota() {
        return listaImionBota[random.nextInt(listaImionBota.length)];
    }
}
