package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.util.Random;

public class ZabojcaAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postac p, Bron b) {
        Random generator = new Random();

        if (7 >= generator.nextInt(100)) {
            p.setHp(0);
        } else {
            AtakiInterfejs_I.zadajObrazenia(p, b);
        }
    }
}