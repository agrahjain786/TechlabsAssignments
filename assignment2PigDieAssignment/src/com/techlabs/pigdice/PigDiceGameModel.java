package com.techlabs.pigdice;

public class PigDiceGameModel {
	
	private int total_score;
	private int number_of_turns;
	private int score_for_current_turn;
	private boolean isNewTurn;
	
	
	
	public PigDiceGameModel() {
		super();
		this.total_score = 0;
		this.number_of_turns = 0;
		this.score_for_current_turn = 0;
		this.isNewTurn = true;
	}

	public int getTotal_score() {
		return total_score;
	}
	
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	
	public int getNumber_of_turns() {
		return number_of_turns;
	}
	
	public void setNumber_of_turns(int number_of_turns) {
		this.number_of_turns = number_of_turns;
	}
	
	public int getScore_for_current_turn() {
		return score_for_current_turn;
	}
	
	public void setScore_for_current_turn(int score_for_current_turn) {
		this.score_for_current_turn = score_for_current_turn;
	}
	
	public boolean isNewTurn() {
		return isNewTurn;
	}
	
	public void setNewTurn(boolean isNewTurn) {
		this.isNewTurn = isNewTurn;
	}

}
