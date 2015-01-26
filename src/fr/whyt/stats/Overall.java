package fr.whyt.stats;

import java.util.HashMap;

import fr.whyt.main.Integers;

/**
 * @param stats the stats sorted by players quantity
 */
public class Overall {

	private final HashMap<Integer, Stat> stats;
	
	public Overall(HashMap<Integer, Stat> stats) {
		this.stats = stats;
	}
	
	public Stat getStat(int players) {
		return stats.get(Integers.requirePositiveOrNullInt(players));
	}
	
	/*
	 * General stats
	 */
	public int play() {
		return stats.values().stream().mapToInt(s -> s.getPlay()).sum();
	}
	
	/*
	 * Mister X stats
	 */
	public int misterXEfficience() {
		return misterXWin() * 100 / Integers.requireNonNullPositiveInt(play());
	}
	
	public int misterXWin() {
		return stats.values().stream().mapToInt(s -> s.getMisterXWin()).sum();
	}

	public int misterXLose() {
		return stats.values().stream().mapToInt(s -> s.getMisterXLose()).sum();
	}
	
	public double misterXWinLose() {
		return (double)misterXWin() / (double)misterXLose();
	}
	
	public int misterXMax() {
		return stats.values().stream().mapToInt(s -> s.getMisterXMax()).max().getAsInt();
	}
	
	public int misterXMin() {
		return stats.values().stream().mapToInt(s -> s.getMisterXMin()).min().getAsInt();
	}
	
	/*
	 * Detective stats
	 */
	public int detectiveEfficience() {
		return detectiveWin() * 100 / Integers.requireNonNullPositiveInt(play());
	}
	
	public int detectiveWin() {
		return stats.values().stream().mapToInt(s -> s.getDetectiveWin()).sum();
	}
		
	public int detectiveLose() {
		return stats.values().stream().mapToInt(s -> s.getDetectiveLose()).sum();
	}
	
	public double detectiveWinLose() {
		return (double)detectiveWin() / (double)detectiveLose();
	}
	
}
