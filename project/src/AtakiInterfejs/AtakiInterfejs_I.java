package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.util.Random;

public interface AtakiInterfejs_I {
    void Atak(Postac p, Bron b);//p to postac atakowana, b to bron atakującego

    static void zadajObrazenia(Postac p, Bron b) {
        Random generator = new Random();
        int obliczoneHp = p.getHp() - (int) ((generator.nextInt(b.getObrazeniaMax() - b.getObrazeniaMin()) +
                b.getObrazeniaMin() + 1) * (1 - ((double) p.getPancerz() / 100.0)));
        if (obliczoneHp < 0) {
            p.setHp(0);
        } else {
            p.setHp(obliczoneHp);
        }
    }
}
