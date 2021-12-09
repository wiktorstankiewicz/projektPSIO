package Postacie.WZwarciu;

import AtakiInterfejs.WojownikAtak;
import Bron.Woja.BronWoja;

public class Wojownik extends WZwarciu {
    public Wojownik(String imie, BronWoja bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/wojownik.png";
        atak = new WojownikAtak();
        pancerz = 40;
    }
}
