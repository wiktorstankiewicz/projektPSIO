package Postacie.WZwarciu;

import AtakiInterfejs.WojownikAtak;
import Bron.Bron;
import Bron.Woja.BronWoja;
import Postacie.Postac;

public class Wojownik extends WZwarciu{
    public Wojownik(String imie, BronWoja bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/wojownik.png";
        atak = new WojownikAtak();
    }



    //todo
}
