package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public class LowcaSpecjalnyAtak extends SpecjalnyAtak {
    @Override
    public void atak(Postac p, Bron b) {
        if (zadajDuzeObrazenia(p, b)) p.setCzyPodpalony(true);
    }
}
