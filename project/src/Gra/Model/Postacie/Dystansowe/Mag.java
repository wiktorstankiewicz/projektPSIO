package Gra.Model.Postacie.Dystansowe;

import Gra.Model.AtakiInterfejs.MagSpecjalnyAtak;
import Gra.Model.AtakiInterfejs.MagZwyklyAtak;
import Gra.Model.Bron.Maga.BronMaga;

public class Mag extends Dystansowe {
    public Mag(String imie, BronMaga bron) {
        super(imie, bron);
        imageFilePath = "project/resources/img/mag.png";
        zwyklyAtak = new MagZwyklyAtak();
        specjalnyAtak = new MagSpecjalnyAtak();
        pancerz = 15;
    }
}
