package com.techlabs.pigdice;

import java.util.Scanner;
import java.util.Random;

public class PigDiceGameCalisthenics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		PigDiceGameModel game = new PigDiceGameModel();
		
		while(game.getTotal_score() < 20) {
			play(game, scanner, random);
			System.out.println("Total Score: "+ game.getTotal_score()+"\n");
		}
		
		System.out.println("You finished in "+game.getNumber_of_turns()+ " turns.");
		System.out.println("\nGame Over!!");
		
		scanner.close();
	}

	private static void play(PigDiceGameModel game, Scanner scanner, Random random) {

			if(game.isNewTurn() == true) newTurn(game, scanner);
			
			String choice = rollOrHold(scanner);
			
			if(choice.equals("h")) {
				hold(game, scanner);
				return;
			}
				
			roll(game, scanner, random);
	}

	private static void hold(PigDiceGameModel game, Scanner scanner) {
		
				System.out.println("\nScore for turn: "+ game.getScore_for_current_turn());
				game.setNewTurn(true);
		
	}

	private static void roll(PigDiceGameModel game, Scanner scanner, Random random) {
		
				int die_number = random.nextInt(6)+1;
				System.out.println("Die: "+ die_number+"\n");
				
				if(die_number == 1) {
					endGame(game, scanner);
					return; 
				}
				
				addScore(die_number, game);
	}

	private static void addScore(int die_number, PigDiceGameModel game) {
		
					game.setTotal_score(game.getTotal_score()+ die_number);
					game.setScore_for_current_turn(game.getScore_for_current_turn() + die_number);
	}

	private static void endGame(PigDiceGameModel game, Scanner scanner) {
			
					game.setTotal_score(0);
					System.out.println("Turn Over. No Score\n");
					game.setNewTurn(true);
	}

	private static String rollOrHold(Scanner scanner) {
		
				System.out.print("Roll or hold?: (r/h) ");
				String roll_or_hold = scanner.next();
				return roll_or_hold;
		
	}

	private static void newTurn(PigDiceGameModel game, Scanner scanner) {
		
				game.setNumber_of_turns(game.getNumber_of_turns()+1);
				System.out.println("TURN "+ game.getNumber_of_turns() +"\n");
				game.setScore_for_current_turn(0);
				
				game.setNewTurn(false);
	}

}
