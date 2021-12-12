package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.util.Random;

public class WojownikSpecjalnyAtak extends SpecjalnyAtak {
    @Override
    public void atak(Postac p, Bron b) {
        Random generator = new Random();
        if (30 >= generator.nextInt(100))
        {
            zadajDuzeObrazenia(p, b);
        }
        zadajDuzeObrazenia(p, b);
    }
}
