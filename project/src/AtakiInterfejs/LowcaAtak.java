package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public class LowcaAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postac p, Bron b) {
        AtakiInterfejs_I.zadajObrazenia(p, b);
    }
}
