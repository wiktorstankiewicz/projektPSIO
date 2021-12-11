package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.util.Random;

public class WojownikSpecjalnyAtak extends SpecjalnyAtak {
    @Override
    public void Atak(Postac p, Bron b) {
        Random generator = new Random();
        if (15 >= generator.nextInt(100)) {
            SpecjalnyAtak.zadajDuzeObrazenia(p, b);
        }
        SpecjalnyAtak.zadajDuzeObrazenia(p, b);
    }
}
