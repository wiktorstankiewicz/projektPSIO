package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.util.Random;

public class ZabojcaSpecjalnyAtak extends SpecjalnyAtak {
    @Override
    public void atak(Postac p, Bron b) {
        Random generator = new Random();

        if (25 >= generator.nextInt(100)) {
            p.setHp(0);
        } else {
            zadajDuzeObrazenia(p, b);
        }
    }
}
