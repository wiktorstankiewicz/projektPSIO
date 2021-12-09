package AtakiInterfejs;

import Bron.Bron;
import Postacie.*;

public class LowcaAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postac P, Bron b) {
        AtakiInterfejs_I.zadajObrazenia(P, b);

    }
}
