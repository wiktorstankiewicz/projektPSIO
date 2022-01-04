package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;

public class MagSpecjalnyAtak extends SpecjalnyAtak {
    @Serial
    private static final long serialVersionUID = 204714542489390354L;

    public void Atak(Postac p, Bron b) {
        int ArmorTMP = p.getPancerz();
        p.setPancerz(0);
        if(SpecjalnyAtak.zadajDuzeObrazenia(p, b)) p.setCzyPodpalony(true);
        p.setPancerz(ArmorTMP);
    }
}
