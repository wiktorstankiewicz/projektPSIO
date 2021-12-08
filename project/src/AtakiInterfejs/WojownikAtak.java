package AtakiInterfejs;
import Postacie.*;
import java.util.*;

public class WojownikAtak implements AtakiInterfejs_I{
    @Override
    public void Atak(Postac P) {
        Random los = new Random();
        if(20 < los.nextInt(100))
        {
            P.ZadajObrazenia();
        }
            P.ZadajObrazenia();
    }
    }