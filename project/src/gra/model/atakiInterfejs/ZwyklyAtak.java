package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;
import java.io.Serializable;

public abstract class ZwyklyAtak implements IAtakiInterface, Serializable {

    @Serial
    private static final long serialVersionUID = -5925531265400309519L;

    static void zadajMaleObrazenia(Postac p, Bron b) {

        int obliczoneHp = p.getHp() - (int) ((b.getObrazeniaMin() + 1) *
                (1 - ((double) p.getPancerz() / 100.0)));
        if (obliczoneHp < 0) {
            p.setHp(0);
        } else {
            p.setHp(obliczoneHp);
        }
    }

}
