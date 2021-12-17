package Gra.Model.Postacie.WZwarciu;

import Gra.Model.AtakiInterfejs.WojownikSpecjalnyAtak;
import Gra.Model.AtakiInterfejs.WojownikZwyklyAtak;
import Gra.Model.Bron.Woja.BronWoja;

public class Wojownik extends WZwarciu {
    public Wojownik(String imie, BronWoja bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/wojownik.png";
        zwyklyAtak = new WojownikZwyklyAtak();
        specjalnyAtak = new WojownikSpecjalnyAtak();
        pancerz = 50;
    }
}
