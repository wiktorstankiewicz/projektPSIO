package Postacie.Dystansowe;

import AtakiInterfejs.MagZwyklyAtak;
import Bron.Maga.BronMaga;

public class Mag extends Dystansowe {
    public Mag(String imie, BronMaga bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/mag.png";
        atak = new MagZwyklyAtak();
        pancerz = 15;
    }
}
