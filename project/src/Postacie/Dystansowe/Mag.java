package Postacie.Dystansowe;

import AtakiInterfejs.MagAtak;
import Bron.Bron;
import Bron.Maga.BronMaga;
import Postacie.Postac;

public class Mag extends Dystansowe {
    public Mag(String imie, BronMaga bron) {
        super(imie, bron);
        atak = new MagAtak();
    }

    //todo
}
