package fr.whyt.core.city;

import java.util.ArrayList;
import java.util.Arrays;

import fr.whyt.core.Ticket;

public class Node {

	private final int node;
	private final ArrayList<Move> neighbors;

	public Node(int node, Move... moves) {
		this.node = node;
		this.neighbors = (ArrayList<Move>) Arrays.asList(moves);
	}

	public int getNode() {
		return node;
	}

	public ArrayList<Node> taxi() {
		return (ArrayList<Node>) Arrays.asList((Node[]) neighbors.stream().filter(m -> m.getWay() == Ticket.TAXI).toArray());
	}

	public ArrayList<Node> bus() {
		return (ArrayList<Node>) Arrays.asList((Node[]) neighbors.stream().filter(m -> m.getWay() == Ticket.BUS).toArray());
	}

	public ArrayList<Node> underground() {
		return (ArrayList<Node>) Arrays.asList((Node[]) neighbors.stream().filter(m -> m.getWay() == Ticket.UNDERGROUND).toArray());
	}
	
	public ArrayList<Node> boat() {
		return (ArrayList<Node>) Arrays.asList((Node[]) neighbors.stream().filter(m -> m.getWay() == Ticket.BOAT).toArray());
	}

}
