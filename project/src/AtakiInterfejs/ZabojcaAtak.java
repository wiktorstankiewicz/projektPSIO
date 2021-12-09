package AtakiInterfejs;
import Bron.Bron;
import Postacie.*;
import java.util.*;

public class ZabojcaAtak implements AtakiInterfejs_I {
    @Override
    public void Atak(Postac P, Bron b) {
        Random generator = new Random();

        if (10 >= generator.nextInt(100)) {
            P.setHp(0);
        } else {
            P.setHp(P.getHp()-(generator.nextInt(b.getObrazeniaMax()-b.getObrazeniaMin())+b.getObrazeniaMin()+1));
        }
    }
}