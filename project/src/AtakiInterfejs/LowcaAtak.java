package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

import java.io.Serializable;

public class LowcaAtak implements AtakiInterfejs_I, Serializable {
    @Override
    public void Atak(Postac p, Bron b) {
        AtakiInterfejs_I.zadajObrazenia(p, b);
    }
}
