package Grafika;

import java.util.Scanner;

public abstract class WyborKlasy {

    public static int wybierzKlase() {

        String[] listaBroniLowcy ={"Łuk"};
        String[] listaBroniZabojcy = {"Sztylet"};
        String[] listaBroniMaga = {"Różdżka"};
        String[] listaBroni={"Miecz", "Młot"};

        String[] listaKlas = {"Wojownik", "Zabójca", "Łowca", "Mag"};
        System.out.println("Wybierz klase:");
        for (int i = 0; i < listaKlas.length; i++) {
            System.out.println((i + 1)+ "." + listaKlas[i]);
        }

        Scanner czytnik = new Scanner(System.in);
        int wyborPostaci = czytnik.nextInt();

        switch (wyborPostaci) {
            case 1:
                break;
            case 2:
                listaBroni = listaBroniLowcy;
                break;
            case 3:
                listaBroni = listaBroniZabojcy;
                break;
            case 4:
                listaBroni = listaBroniMaga;
                break;

            default:
                        break;
        }

        System.out.println("Wybierz bron:");
        for (int i = 0; i < listaBroni.length; i++) {
            System.out.println((i + 1) +"." + listaBroni[i]);
        }

        int wyborBroni = czytnik.nextInt();

        return wyborPostaci+wyborBroni;
    }

}
