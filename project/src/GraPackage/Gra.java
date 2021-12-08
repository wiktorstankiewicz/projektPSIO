package GraPackage;



import Postacie.Postac;

import java.util.Random;

public class Gra {
	//Constants
	private final int MAX_DISTANCE = 5;
	private final int GRACZ_WYGRANA = 0;
	private final int PRZECIWNIK_WYGRANA = 1;

	//Game fields
	private Postac wybranaPostac; //user player
	private Postac przeciwnik; //randomly generated opponent
	private int firstTurn;
	private int turn;
	private int distance;

	//Helper fields
	private Random generator;

	private void prepareGame(){
		firstTurn = generator.nextInt() % 2 + 1;
		distance = generator.nextInt() % MAX_DISTANCE + 1;
	}

	private void atak(){
		if (wybranaPostac == null || przeciwnik == null){
			System.out.println("Postacie nie istnieja");
			return;
		}
		if (firstTurn == turn % 2){
			atak(wybranaPostac);
		}
		else {
			atak(przeciwnik);
		}
		turn++;
	}

	private void atak(Postac postac){
		postac.WykonajAtak(); //wywoluje metode interfejsu AtakiInterfejs_I
		checkForWinner();
	}

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
		if (wybranaPostac.getHp() <= 0){
			finishGame(PRZECIWNIK_WYGRANA);
		}

		if (przeciwnik.getHp() <= 0){
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