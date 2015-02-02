package fr.whyt.core.city;

import java.util.HashMap;


public class NodePattern {

	private final HashMap<Integer, Move[]> nodes;
	
	public NodePattern() {
		nodes = new HashMap<Integer, Move[]>();
	}
	
	public void add(Integer i, Move[] moves) {
		nodes.put(i, moves);
	}
	
	public int length() {
		return nodes.size();
	}

	public int getNode(int i) {
		return ((Integer) nodes.keySet().toArray()[i]).intValue();
	}

	public Move[] getNeighbors(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
