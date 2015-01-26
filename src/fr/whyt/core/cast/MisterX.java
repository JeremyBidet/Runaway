package fr.whyt.core.cast;

import fr.whyt.core.Ticket;
import fr.whyt.main.Main;

public class MisterX extends Role {

	public MisterX() {
		super(4, 3, 2);
		tickets.put(Ticket.BLACK, Main.nb_players);
		tickets.put(Ticket.X2, 2);
	}
	
}
