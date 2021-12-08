package AtakiInterfejs;
import Bron.Bron;
import GraPackage.Gra;
import Postacie.*;

import java.util.Random;

public class MagAtak implements AtakiInterfejs_I{
    @Override
    public void Atak(Postac P, Bron b) {
        Random generator = new Random();

        int ArmorTMP = P.getPancerz();
        P.setPancerz(0);
        P.setHp(P.getHp()-generator.nextInt(b.getObrazeniaMax())+ b.getObrazeniaMin()+1);
        P.setPancerz(ArmorTMP);

    }
}
