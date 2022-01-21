package testWyborPostaci.testController;


import gra.model.Gra;
import gra.model.bron.lowcy.Luk;
import gra.model.bron.maga.Rozdzka;
import gra.model.bron.woja.Miecz;
import gra.model.bron.woja.Mlot;
import gra.model.bron.zabojcy.Sztylet;
import gra.model.postacie.Postac;
import gra.model.postacie.dystansowe.Lowca;
import gra.model.postacie.dystansowe.Mag;
import gra.model.postacie.wZwarciu.Wojownik;
import gra.model.postacie.wZwarciu.Zabojca;
import kreatorPostaci.model.CreatorModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import wyborPostaci.controller.ControllerWyborPostaci;

import javax.swing.*;
import java.util.ArrayList;

public class TestControllerWyborPostaci {
    private ControllerWyborPostaci controllerWyborPostaci;
    private CreatorModel model;
    private ArrayList<Postac> postacie;

    @BeforeEach
    public void setUp() {
        model = new CreatorModel();
        controllerWyborPostaci = new ControllerWyborPostaci(model);
        postacie = new ArrayList<>();
        postacie.add(new Wojownik("name1", new Miecz()));
        postacie.add(new Wojownik("name2", new Mlot()));
        postacie.add(new Lowca("name3", new Luk()));
        postacie.add(new Zabojca("name4", new Sztylet()));
        postacie.add(new Mag("name5", new Rozdzka()));

    }

    @AfterEach
    public void tearDown() {
        model = null;
        controllerWyborPostaci = null;
        postacie = null;
    }

    @Test
    public void testDodajPostacDoListy() {
        for (Postac postac : postacie) {
            controllerWyborPostaci.dodajPostacDoListy(postac);
        }
        Assertions.assertEquals(postacie.size(), model.getPostacie().size());

        //sprawdzamy czy nie doda postaci podwojnie, gdy dana postac jest juz na liscie
        for (Postac postac : postacie) {
            controllerWyborPostaci.dodajPostacDoListy(postac);
        }
        Assertions.assertEquals(postacie.size(), model.getPostacie().size());

        //sprawdzamy czy nowa postac zostaje poprawnie dodana
        Postac nowaPostac = new Wojownik("testowy", new Mlot());
        controllerWyborPostaci.dodajPostacDoListy(nowaPostac);
        Assertions.assertEquals(nowaPostac, model.getPostacie().get(model.getPostacie().size()-1));
        Assertions.assertEquals(postacie.size()+1, model.getPostacie().size());
    }

    @Test
    public void testUsunPostacZListy(){
        for(Postac postac: postacie){
            model.getPostacie().add(postac);
            controllerWyborPostaci.usunPostacZListy(postac);
        }
        Assertions.assertEquals(0, model.getPostacie().size());

    }

    @Test
    public void testStworzPrzeciwnika(){
        JList<Postac> jList = new JList<>();
        DefaultListModel<Postac> listModel = new DefaultListModel<>();

        jList.setModel(listModel);
        listModel.addAll(postacie);

        Postac postac2;
        for(int i = 0; i<postacie.size(); i++){
            jList.setSelectedIndex(i);
            postac2 = controllerWyborPostaci.stworzPrzeciwnika(jList,1);
            Assertions.assertEquals(postac2,postacie.get(i));
        }
        Postac postac1 = controllerWyborPostaci.stworzPrzeciwnika(jList,0);
        Assertions.assertNotNull(postac1);
    }
}
