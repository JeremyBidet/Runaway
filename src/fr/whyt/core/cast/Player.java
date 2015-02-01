package fr.whyt.core.cast;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import fr.whyt.core.Game;
import fr.whyt.main.Integers;
import fr.whyt.stats.Stat;

public class Player {

	private final String name;
	private Role role;
	private Stat stat;
	private HashMap<Date, Game> history;
	
	/**
	 * New player with 0 stats
	 * @param name player name
	 */
	public Player(String name) {
		this(Objects.requireNonNull(name), 0, 0, 0, 0, 0);
	}
	
	/**
	 * Set an existing player
	 * @param name player name
	 * @param win game won
	 * @param lose game lost
	 */
	public Player(String name, int play, int win, int lose, int max, int min) {
		this.name = Objects.requireNonNull(name);
		stat = new Stat(Integers.requirePositiveOrNullInt(play), 
				Integers.requirePositiveOrNullInt(win),
				Integers.requirePositiveOrNullInt(lose),
				Integers.requireBoundaryInt(max, 1, 24),
				Integers.requireBoundaryInt(min, 1, 24));
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = Objects.requireNonNull(role);
	}
	
	public String getName() {
		return name;
	}
	
	public Stat getStat() {
		return stat;
	}
	
	public Game getHistory(Date date) {
		return history.get(date);
	}
	
}
