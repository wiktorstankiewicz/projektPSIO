package GraPackage;
import Bron.*;
import Bron.Lowcy.Luk;
import Bron.Maga.Rozdzka;
import Bron.Woja.Miecz;
import Bron.Woja.Mlot;
import Bron.Zabojcy.Sztylet;
import Grafika.WyborKlasy;
import Postacie.Dystansowe.Lowca;
import Postacie.Dystansowe.Mag;
import Postacie.Postac;
import Postacie.WZwarciu.Wojownik;
import Postacie.WZwarciu.Zabojca;



import java.util.Random;

public class Gra {

	//Constants
	private final int MAX_DISTANCE = 3;
	private final int GRACZ_WYGRANA = 0;
	private final int PRZECIWNIK_WYGRANA = 1;

	//Game fields
	static int playerCount = 2;
	private static final Postac[] postacie = new Postac[playerCount]; //player and random opponent
	private final String[] imiona = new String[playerCount];//their names, respectively
	private final Bron[] bronie = new Bron[playerCount]; //their weapons, respectively
	private static int firstTurn;
	private static int turn;
	private int distance;


	//Helper fields
	private Random generator= new Random();

	public void prepareGame(){
		firstTurn = generator.nextInt() % 2 + 1;
		distance = generator.nextInt() % MAX_DISTANCE + 1;

		imiona[0] = WyborKlasy.wybierzImie();

		String[] StringBronie = new String[playerCount];
		String[] StringPostaci = new String[playerCount];

		StringPostaci[0] = WyborKlasy.wybierzKlase();
		StringBronie[0] = WyborKlasy.wybierzBron(StringPostaci[0]);

		for(int i=1;i<StringPostaci.length;i++) {
			StringPostaci[1] = WyborKlasy.generujKlasaBot();
			StringBronie[1] = WyborKlasy.generujBronBot(StringPostaci[1]);
			imiona[i]= WyborKlasy.imieBota();
		}



		for (int i = 0; i < StringBronie.length; i++) {
			switch (StringBronie[i]) {
				case "Miecz":
					bronie[i] = new Miecz();
					break;

				case "Mlot":
					bronie[i] = new Mlot();
					break;

				case "Luk":
					bronie[i] = new Luk();
					break;

				case "Rozdzka":
					bronie[i] = new Rozdzka();
					break;
				case "Sztylet":
					bronie[i] = new Sztylet();
			}
		}

        for (int i = 0; i < StringBronie.length; i++) {
            switch (StringBronie[i]) {
                case "Wojownik":
                    postacie[i] = new Wojownik(imiona[i],"",bronie[i]);
                    break;
                case "Lowca":
                    postacie[i] = new Lowca(imiona[i],"",bronie[i]);
                    break;
                case "Zabojca":
                    postacie[i] = new Zabojca(imiona[i],"",bronie[i]);
                    break;
                case "Mag":
                    postacie[i] = new Mag(imiona[i],"",bronie[i]);
                    break;

            }

        }

		System.out.println(StringBronie[0] + "  " + StringBronie[1]);
		System.out.println(StringPostaci[0] + "  " + StringPostaci[1]);



		for (int i = 0; i < 2; i++) {
			System.out.println(bronie[i].getClass());
			System.out.println(imiona[i]);
		}
	}



	static public Postac getPrzeciwnik(){
		if (postacie[0] == null || postacie[1] == null){
			System.out.println("Postacie nie istnieja");
			turn++;
			return postacie[0];
		}
		else if (firstTurn == turn % 2){
			turn++;
			return postacie[0];
		}
		else {
			turn++;
			return postacie[1];
		}


	}

	/*
	private void bitwa(){
		if (postacie[0] == null || postacie[1] == null){
			System.out.println("Postacie nie istnieja");
			return;
		}
		if (firstTurn == turn % 2){
			atak(postacie[0]);
		}
		else {
			atak(postacie[1]);
		}
		turn++;
	}

	private void atak(Postac postac){
		postac.Atak(getPrzeciwnik()); //wywoluje metode interfejsu AtakiInterfejs_I
		checkForWinner();
	}
	 */

	//Podchodzi o x pol
	private void podejdz(int x){
		if (distance <= 0) return;

		distance = Math.max(distance-x, 0);
		turn++;
	}

	/**
	 * Checks whether one of the players has <= 0 hp
	 *     and assigns the winner appropriately
	 */
	private void checkForWinner(){
		if (postacie[0].getHp() <= 0){
			finishGame(PRZECIWNIK_WYGRANA);
		}

		if (postacie[1].getHp() <= 0){
			finishGame(GRACZ_WYGRANA);
		}
	}

	private void finishGame(int wygrany){
		if (wygrany == GRACZ_WYGRANA){
			System.out.println("Gratulacje! Wygrales!");
		}
		else if (wygrany == PRZECIWNIK_WYGRANA) {
			System.out.println("Niestey, nie udalo ci sie wygrac. Powodzenia nastepnym razem");
		}
	}
}