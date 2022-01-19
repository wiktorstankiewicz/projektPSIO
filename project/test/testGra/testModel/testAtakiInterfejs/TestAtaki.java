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
		int hpCelu = cel.getHp();
		lowca.wykonajZwyklyAtak(cel, lowca.getBron());
		assertTrue(hpCelu > cel.getHp());
	}

	@Test
	public void testAtakiLowcaSpecjalny(){
		int hpCelu = cel.getHp();
		int i = 0;
		while(true){
			lowca.wykonajSpecjalnyAtak(cel, lowca.getBron());
			if (hpCelu > cel.getHp()) break;
			if (i > Short.MAX_VALUE) assertTrue(false);
		}
		assertTrue(hpCelu > cel.getHp());
	}

	@Test
	public void testAtakiMagZwykly(){
		int hpCelu = cel.getHp();
		mag.wykonajZwyklyAtak(cel, mag.getBron());
		assertTrue(hpCelu > cel.getHp());
	}

	@Test
	public void testAtakiMagSpecjalny(){
		int hpCelu = cel.getHp();
		int i = 0;
		while(true){
			mag.wykonajSpecjalnyAtak(cel, mag.getBron());
			if (hpCelu > cel.getHp()) break;
			if (i > Short.MAX_VALUE) assertTrue(false);
		}
		assertTrue(hpCelu > cel.getHp());
	}

	@Test
	public void testAtakiWojownikMiecz(){

	}

	@Test
	public void testAtakiWojownikMlot(){

	}

	@Test
	public void testAtakiZabojca(){

	}

}
