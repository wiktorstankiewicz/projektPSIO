package GraPackage;
import Bron.*;
import Bron.Lowcy.Luk;
import Bron.Maga.Rozdzka;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.Sztylet;
import Grafika.Frame;
import Grafika.WyborKlasy;
import Postacie.Dystansowe.Lowca;
import Postacie.Dystansowe.Mag;
import Postacie.Postac;
import Postacie.WZwarciu.WZwarciu;
import Postacie.WZwarciu.Wojownik;
import Postacie.WZwarciu.Zabojca;



import java.util.Random;

public class Gra {

	//Constants
	private final int MAX_DISTANCE = 5;
	private boolean GRACZ_WYGRANA = false;
	private boolean PRZECIWNIK_WYGRANA = false;

	//Game fields
	static int playerCount = 2;
	private Postac gracz;
	private Postac przeciwnik;
	private static int firstTurn;
	private static int turn;
	private int distance;


	//Helper fields
	private Random generator= new Random();

	public void prepareGame(){
		firstTurn = generator.nextInt(1)+1  ;
		distance = generator.nextInt(MAX_DISTANCE) + 1;

		String wybraneImie = WyborKlasy.wybierzImie();
		String wybranaPostac = WyborKlasy.wybierzPostac();
		String wybranaBron = WyborKlasy.wybierzBron(wybranaPostac);
		gracz = WyborKlasy.stworzPostac(wybranaPostac,wybraneImie,wybranaBron);

		String wylosowanaPostacPrzeciwnika = WyborKlasy.generujKlasaBot();
		String wylosowanaBronPrzeciwnika = WyborKlasy.generujBronBot(wylosowanaPostacPrzeciwnika);
		String wylosowaneImiePrzeciwnika = WyborKlasy.generujImieBota();
		przeciwnik = WyborKlasy.stworzPostac(wylosowanaPostacPrzeciwnika,wylosowaneImiePrzeciwnika,wylosowanaBronPrzeciwnika);


	}

//	private void wyswietlMenuWyboru(String[] StringBronie, String[] StringPostaci) {
//	static public Postac getPrzeciwnik(){
//		if (postacie[0] == null || postacie[1] == null){
//			System.out.println("Postacie nie istnieja");
//			turn++;
//			return postacie[0];
//		}
//		else if (firstTurn == turn % 2){
//			turn++;
//			return postacie[0];
//		}
//		else {
//			turn++;
//			return postacie[1];
//		}
//
//
//	}


	public void bitwa(){
		if (gracz == null || przeciwnik == null){
			System.out.println("Postacie nie istnieja");
			return;
		}
		while(!(GRACZ_WYGRANA || PRZECIWNIK_WYGRANA)) {

			if (firstTurn == turn % 2) {

				if (distance > 0 && (gracz instanceof WZwarciu)) {
					distance--;
					System.out.println("Podszedles!");

				} else gracz.Atak(przeciwnik, gracz.getBron());

				System.out.println(gracz.getImie()+": "+gracz.getHp());
				checkForWinner();
			} else {
				if (distance > 0 && (przeciwnik instanceof WZwarciu)) {
					distance--;
					System.out.println("Przeciwnik podszedl!");
				}else przeciwnik.Atak(gracz, przeciwnik.getBron());

				System.out.println("Przeciwnik"+przeciwnik.getHp());
				checkForWinner();
			}

			System.out.println("\nDystans: "+distance);
			turn++;
		}
	}

//	private void wykonajAkcje(Postac postac){
//		postac.Atak(getPrzeciwnik()); //wywoluje metode interfejsu AtakiInterfejs_I
//		checkForWinner();

//	}


	/*//Podchodzi o x pol
	private void podejdz(Postac p){
		if (distance <= 0 || (p instanceof WZwarciu)) {
			distance--;
		}
	}*/

	public void gracz_typ(){
		System.out.println(gracz.getClass()+"   "+przeciwnik.getClass());
	}

	/**
	 * Checks whether one of the players has <= 0 hp
	 *     and assigns the winner appropriately
	 */
	private void checkForWinner(){
		if (gracz.getHp() <= 0){
			PRZECIWNIK_WYGRANA=true;
			finishGame(PRZECIWNIK_WYGRANA);
		}

		if (przeciwnik.getHp() <= 0){
			GRACZ_WYGRANA=true;
			finishGame(GRACZ_WYGRANA);
		}
	}

	private void finishGame(boolean wygrany){
		if (GRACZ_WYGRANA){
			System.out.println("Gratulacje! Wygrales!");
		}
		else if (PRZECIWNIK_WYGRANA) {
			System.out.println("Niestey, nie udalo ci sie wygrac. Powodzenia nastepnym razem");
		}
	}


}