package Gra.Model.Postacie.Dystansowe;

import Gra.Model.AtakiInterfejs.LowcaSpecjalnyAtak;
import Gra.Model.AtakiInterfejs.LowcaZwyklyAtak;
import Gra.Model.Bron.Lowcy.BronLowcy;

public class Lowca extends Dystansowe {
    public Lowca(String imie, BronLowcy bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/lowca.png";
        zwyklyAtak = new LowcaZwyklyAtak();
        specjalnyAtak = new LowcaSpecjalnyAtak();
        pancerz = 30;
    }
}
