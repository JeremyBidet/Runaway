package fr.whyt.main;

import java.util.Scanner;

import fr.whyt.core.Game;
import fr.whyt.core.cast.Player;

public class Main {

	public static int nb_players = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("How many ? ");
		Main.nb_players = sc.nextInt();
		Player[] players = new Player[Main.nb_players];
		for(int i=0; i<Main.nb_players; i++) {
			System.out.println("Name : ");
			String name = sc.nextLine();
			players[i] = new Player(name);
		}
		
		Game game = Game.init("London", players);
		game.getPlayers().forEach(System.out::println);
		
		sc.close();
		
	}

}
