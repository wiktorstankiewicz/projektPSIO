package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.util.Random;

public abstract class SpecjalnyAtak implements AtakiInterfejs_I {

    static boolean zadajDuzeObrazenia(Postac p, Bron b) {

        Random generator = new Random();

        if (50 >= generator.nextInt(100)) {
            int obliczoneHp = p.getHp() - (int) ((generator.nextInt(b.getObrazeniaMax() - b.getObrazeniaMin()) + b.getObrazeniaMin() + 1) * (1 - ((double) p.getPancerz() / 100.0)));
            if (obliczoneHp < 0) {
                p.setHp(0);
            } else {
                p.setHp(obliczoneHp);
            }
            return true;
        } else return false;
    }
}
