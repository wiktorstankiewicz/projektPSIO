package AtakiInterfejs;
import Bron.Bron;
import Postacie.*;
import java.util.*;

public class WojownikAtak implements AtakiInterfejs_I{
    @Override
    public void Atak(Postac P, Bron b) {
        Random generator = new Random();
        if(20 < generator.nextInt(100))
        {
            P.setHp(P.getHp()-generator.nextInt(b.getObrazeniaMax())+b.getObrazeniaMin()+1);
        }
            P.setHp(P.getHp()-generator.nextInt(b.getObrazeniaMax())+1);
    }
    }