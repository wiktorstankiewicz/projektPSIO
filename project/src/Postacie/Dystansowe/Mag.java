package Postacie.Dystansowe;

import AtakiInterfejs.MagSpecjalnyAtak;
import AtakiInterfejs.MagZwyklyAtak;
import Bron.Maga.BronMaga;

public class Mag extends Dystansowe {
    public Mag(String imie, BronMaga bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/mag.png";
        zwyklyAtak = new MagZwyklyAtak();
        specjalnyAtak = new MagSpecjalnyAtak();
        pancerz = 15;
    }
}
