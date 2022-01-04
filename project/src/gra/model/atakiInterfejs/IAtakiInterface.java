package gra.model.atakiInterfejs;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

public interface IAtakiInterface
{
    void Atak(Postac p, Bron b);//p to postac atakowana, b to bron atakującego
}
