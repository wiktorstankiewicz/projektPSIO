package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.util.Random;

public class ZabojcaZwyklyAtak extends ZwyklyAtak {
    @Override
    public void atak(Postac p, Bron b) {
        Random generator = new Random();

        if (7 >= generator.nextInt(100)) {
            p.setHp(0);
        } else {
            ZwyklyAtak.zadajMaleObrazenia(p, b);
        }
    }
}