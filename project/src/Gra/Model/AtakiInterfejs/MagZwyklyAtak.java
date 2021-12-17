package Gra.Model.AtakiInterfejs;

import Gra.Model.Bron.Bron;
import Gra.Model.Postacie.Postac;

public class MagZwyklyAtak extends ZwyklyAtak {
    @Override
    public void Atak(Postac p, Bron b) {
        int ArmorTMP = p.getPancerz();
        p.setPancerz(0);
        ZwyklyAtak.zadajMaleObrazenia(p, b);
        p.setPancerz(ArmorTMP);
    }
}
