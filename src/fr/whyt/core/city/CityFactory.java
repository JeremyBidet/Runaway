package fr.whyt.core.city;

import java.util.HashMap;
import java.util.Objects;

public class CityFactory {

	private static final HashMap<String, City> cities = new HashMap<String, City>();
	public static final int MAX_NODE = 200;
	
	public static void create() {
		add("London");
		/*
		add("Paris");
		add("Tokyo");
		add("New York");
		*/
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
