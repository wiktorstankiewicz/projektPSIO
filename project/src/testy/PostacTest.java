package testy;

import gra.model.atakiInterfejs.WojownikSpecjalnyAtak;
import gra.model.atakiInterfejs.WojownikZwyklyAtak;
import gra.model.bron.lowcy.Luk;
import gra.model.bron.woja.Miecz;
import gra.model.postacie.dystansowe.Lowca;
import gra.model.postacie.wZwarciu.Wojownik;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostacTest {

    Wojownik testowy_wojownik;
    Miecz miecz;

    @BeforeEach
    void setUp() {
        miecz = new Miecz();
        testowy_wojownik = new Wojownik("Obiekt testowy", miecz);
    }

    @AfterEach
    void tearDown() {
        testowy_wojownik = null;
    }

    @Test
    void wykonajZwyklyAtak() {
        Lowca testowy_lowca = new Lowca("Bede bity", new Luk());

        int testHP = testowy_lowca.getHp();
        testowy_wojownik.wykonajZwyklyAtak(testowy_lowca, miecz);

        Assertions.assertNotEquals(testHP, testowy_lowca.getHp());
    }

    @Test
    void getStan() {
        Assertions.assertEquals("Wojownik: Obiekt testowy\nHP: 150\nPancerz: 50\nCzy podpalony: false", testowy_wojownik.getStan());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Wojownik: Obiekt testowy, HP: 150, Pancerz: 50", testowy_wojownik.toString());
    }

    @Test
    void setHp() {
        testowy_wojownik.setHp(10);
        Assertions.assertEquals(testowy_wojownik.getHp(), 10);
    }

    @Test
    void setPancerz() {
        testowy_wojownik.setPancerz(10);
        Assertions.assertEquals(testowy_wojownik.getPancerz(), 10);
    }

    @Test
    void getImie() {
        Assertions.assertEquals("Obiekt testowy", testowy_wojownik.getImie());
    }

    @Test
    void getImageFilePath() {
        Assertions.assertEquals("project/resources/img/wojownik.png", testowy_wojownik.getImageFilePath());
    }

    @Test
    void getHp() {
        Assertions.assertEquals(150, testowy_wojownik.getHp());
    }

    @Test
    void getPancerz() {
        Assertions.assertEquals(50, testowy_wojownik.getPancerz());
    }

    @Test
    void getBron() {
        Assertions.assertEquals(miecz, testowy_wojownik.getBron());
    }

    @Test
    void setCzyPodpalony() {
        testowy_wojownik.setCzyPodpalony(true);
        Assertions.assertTrue(testowy_wojownik.getCzyPodpalony());
    }

    @Test
    void getCzyPodpalony() {
        Assertions.assertFalse(testowy_wojownik.getCzyPodpalony());
    }

    @Test
    void getZwyklyAtak() {
        boolean testBoolean;

        if(testowy_wojownik.getZwyklyAtak() instanceof WojownikZwyklyAtak) testBoolean = true;
        else testBoolean = false;

        Assertions.assertTrue(testBoolean);
    }

    @Test
    void getSpecjalnyAtak() {
        boolean testBoolean;
        if(testowy_wojownik.getSpecjalnyAtak() instanceof WojownikSpecjalnyAtak) testBoolean = true;
        else testBoolean = false;

        Assertions.assertTrue(testBoolean);
    }
}