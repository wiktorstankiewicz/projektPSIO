package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public abstract class ZwyklyAtak implements AtakiInterfejs_I{

    static void zadajMaleObrazenia(Postac p, Bron b) {

        int obliczoneHp = p.getHp() - (int) ((b.getObrazeniaMin() + 1) * (1 - ((double) p.getPancerz() / 100.0)));
        if (obliczoneHp < 0) {
            p.setHp(0);
        } else {
            p.setHp(obliczoneHp);
        }
    }

}
