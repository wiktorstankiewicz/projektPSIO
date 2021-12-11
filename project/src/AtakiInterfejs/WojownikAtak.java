package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.io.Serializable;
import java.util.Random;

public class WojownikAtak implements AtakiInterfejs_I, Serializable {
    @Override
    public void Atak(Postac p, Bron b) {
        Random generator = new Random();
        if (15 >= generator.nextInt(100)) {
            AtakiInterfejs_I.zadajObrazenia(p, b);
        }
        AtakiInterfejs_I.zadajObrazenia(p, b);
    }
}