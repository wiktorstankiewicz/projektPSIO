package AtakiInterfejs;

import Bron.Bron;
import Postacie.*;
import java.util.*;

public class ZabojcaAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postac P, Bron b) {
        Random generator = new Random();

        if (7 >= generator.nextInt(100)) {
            P.setHp(0);
        } else {
            AtakiInterfejs_I.zadajObrazenia(P, b);
        }
    }
}