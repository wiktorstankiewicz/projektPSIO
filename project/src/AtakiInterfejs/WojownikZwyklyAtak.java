package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.util.Random;

public class WojownikZwyklyAtak extends ZwyklyAtak {
    @Override
    public void atak(Postac p, Bron b) {
        Random generator = new Random();
        if (15 >= generator.nextInt(100)) {
            ZwyklyAtak.zadajMaleObrazenia(p, b);
        }
        ZwyklyAtak.zadajMaleObrazenia(p, b);
    }
}