package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public class MagAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postac p, Bron b) {
        int ArmorTMP = p.getPancerz();
        p.setPancerz(0);
        AtakiInterfejs_I.zadajObrazenia(p, b);
        p.setPancerz(ArmorTMP);
    }
}
