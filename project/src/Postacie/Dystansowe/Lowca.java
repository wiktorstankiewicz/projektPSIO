package Postacie.Dystansowe;

import AtakiInterfejs.LowcaAtak;
import Bron.Bron;
import Postacie.Postac;

public class Lowca extends Dystansowe{
    public Lowca(String imie, String obrazek, Bron bron) {
        super(imie, obrazek, bron);
        atak = new LowcaAtak();
    }

    @Override
    public void Atak(Postac p, Bron b) {
        b=this.getBron();
        atak.Atak(p, b);
    }
    //todo
}
