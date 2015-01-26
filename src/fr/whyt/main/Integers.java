package fr.whyt.main;

public class Integers {

	/**
	 * Check if <b>x</b> is a positive or null integer.
	 * @param x the integer to check
	 * @return <b>x</b> if positive or null, else throw an {@link IllegalArgumentException}
	 */
	public static int requirePositiveOrNullInt(int x) {
		if(x < 0)
			throw new IllegalArgumentException(x + " must be a positive or null integer");
		return x;
	}
	
	/**
	 * Check if <b>x</b> is a non null positive integer.
	 * @param x the integer to check
	 * @return <b>x</b> if non null positive, else throw an {@link IllegalArgumentException}
	 */
	public static int requireNonNullPositiveInt(int x) {
		if(x <= 0)
			throw new IllegalArgumentException(x + " must be a non null positive integer");
		return x;
	}
	
	/**
	 * Check if <b>x</b> is between <b>min</b> included and <b>max</b> included.
	 * @param x the integer to check
	 * @param min boundary
	 * @param max boundary
	 * @return <b>x</b> if in interval, else throw an {@link IllegalArgumentException}
	 */
	public static int requireBoundaryInt(int x, int min, int max) {
		if(x < min || x > max)
			throw new IllegalArgumentException(x + " must be between " + min + " included and " + max + " included");
		return x;
	}
	
}
