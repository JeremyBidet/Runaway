package fr.whyt.core;

import java.util.ArrayList;

import fr.whyt.core.city.Node;

public class NodeFactory {

	private static final ArrayList<Node> nodes = new ArrayList<Node>(200);
	
	public static void create() {
		
	}
	
	public static Node get(int i) {
		return nodes.get(i);
	}
}
