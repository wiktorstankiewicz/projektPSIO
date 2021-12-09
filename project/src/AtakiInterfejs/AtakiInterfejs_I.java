package AtakiInterfejs;

import Bron.Bron;
import Postacie.Postac;
import java.util.Random;

public interface AtakiInterfejs_I {
    void Atak(Postac P, Bron b);//p to postac atakowana, b to bron atakującego

    static void zadajObrazenia(Postac P, Bron b) {

        Random generator = new Random();
        P.setHp(P.getHp() - (int)((generator.nextInt(b.getObrazeniaMax() - b.getObrazeniaMin()) + b.getObrazeniaMin() + 1)*(1-((double)P.getPancerz()/100.0))));
    }
}
