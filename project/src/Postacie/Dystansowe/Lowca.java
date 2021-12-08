package Postacie.Dystansowe;

import AtakiInterfejs.LowcaAtak;
import Bron.Bron;
import Bron.Lowcy.BronLowcy;
import Postacie.Postac;

public class Lowca extends Dystansowe{

    public Lowca(String imie, BronLowcy bron) {
        super(imie, bron);
    }

    @Override
    public void Atak(Postac p, Bron b) {
        b=this.getBron();
        atak.Atak(p, b);
    }
    //todo
}
