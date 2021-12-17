package Gra.Model.AtakiInterfejs;

import Gra.Model.Bron.Bron;
import Gra.Model.Postacie.Postac;

public class MagSpecjalnyAtak extends SpecjalnyAtak {
    public void Atak(Postac p, Bron b) {
        int ArmorTMP = p.getPancerz();
        p.setPancerz(0);
        if(SpecjalnyAtak.zadajDuzeObrazenia(p, b)) p.setCzyPodpalony(true);
        p.setPancerz(ArmorTMP);
    }
}
