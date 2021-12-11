package Postacie.WZwarciu;

import AtakiInterfejs.WojownikZwyklyAtak;
import Bron.Woja.BronWoja;

public class Wojownik extends WZwarciu {
    public Wojownik(String imie, BronWoja bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/wojownik.png";
        atak = new WojownikZwyklyAtak();
        pancerz = 50;
    }
}
