package fr.whyt.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import fr.whyt.core.cast.MisterX;
import fr.whyt.core.cast.Player;
import fr.whyt.core.city.City;
import fr.whyt.core.city.Move;
import fr.whyt.main.Integers;
import fr.whyt.main.Main;

/**
 * Define a game with following params.<br>
 * Use {@linkplain Game.init} method to create a game with an unordered list of player
 * @param players the ordered list of player in a game
 * @param turns the list of moves for each turn
 */
public class Game {

	private final ArrayList<Player> players;
	private final HashMap<Integer, Move[]> turns;
	
	/**
	 * Set the game players and starting node
	 * @param players the ordered list of player in a game
	 * @param turns the list of moves for each turn
	 */
	private Game(ArrayList<Player> players, HashMap<Integer, Move[]> turns) {
		this.players = players;
		this.turns = turns;
	}
	
	/**
	 * Init the game with players. Set the Mister X player, the order and a random starting node.
	 * @param players
	 * @return the new {@link Game}
	 */
	public static Game init(Player... players) {
		Main.nb_players = players.length;
		ArrayList<Player> _players = new ArrayList<Player>(players.length);
		HashMap<Integer, Move[]> _turns = new HashMap<Integer, Move[]>(25);
		
		int mister_x = setMisterX(players);
		setOrder(_players, mister_x, players);
		setStartingNode(_players, _turns);
		
		return new Game(_players, _turns);
	}

	/**
	 * Define starting node for each players
	 * @param _players
	 * @param _turns
	 */
	private static void setStartingNode(ArrayList<Player> _players, HashMap<Integer, Move[]> _turns) {
		Move[] moves = new Move[_players.size()];
		ArrayList<Integer> point_used = new ArrayList<Integer>(_players.size());
		for(int i=0; i<_players.size(); i++) {
			int point = -1;
			while( point_used.contains((point = new Random().nextInt(City.MAX_NODE-1) + 1)) );
			point_used.add(point);
			moves[i] = new Move(Ticket.START, NodeFactory.get(Integers.requireBoundaryInt(point, 1, 200)));
		}
		_turns.put(0, moves);
	}

	/**
	 * Add players in order, first: Mister X, last: Detective prior to Mister X
	 * @param _players
	 * @param mister_x
	 * @param players
	 */
	private static void setOrder(ArrayList<Player> _players, int mister_x, Player... players) {
		for(int i=mister_x; i != mister_x-1; i=(i+1)%players.length) {
			_players.add(players[i]);
		}
		_players.add(players[mister_x-1]);
	}

	/**
	 * Define who is Mister X (the lowest number draw)
	 * @param players
	 * @return
	 */
	private static int setMisterX(Player... players) {
		int mister_x = -1;
		int min = City.MAX_NODE;
		for(int i=0; i<players.length; i++) {
			int tmp = min;
			min = Integer.min(min, new Random().nextInt(City.MAX_NODE-1) + 1); // 1 and City.MAX_NODE both included
			if(tmp != min) {
				mister_x = i;
			}
		}
		players[mister_x].setRole(new MisterX());
		return mister_x;
	}
	
	/**
	 * Return the player at position <b>i</b>.<br>
	 * Position is defined by order of play. Mister X is the first.
	 * @param i the index of the player (in play order)
	 * @return the player
	 */
	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	/**
	 * Return the list of move during the turn <b>turn</b>
	 * @param turn index of turn. Must be between 1 and 25.
	 * @return list of moves
	 */
	public Move[] getTurn(int turn) {
		return turns.get(turn);
	}
	
}
