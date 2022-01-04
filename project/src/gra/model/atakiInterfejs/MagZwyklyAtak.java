package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;

public class MagZwyklyAtak extends ZwyklyAtak {
    @Serial
    private static final long serialVersionUID = 997001796440274893L;

    @Override
    public void Atak(Postac p, Bron b) {
        int ArmorTMP = p.getPancerz();
        p.setPancerz(0);
        ZwyklyAtak.zadajMaleObrazenia(p, b);
        p.setPancerz(ArmorTMP);
    }
}
