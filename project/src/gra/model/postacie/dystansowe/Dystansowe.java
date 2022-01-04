package gra.model.postacie.dystansowe;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;

abstract public class Dystansowe extends Postac
{
    @Serial
    private static final long serialVersionUID = -6781486913079668206L;

    public Dystansowe(String imie, Bron bron)
    {
        super(imie, bron);
    }
}
