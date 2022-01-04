package wyborPostaci.controller;

import gra.model.Gra;
import gra.model.postacie.Postac;
import kreatorPostaci.model.ICreatorModel;
import wyborPostaci.WybierzGracza;
import wyborPostaci.WybierzPrzeciwnika;

import javax.swing.*;

public class ControllerWyborPostaci implements IControllerWyborPostaci {
    ICreatorModel model;
    WybierzGracza wyborGracza;
    WybierzPrzeciwnika wyborPrzeciwnika;

    public ControllerWyborPostaci(ICreatorModel model) {
        this.model = model;
        wyborGracza = new WybierzGracza(model, this);
    }

    public void dodajPostacDoListy(Postac postac) {
        if (!model.getPostacie().contains(postac))
            model.getPostacie().add(postac);
    }


    public void usunPostacZListy(Postac postac) {
        model.getPostacie().remove(postac);
    }

    public void wyswietlWyborPrzeciwnika(Postac gracz) {
        wyborGracza.dispose();
        wyborPrzeciwnika = new WybierzPrzeciwnika(model, this, gracz);
    }

    public Postac stworzPrzeciwnika(JList lista, int wybranaOpcja) {
        return wybranaOpcja == 0 ? Gra.generujPrzeciwnik() : (Postac) lista.getSelectedValue();
    }

    public void rozpocznijGre(Postac gracz, Postac przeciwnik) {
        wyborPrzeciwnika.dispose();
        new Thread(new Gra(gracz, przeciwnik)).start();
    }
}
