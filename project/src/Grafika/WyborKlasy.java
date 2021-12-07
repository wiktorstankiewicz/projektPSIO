package Grafika;

import java.util.Random;
import java.util.Scanner;

public abstract class WyborKlasy {
    static String[] listaKlas = {"Wojownik", "Zabojca", "Lowca", "Mag"};

    static String[] listaBroniLowcy = {"Luk"};
    static String[] listaBroniZabojcy = {"Sztylet"};
    static String[] listaBroniMaga = {"Rozdzka"};
    static String[] listaBroniWojownika = {"Miecz", "Mlot"};
    static String[] listaBroni;

    public static String generujKlasaBot() {
        Random generator = new Random();

        return listaKlas[generator.nextInt(listaKlas.length)];
    }

    public static String generujBronBot(String klasaBot) {

        switch (klasaBot) {
            case "Wojownik":
                break;
            case "Zabojca":
                listaBroni = listaBroniLowcy;
                break;
            case "Lowca":
                listaBroni = listaBroniZabojcy;
                break;
            case "Mag":
                listaBroni = listaBroniMaga;
                break;
        }

        Random generator = new Random();

        return listaBroni[generator.nextInt(listaBroni.length)];

    }

    public static String wybierzKlase() {


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
}
