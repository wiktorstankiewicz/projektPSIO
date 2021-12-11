package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public class MagSpecjalnyAtak extends SpecjalnyAtak {
    public void Atak(Postac p, Bron b) {
        int ArmorTMP = p.getPancerz();
        p.setPancerz(0);
        if(SpecjalnyAtak.zadajDuzeObrazenia(p, b)) p.setCzyPodpalony(true);
        p.setPancerz(ArmorTMP);
    }
}
