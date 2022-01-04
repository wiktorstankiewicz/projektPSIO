package gra.model.postacie.wZwarciu;

import gra.model.bron.Bron;
import gra.model.postacie.Postac;

import java.io.Serial;

abstract public class WZwarciu extends Postac
{
    @Serial
    private static final long serialVersionUID = -8368316357899515790L;

    public WZwarciu(String imie, Bron bron)
    {
        super(imie, bron);
    }
}
