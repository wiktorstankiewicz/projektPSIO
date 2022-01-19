package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

public abstract class SpecjalnyAtak implements IAtakiInterface, Serializable {

    @Serial
    private static final long serialVersionUID = 8532566225854114736L;

    static boolean zadajDuzeObrazenia(Postac p, Bron b) {

        Random generator = new Random();

        if (50 >= generator.nextInt(100)) {
            int obliczoneHp = p.getHp() - (int) ((generator.nextInt(b.getObrazeniaMax() -
                    b.getObrazeniaMin()) + b.getObrazeniaMin() + 1) * (1 - ((double) p.getPancerz() / 100.0)));
            if (obliczoneHp < 0) {
                p.setHp(0);
            } else {
                p.setHp(obliczoneHp);
            }
            return true;
        } else return false;
    }
}
