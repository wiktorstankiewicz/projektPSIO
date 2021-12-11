package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;

public class LowcaSpecjalnyAtak extends SpecjalnyAtak {
    @Override
    public void Atak(Postac p, Bron b) {
        if(SpecjalnyAtak.zadajDuzeObrazenia(p, b)) p.setCzyPodpalony(true);
    }
}
