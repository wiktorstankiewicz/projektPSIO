package Postacie.Dystansowe;

import AtakiInterfejs.LowcaAtak;
import Bron.Lowcy.BronLowcy;

public class Lowca extends Dystansowe{

    public Lowca(String imie, BronLowcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/lowca.png";
        atak = new LowcaAtak();
        pancerz = 10;
    }
}
