package fr.whyt.core.city;

import fr.whyt.core.Ticket;

public class Move {

	private final Ticket way;
	private final Node node;
	
	public Move(Ticket way, Node node) {
		this.way = way;
		this.node = node;
	}

	public Ticket getWay() {
		return way;
	}
	
	public Node getNode() {
		return node;
	}
	
}
