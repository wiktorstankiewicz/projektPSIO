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
	private int firstTurn;
	private int turn;
	private int distance;
	private String akcja;
	private int graczHp; //Hp z poprzedniej tury
	private int przeciwnikHp;

	private Frame GUI;

	public Gra(){

	}

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
		GUI = new Frame(this);

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
		GUI.inicjalizujEkranGry(this);

		while(!(GRACZ_WYGRANA || PRZECIWNIK_WYGRANA)) {

			graczHp=gracz.getHp();
			przeciwnikHp=przeciwnik.getHp();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (firstTurn == turn % 2) {

				if (distance > 0 && (gracz instanceof WZwarciu)) {
					distance--;
					setWykonanaAkcja(gracz.getImie()+" podszedł!");
				} else {
					gracz.Atak(przeciwnik, gracz.getBron());
					setWykonanaAkcja(gracz.getImie()+" zadał "+ (przeciwnikHp-przeciwnik.getHp()));
				}

				System.out.println(gracz.getImie()+": "+gracz.getHp());
				checkForWinner();
			} else {
				if (distance > 0 && (przeciwnik instanceof WZwarciu)) {
					distance--;
					setWykonanaAkcja(przeciwnik.getImie()+" podszedł!");
				}else {
					przeciwnik.Atak(gracz, przeciwnik.getBron());
					setWykonanaAkcja(przeciwnik.getImie()+" zadał "+ (graczHp-gracz.getHp()));
				}

				System.out.println("Przeciwnik"+przeciwnik.getHp());
				checkForWinner();
			}
			GUI.update(this);
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

	public String wykonanaAkcja(){
		return akcja;
	}
	public void setWykonanaAkcja(String akcja){
		this.akcja=akcja;
	}
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
			GUI.pokazKomunikatKoncowy(true);
		}
		else if (PRZECIWNIK_WYGRANA) {
			System.out.println("Niestey, nie udalo ci sie wygrac. Powodzenia nastepnym razem");
			GUI.pokazKomunikatKoncowy(false);
		}
	}

	public int getMAX_DISTANCE() {
		return MAX_DISTANCE;
	}

	public boolean isGRACZ_WYGRANA() {
		return GRACZ_WYGRANA;
	}
	public void setGRACZ_WYGRANA(boolean GRACZ_WYGRANA) {
		this.GRACZ_WYGRANA = GRACZ_WYGRANA;
	}

	public boolean isPRZECIWNIK_WYGRANA() {
		return PRZECIWNIK_WYGRANA;
	}

	public void setPRZECIWNIK_WYGRANA(boolean PRZECIWNIK_WYGRANA) {
		this.PRZECIWNIK_WYGRANA = PRZECIWNIK_WYGRANA;
	}

	public static int getPlayerCount() {
		return playerCount;
	}

	public static void setPlayerCount(int playerCount) {
		Gra.playerCount = playerCount;
	}

	public Postac getGracz() {
		return gracz;
	}

	public void setGracz(Postac gracz) {
		this.gracz = gracz;
	}

	public Postac getPrzeciwnik() {
		return przeciwnik;
	}

	public void setPrzeciwnik(Postac przeciwnik) {
		this.przeciwnik = przeciwnik;
	}

	public int getFirstTurn() {
		return firstTurn;
	}

	public void setFirstTurn(int firstTurn) {
		this.firstTurn = firstTurn;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Random getGenerator() {
		return generator;
	}

	public void setGenerator(Random generator) {
		this.generator = generator;
	}

	public String getAkcja() {
		return akcja;
	}

	public void setAkcja(String akcja) {
		this.akcja = akcja;
	}
}