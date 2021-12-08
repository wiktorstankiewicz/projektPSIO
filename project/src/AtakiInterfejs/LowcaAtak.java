package AtakiInterfejs;
import Bron.Bron;
import Postacie.*;

import java.util.Random;

public class LowcaAtak implements AtakiInterfejs_I{
    @Override
    public void Atak(Postac P, Bron b) {
        Random generator = new Random();
        P.setHp(P.getHp()-(generator.nextInt(b.getObrazeniaMax())+b.getObrazeniaMin()+1));

    }
}
