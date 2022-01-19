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
	public void testAtakiLowca(){

	}

	@Test
	public void testAtakiMag(){

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
