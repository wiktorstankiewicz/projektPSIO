package testy;

import gra.model.Gra;
import gra.model.bron.maga.Rozdzka;
import gra.model.bron.woja.Mlot;
import gra.model.postacie.dystansowe.Mag;
import gra.model.postacie.wZwarciu.Wojownik;
import org.junit.jupiter.api.Assertions;

class GraTest {

    Mlot mlot;
    Wojownik przeciwnik;
    Rozdzka rozdzka;
    Mag gracz;
    Gra gra;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        mlot = new Mlot();
        przeciwnik = new Wojownik("Cowiek Maupa", mlot);

        rozdzka = new Rozdzka();
        gracz = new Mag("Lowca maup", rozdzka);

        gra = new Gra(gracz, przeciwnik);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

        mlot = null;
        przeciwnik = null;
        rozdzka = null;
        gracz = null;
        gra = null;
    }

    @org.junit.jupiter.api.Test
    void przygotujGre() {

        boolean test;
        if(gra.getMAX_DISTANCE()>=gra.getDistance()) test = true;
        else test = false;

        Assertions.assertTrue(test);
    }

    @org.junit.jupiter.api.Test
    void generujPrzeciwnik() {
        Assertions.assertNotNull(Gra.generujPrzeciwnik());
    }

    @org.junit.jupiter.api.Test
    void bitwa() {
        przeciwnik.setHp(0);
        gracz.setHp(0);
    }

    @org.junit.jupiter.api.Test
    void normalAttack() {
    }

    @org.junit.jupiter.api.Test
    void walkUpAction() {

        int distance = gra.getDistance();
        gra.setAkcja("null");
        gra.walkUpAction();

        if(gra.getDistance()!=0) {
            Assertions.assertNotEquals("null", gra.getAkcja());
            Assertions.assertEquals(distance, gra.getDistance()+1);
        }
    }

    @org.junit.jupiter.api.Test
    void damageFromFire() {
        int graczTestHP = gracz.getHp();
        int przeciwnikTestHP = przeciwnik.getHp();

        gracz.setCzyPodpalony(true);
        przeciwnik.setCzyPodpalony(true);

        gra.damageFromFire();

        Assertions.assertEquals(graczTestHP-5, gracz.getHp());
        Assertions.assertEquals(przeciwnikTestHP-5, przeciwnik.getHp());
    }

    @org.junit.jupiter.api.Test
    void zmianaAtaku() {
        int przeciwnikTestHP = przeciwnik.getHp();

        gra.zmianaAtaku(gracz, przeciwnik, mlot, 1);

        Assertions.assertNotEquals(przeciwnikTestHP, przeciwnik.getHp());
    }

    @org.junit.jupiter.api.Test
    void getGracz() {
        Assertions.assertNotNull(gra.getGracz());
    }

    @org.junit.jupiter.api.Test
    void getPrzeciwnik() {
        Assertions.assertNotNull(gra.getPrzeciwnik());
    }

    @org.junit.jupiter.api.Test
    void getTurn() {
        Assertions.assertFalse(gra.getTurn()<0);
    }

    @org.junit.jupiter.api.Test
    void getDistance() {
        Assertions.assertFalse(gra.getDistance()<0);
    }

    @org.junit.jupiter.api.Test
    void getAkcja() {
        gra.setAkcja("test");
        Assertions.assertEquals("test", gra.getAkcja());
    }

    @org.junit.jupiter.api.Test
    void getGRACZ_WYGRANA() {
        przeciwnik.setHp(0);
        gra.damageFromFire();
        Assertions.assertTrue(gra.getGRACZ_WYGRANA());
    }

    @org.junit.jupiter.api.Test
    void getPRZECIWNIK_WYGRANA() {
        gracz.setHp(0);
        gra.damageFromFire();
        Assertions.assertTrue(gra.getPRZECIWNIK_WYGRANA());
    }
}