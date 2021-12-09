package Postacie.Dystansowe;

import AtakiInterfejs.MagAtak;
import Bron.Maga.BronMaga;

public class Mag extends Dystansowe {
    public Mag(String imie, BronMaga bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/mag.png";
        atak = new MagAtak();
        pancerz = 20;
    }
}
