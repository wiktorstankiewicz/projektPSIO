package testGra.testModel.testAtakiInterfejs;

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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAtaki {
	private static Postac lowca;
	private static Postac mag;
	private static Postac wojownikMiecz;
	private static Postac wojownikMlot;
	private static Postac zabojca;
	private static Postac cel;

	@BeforeAll
	public static void init(){
		lowca = new Lowca("Lowca", new Luk());
		mag = new Mag("Mag", new Rozdzka());
		wojownikMiecz = new Wojownik("Wojownik Miecz", new Miecz());
		wojownikMlot = new Wojownik("Wojownik Mlot", new Mlot());
		zabojca = new Zabojca("Zabojca", new Sztylet());
	}

	@BeforeEach
	public void setupCel(){
		cel = new Lowca("Cel", new Luk());
	}

	@Test
	public void testAtakiLowcaZwykly(){
		//given
		int hpCelu = cel.getHp();
		//when
		lowca.wykonajZwyklyAtak(cel, lowca.getBron());
		//then
		assertTrue(	hpCelu > cel.getHp());
	}

	@Test
	public void testAtakiLowcaSpecjalny(){
		//given
		int hpCelu = cel.getHp();
		int i = 0;
		//when
		while(true){
			lowca.wykonajSpecjalnyAtak(cel, lowca.getBron());
			if (hpCelu > cel.getHp()) break;
			if (i > Short.MAX_VALUE) assertTrue(false);
		}
		//then
		assertTrue(hpCelu > cel.getHp());
	}


	@Test
	public void testAtakiMagZwykly(){
		//given
		int hpCelu = cel.getHp();
		//when
		mag.wykonajZwyklyAtak(cel, mag.getBron());
		//then
		assertTrue(hpCelu > cel.getHp());
	}

	@Test
	public void testAtakiMagSpecjalny(){
		//given
		int hpCelu = cel.getHp();
		int i = 0;
		//when
		while(true){
			mag.wykonajSpecjalnyAtak(cel, mag.getBron());
			if (hpCelu > cel.getHp()) break;
			if (i > Short.MAX_VALUE) assertTrue(false);
		}
		//then
		assertTrue(hpCelu > cel.getHp());
	}

	@Test
	public void testAtakiWojownikMieczZwykly(){
        //given
		int przeciwnikTestHP = cel.getHp();
        //when
		wojownikMiecz.wykonajZwyklyAtak(cel, wojownikMiecz.getBron());
        //then
		Assertions.assertTrue(cel.getHp() < przeciwnikTestHP);
    }

    @Test
	public void testAtakiWojownikMieczSpecjalny(){
		//given
		int hpCelu = cel.getHp();
		int i = 0;
		//when
		while(true){
			wojownikMiecz.wykonajSpecjalnyAtak(cel, wojownikMiecz.getBron());
			if (hpCelu > cel.getHp()) break;
			if (i > Short.MAX_VALUE) assertTrue(false);
		}
		//then
		assertTrue(hpCelu > cel.getHp());
    }

	@Test
	public void testAtakiWojownikMlotZwykly(){
		//given
		int przeciwnikTestHP = cel.getHp();
		//when
		wojownikMlot.wykonajZwyklyAtak(cel, wojownikMlot.getBron());
		//then
		Assertions.assertTrue(cel.getHp() < przeciwnikTestHP);
    }

	@Test
	public void testAtakiWojownikMlotSpecjalny(){
		//given
		int hpCelu = cel.getHp();
		int i = 0;
		//when
		while(true){
			wojownikMlot.wykonajSpecjalnyAtak(cel, wojownikMlot.getBron());
			if (hpCelu > cel.getHp()) break;
			if (i > Short.MAX_VALUE) assertTrue(false);
		}
		//then
		assertTrue(hpCelu > cel.getHp());
	}

	@Test
	public void testAtakiZabojcaZwykly(){
		//given
		int przeciwnikTestHP = cel.getHp();
		//when
		zabojca.wykonajZwyklyAtak(cel, zabojca.getBron());
		//then
		Assertions.assertTrue(cel.getHp() < przeciwnikTestHP);
    }

    @Test
	public void testAtakiZabojcaSpecjalny(){
		//given
		int hpCelu = cel.getHp();
		int i = 0;
		//when
		while(true){
			zabojca.wykonajSpecjalnyAtak(cel, zabojca.getBron());
			if (hpCelu > cel.getHp()) break;
			if (i > Short.MAX_VALUE) assertTrue(false);
		}
		//then
		assertTrue(hpCelu > cel.getHp());
	}


}
