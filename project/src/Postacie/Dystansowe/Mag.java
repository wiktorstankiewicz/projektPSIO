package Postacie.Dystansowe;

import AtakiInterfejs.MagAtak;
import Bron.Bron;
import Postacie.Postac;

public class Mag extends Dystansowe {
    public Mag(String imie, String obrazek, Bron bron) {
        super(imie, obrazek, bron);
        atak = new MagAtak();
    }

    @Override
    public void Atak(Postac p, Bron b) {
        b=this.getBron();
        atak.Atak(p, b);
    }
    //todo
}
