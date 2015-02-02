package fr.whyt.core.city;

import java.util.ArrayList;

public class City {
	
	private final ArrayList<Node> nodes;
	
	public City(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public Node getNode(int i)  {
		return nodes.get(i);
	}
	
}
