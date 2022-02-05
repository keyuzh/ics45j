package labs.lab10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class for performing various analyses on a set of airport data
 *
 */
public class AirportsStats {

	/**
	 * Given a Stream of Airports and the name of a country, return a list of
	 * airports in that country, sorted in ascending lexicographic order by airport
	 * name
	 */
	public static List<Airport> problem1_getAirportsInCountry(Stream<Airport> airports, String country) {
		return airports.filter(airport -> airport.getCountry().equals(country)).sorted().collect(Collectors.toList());
	}


	/**
	 * Given a Stream of airports and an altitude range, return a String that
	 * contains the names of all airports within that altitude range (inclusive),
	 * ordered lexicographically, each name separated by ", "
	 */
	public static String problem2_getAllAirportsInAltitudeRange(Stream<Airport> airports, double minAltitude,
			double maxAltitude) {
		return airports.filter(a -> a.getAltitude() >= minAltitude && a.getAltitude() <= maxAltitude)
				.map(Airport::getName).sorted().collect(Collectors.joining(", "));
	}


	/**
	 * Given a Stream of airports and an integer n, return a list of the names of
	 * the top n cities with the most airports, sorted in descending order by number
	 * of airports. Ignore blank city names.
	 * 
	 * If there are < n cities represented in the stream, return them all, sorted in
	 * descending order by number of airports.
	 * 
	 * If 2 or more cities in the stream have the same number of airports, the order
	 * is undetermined.
	 * 
	 */
	public static List<String> problem3_getTopNCitiesWithMostAirports(Stream<Airport> airports, int n) {
		Map<String, Long> airportCount = airports.filter(a->!a.getCity().isEmpty()).collect(Collectors.groupingBy(Airport::getCity, Collectors.counting()));
		return airportCount.keySet().stream().toList().stream().sorted((x, y) -> (int) (airportCount.get(y) - airportCount.get(x))).limit(n).collect(Collectors.toList());
	}


	/**
	 * Given a Stream of Airports, return the number of different cities represented
	 * in the stream. Do not count blank city names.
	 */
	public static long problem4_countCities(Stream<Airport> airports) {
		return airports.map(Airport::getCity).filter(c->!c.isEmpty()).distinct().count();
	}


	/**
	 * Given a Stream of airports and a string, return the first airport found in
	 * the stream whose name contains that string (case-insensitive).
	 * 
	 * If no airport name contains the string, or the stream is empty, return an
	 * empty Optional<Airport>
	 */
	public static Optional<Airport> problem5_getFirstAirportContainingString(Stream<Airport> airports, String str) {
		return airports.filter(a -> a.getName().toLowerCase().contains(str.toLowerCase())).findFirst();
	}


	/**
	 * Given a Stream of airports, a set of coordinates, and an int n, return a list
	 * of the names of the top n airports closest to those coordinates, sorted by
	 * distance from the coordinates (ascending).
	 * 
	 * If two airports are the same distance away, the order in which they appear in
	 * the list in relation to each other doesn't matter.
	 * 
	 * Hint: Use the Coordinates.distance method to calculate distance.
	 */
	public static List<String> problem6_getTopNAirportsClosestTo(Stream<Airport> airports, Coordinates coordinates,
			int n) {
		return airports.sorted((x, y) ->
				(int) (Coordinates.distance(x.getCoordinates().latitude, x.getCoordinates().longitude, coordinates.latitude, coordinates.longitude)
						- Coordinates.distance(y.getCoordinates().latitude, y.getCoordinates().longitude, coordinates.latitude, coordinates.longitude))
		).limit(n).map(Airport::getName).collect(Collectors.toList());
	}


	/**
	 * Given a Stream of Airports, return the average altitude of airports in the
	 * Stream
	 * 
	 * If the stream is empty, return an empty OptionalDouble
	 */
	public static OptionalDouble problem7_averageAltitude(Stream<Airport> airports) {
		Double avg = airports.collect(Collectors.averagingDouble(Airport::getAltitude));
		return avg.equals(0.0) ? OptionalDouble.empty() : OptionalDouble.of(avg);
	}


	/**
	 * Given a Stream of airports, return a Map<Integer, Long> that maps the number
	 * of words in airport name to the number of airports that have that many words
	 * in their name.
	 * 
	 * Note: A word is defined as a non-space character that is separated by one or
	 * more spaces.
	 * 
	 * If the stream is empty, return an empty map.
	 */
	public static Map<Integer, Long> problem8_countAirportsByNumWordsInName(Stream<Airport> airports) {
		return airports.collect(Collectors.groupingBy((a -> a.getName().split("\\s+").length),Collectors.counting()));
	}


	/**
	 * Given a Stream of airports, return the percentage of airports whose name
	 * contains the name of the country they are in (case-insensitive). If a country
	 * name is blank, consider the airport name to NOT contain it.
	 * 
	 * If the stream is empty, return 0.
	 */
	public static double problem9_percentAirportsWithCountryInName(Stream<Airport> airports) {
		List<Boolean> cnt = airports.map(a -> a.getName().toLowerCase().contains(a.getCountry().toLowerCase())).toList();
		return cnt.isEmpty() ? 0 : 100.0 * cnt.stream().filter(Boolean::booleanValue).count() / cnt.size();
	}


	/**
	 * Given a Stream of airports, return a List containing the airport(s) with the longest name.
	 * The list should only contain multiple airports if there are multiple airports whose names
	 * are of the longest length. The order of the list should follow the order those airports 
	 * appear in the stream.
	 */
	public static List<Airport> problem10_getAirportWithLongestName(Stream<Airport> airports) {
		List<Airport> airportList = airports.toList();
		Optional<Integer> longest = airportList.stream().map(a -> a.getName().length()).max(Integer::compareTo);
		return longest.isEmpty() ? Collections.<Airport>emptyList() : airportList.stream().filter(n -> n.getName().length() == longest.get()).collect(Collectors.toList());
	}
}