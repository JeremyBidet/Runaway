package fr.whyt.core.city;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class CityFactory {

	private static final HashMap<String, City> cities = new HashMap<String, City>();
	public static final int MAX_NODE = 200;
	
	public static void create() {
		Path dir = Paths.get("cities");
		Arrays.stream(dir.toFile().listFiles()).forEach((f) -> {
			String name = f.getName();
			if( name.matches(".+\\.city") ) {
				add("" + name.toUpperCase().charAt(0) + name.substring(1, name.length()-5));
			}
		});
	}
	
	private static void add(String name) {
		cities.put(name, NodeFactory.load(Objects.requireNonNull(name)));
	}
	
	public static City getCity(String name) {
		return cities.get(Objects.requireNonNull(name));
	}
	
	public static String availableCities() {
		return cities.keySet().toString();
	}
	
}
