package Postacie.Dystansowe;

import AtakiInterfejs.LowcaAtak;
import Bron.Bron;
import Bron.Lowcy.BronLowcy;
import Postacie.Postac;

public class Lowca extends Dystansowe{

    public Lowca(String imie, BronLowcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/lowca.png";
        atak = new LowcaAtak();
    }


    //todo
}
