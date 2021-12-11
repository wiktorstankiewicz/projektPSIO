package Postacie.Dystansowe;

import AtakiInterfejs.LowcaSpecjalnyAtak;
import AtakiInterfejs.LowcaZwyklyAtak;
import Bron.Lowcy.BronLowcy;

public class Lowca extends Dystansowe {
    public Lowca(String imie, BronLowcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/lowca.png";
        zwyklyAtak = new LowcaZwyklyAtak();
        specjalnyAtak = new LowcaSpecjalnyAtak();
        pancerz = 30;
    }
}
