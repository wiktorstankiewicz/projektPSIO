package Postacie.WZwarciu;

import AtakiInterfejs.WojownikSpecjalnyAtak;
import AtakiInterfejs.WojownikZwyklyAtak;
import Bron.Woja.BronWoja;

public class Wojownik extends WZwarciu {
    public Wojownik(String imie, BronWoja bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/wojownik.png";
        zwyklyAtak = new WojownikZwyklyAtak();
        specjalnyAtak = new WojownikSpecjalnyAtak();
        pancerz = 50;
    }
}
