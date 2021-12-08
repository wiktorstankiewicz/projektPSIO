package Postacie.Dystansowe;

import AtakiInterfejs.MagAtak;
import Bron.Bron;
import Bron.Maga.BronMaga;
import Postacie.Postac;

public class Mag extends Dystansowe {
    public Mag(String imie, BronMaga bron) {
        super(imie, bron);
    }

    @Override
    public void Atak(Postac p, Bron b) {
        b=this.getBron();
        atak.Atak(p, b);
    }
    //todo
}
