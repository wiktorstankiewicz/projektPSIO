package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public class MagZwyklyAtak extends ZwyklyAtak {
    @Override
    public void Atak(Postac p, Bron b) {
        int ArmorTMP = p.getPancerz();
        p.setPancerz(0);
        ZwyklyAtak.zadajMaleObrazenia(p, b);
        p.setPancerz(ArmorTMP);
    }
}
