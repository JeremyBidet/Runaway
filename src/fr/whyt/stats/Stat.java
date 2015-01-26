package fr.whyt.stats;

import fr.whyt.main.Integers;

/**
 * @param play
 *            the number of game played
 * @param win
 *            the number of game won by Mister X
 * @param lose
 *            the number of game lost by Mister X
 * 
 * @param max
 *            the max moves of Mister X
 * @param min
 *            the min moves of Mister X
 */
public class Stat {

	private int play, win, lose, max, min;

	public Stat(int play, int win, int lose, int max, int min) {
		this.play = play;
		this.win = win;
		this.lose = lose;
		this.max = max;
		this.min = min;
	}

	/*
	 * Getters
	 */
	public int getPlay() {
		return play;
	}

	public int getMisterXWin() {
		return win;
	}
	
	public int getDetectiveWin() {
		return lose;
	}

	public int getMisterXLose() {
		return lose;
	}
	
	public int getDetectiveLose() {
		return win;
	}

	public int getMisterXMax() {
		return max;
	}

	public int getMisterXMin() {
		return min;
	}
	
	/*
	 * Setters
	 */
	public void addWin() {
		play++;
		win++;
	}
	
	public void addLose() {
		play++;
		lose++;
	}
	
	public void setMax(int max) {
		this.max = max < this.max ? this.max : Integers.requireBoundaryInt(max, 1, 24);
	}
	
	public void setMin(int min) {
		this.min = min < this.min ? this.min : Integers.requireBoundaryInt(min, 1, 24);
	}
	
}
