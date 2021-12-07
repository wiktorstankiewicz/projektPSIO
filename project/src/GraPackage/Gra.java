package GraPackage;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Gra {
	//Constants
	private final String GAME_NAME = "Gra PSiO"; //frame label
	private final int FRAME_X = 200; //frame size
	private final int FRAME_Y = 200;

	//GUI fields
	private JFrame mainFrame;
	private JPanel mainPanel;

	//Game fields
	private Postac player1; //user player
	private Postac player2; //randomly generated opponent
	private int firstTurn;
	private int turn;
	private int distance;

	//Helper fields
	private Random generator;

	Gra(){
		generator = new Random();
	}

	public static void main(String [] args){
		Gra gra = new Gra();
		gra.init();
		gra.start();
	}

	private void init(){
		makeGUI();
		prepareGame();
	}

	//todo GUI
	private void makeGUI(){
		mainFrame = new JFrame(GAME_NAME);
		mainPanel = new JPanel();
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setSize(new Dimension(FRAME_X, FRAME_Y));


		mainFrame.setVisible(true);
	}

	//todo prepare players and random game values
	private void prepareGame(){
		generatePlayers();

		//randomly select who goes first (1 -> player1, 2 -> player2)
		firstTurn = generator.nextInt() % 2 + 1;
	}

	//todo generate players
	private void generatePlayers(){

	}

	//todo game logic
	private void start(){
		if (player1 == null || null == player2){
			System.out.println("Players not loaded, cannot start the game");
			return;
		}



		Postac winner = null;

		while(winner == null){
			turn();


			winner = checkForWinner();
		}
		finishGame(winner);
	}

	private void turn(){
		//firstTurn == 1 -> player1 goes first
		//firstTurn == 2 -> player2 goes first
		//so on turn == 1, then (turn % 2) == 1   =>   player1 should play
		//otherwise player2 plays
		if (firstTurn == turn % 2){
			turn(player1);
		}
		else {
			turn(player2);
		}
	}

	//todo turn logic
	private void turn(Postac player){

	}

	/**
	 * Checks whether one of the players has <= 0 hp
	 * 	and assigns the winner appropriately
	 *
	 * 	If both players are still standing returns null
	 *
	 * @return winner or null (if none exists)
	 */
	private Postac checkForWinner(){
		if (player1.getHP() <= 0){
			return player2;
		}

		if (player2.getHP() <= 0){
			return player1;
		}

		return null;
	}

	//todo finishGame method
	private void finishGame(Postac winner){

	}
}
