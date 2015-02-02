package fr.whyt.core.city;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.whyt.core.Ticket;

public class NodeFactory {

	private static ArrayList<Node> create(NodePattern pattern) {
		ArrayList<Node> nodes = new ArrayList<Node>(pattern.length());
		for(int i=0; i<pattern.length(); i++) {
			nodes.add(new Node(pattern.getNode(i), pattern.getNeighbors(i)));
		}
		return nodes;
	}

	protected static City load(String name) {
		NodePattern np = new NodePattern();
		
		String tick_regex =
				"("
				+ Arrays.stream(Ticket.values())
						.map((t) -> t.name())
						.reduce((s1, s2) -> String.join("|", s1, s2)).get()
				+ ")";
		String move_regex = "(?<move> \\((?<ticket>" + tick_regex + "*) (?<dest>\\d+)\\))";
		String main_regex = "(?<node>\\d+)(?<moves>" + move_regex + "+)";
		
		Path path = Paths.get("cities/" + Objects.requireNonNull(name));
		Pattern main_p = Pattern.compile(main_regex);
		Pattern move_p = Pattern.compile(move_regex);
		
		try(BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
			br.lines().allMatch((s) -> main_p.matcher(s).matches());
			br.lines().forEach((s) -> {
				Matcher main_m = main_p.matcher(s);
				if(main_m.matches()) {
					Matcher move_m = move_p.matcher(main_m.group("moves"));
					ArrayList<Move> moves = new ArrayList<Move>();
					while(move_m.find()) {
						moves.add(new Move(
								Ticket.valueOf(Ticket.class, move_m.group("ticket")),
								new Node(Integer.parseInt(move_m.group("dest")))));
					}
					np.add(
							Integer.parseInt(main_m.group("node")),
							(Move[]) moves.toArray());
				} else {
					throw new IllegalStateException("line " + s + " does not match with the pattern !");
				}
			});
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Cannot open file " + name);
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println("Failed to read file " + name);
		}
		
		return new City(create(np));
	}
	
}
