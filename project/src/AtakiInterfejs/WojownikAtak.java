package AtakiInterfejs;

import Bron.Bron;
import Postacie.*;
import java.util.*;

public class WojownikAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postac P, Bron b) {
        Random generator = new Random();
        if (20 >= generator.nextInt(100)) {
            AtakiInterfejs_I.zadajObrazenia(P, b);
        }
        AtakiInterfejs_I.zadajObrazenia(P, b);
    }
}