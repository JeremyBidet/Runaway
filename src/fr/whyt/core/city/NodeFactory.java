package fr.whyt.core.city;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class NodeFactory {

	private static ArrayList<Node> create(NodePattern pattern) {
		ArrayList<Node> nodes = new ArrayList<Node>(pattern.length());
		for(int i=0; i<pattern.length(); i++) {
			nodes.add(new Node(pattern.getNode(i), pattern.getNeighbors(i)));
		}
		return nodes;
	}

	public static City load(String name) {
		// TODO Auto-generated method stub
		// find <name>.city in cities directory and load pattern
		Path path = Paths.get(Objects.requireNonNull(name));
		path.toFile();
		
		NodePattern pattern = new NodePattern();
		return new City(create(pattern));
	}
	
}
