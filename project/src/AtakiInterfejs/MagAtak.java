package AtakiInterfejs;

import Bron.Bron;
import Postacie.*;

public class MagAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postac P, Bron b) {

        int ArmorTMP = P.getPancerz();
        P.setPancerz(0);
        AtakiInterfejs_I.zadajObrazenia(P, b);
        P.setPancerz(ArmorTMP);

    }
}
