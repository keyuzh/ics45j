package labs.lab10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

class Lab10Test {
	
	private final double EPSILON = 1e-3;

	List<Airport> airportsList;
	List<Airport> airportsList1;
	List<Airport> airportsList2;
	List<Airport> airportsList3;
	List<Airport> airportsList4;
	List<Airport> airportsList5;
	List<Airport> airportsList6;
	List<Airport> airportsList7;
	List<Airport> airportsList8;
	List<Airport> airportsList9;
	List<Airport> airportsList10;
	
	//This method will be executed before all the other methods.
	@BeforeEach
	void before() {
		String path = "./labs/lab10/res/"; //<- Assign the path of the .dat files to this variable. Do not include the file name,
								// it will be added below.
		airportsList = AirportsReader.readAirports(path + "airports.dat");
		airportsList1 = AirportsReader.readAirports(path + "airports1.dat");
		airportsList2 = AirportsReader.readAirports(path + "airports2.dat");
		airportsList3 = AirportsReader.readAirports(path + "airports3.dat");
		airportsList4 = AirportsReader.readAirports(path + "airports4.dat");
		airportsList5 = AirportsReader.readAirports(path + "airports5.dat");
		airportsList6 = AirportsReader.readAirports(path + "airports6.dat");
		airportsList7 = AirportsReader.readAirports(path + "airports7.dat");
		airportsList8 = AirportsReader.readAirports(path + "airports8.dat");
		airportsList9 = AirportsReader.readAirports(path + "airports9.dat");
		airportsList10 = AirportsReader.readAirports(path + "airports10.dat");
	}
	
	
	@Test
	void problem1() {
		assertTrue(AirportsStats.problem1_getAirportsInCountry(airportsList1.stream(), "Korea").isEmpty());
		
		List<Airport> result = AirportsStats.problem1_getAirportsInCountry(airportsList1.stream(), "Greenland");
		assertTrue(result.size() == 4 &&
				result.get(0).getAirportID() == 8 &&
				result.get(1).getAirportID() == 9 &&
				result.get(2).getAirportID() == 10 &&
				result.get(3).getAirportID() == 7);
		
		result = AirportsStats.problem1_getAirportsInCountry(airportsList1.stream(), "United States");
		assertTrue(result.size() == 7 &&
				result.get(0).getAirportID() == 3747 &&
				result.get(1).getAirportID() == 3830 &&
				result.get(2).getAirportID() == 3699 &&
				result.get(3).getAirportID() == 7767 &&
				result.get(4).getAirportID() == 3797 &&
				result.get(5).getAirportID() == 3697 &&
				result.get(6).getAirportID() == 8123);
		
		assertTrue(AirportsStats.problem1_getAirportsInCountry(airportsList3.stream(), "Korea").isEmpty());
		
		result = AirportsStats.problem1_getAirportsInCountry(airportsList.stream(), "Antarctica");
		assertTrue(result.size() == 7 &&
				result.get(0).getAirportID() == 2493 &&
				result.get(1).getAirportID() == 7947 &&
				result.get(2).getAirportID() == 9124 &&
				result.get(3).getAirportID() == 2033 &&
				result.get(4).getAirportID() == 2661 &&
				result.get(5).getAirportID() == 7578 &&
				result.get(6).getAirportID() == 2038);
		
		assertTrue(AirportsStats.problem1_getAirportsInCountry(airportsList5.stream(), "Korea").isEmpty());
		
		result = AirportsStats.problem1_getAirportsInCountry(airportsList5.stream(), "Papua New Guinea");
		assertTrue(result.size() == 1 &&
				result.get(0).getAirportID() == 2);
	}
	
	
	@Test
	void problem2() {
		assertEquals("John F Kennedy International Airport, London City Airport, Madang Airport, Wewak International Airport", 
				AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList1.stream(), 0.0, 20.0));
		
		assertEquals("", 
				AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList1.stream(), 1000.0, 5000.0));
		
		assertEquals("Goroka Airport, Mount Hagen Kagamuga Airport", 
				AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList1.stream(), 5000.0, 10000.0));
		
		assertEquals("Indianola Municipal Airport, Kangerlussuaq Airport, Port Moresby Jacksons International Airport, xNarsarsuaq Airport", 
				AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList1.stream(), 100.0, 200.0));
		
		assertEquals("", 
				AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList3.stream(), 0, 10000.0));
		
		assertEquals("Madang Airport", 
				AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList5.stream(), 0.0, 10000.0));
		
		assertEquals("Madang Airport", 
				AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList5.stream(), 20, 20));
		
		assertEquals("", 
				AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList5.stream(), 21.0, 10000.0));
		
		assertEquals("Alberto Alcolumbre Airport, Broome International Airport, Bziers-Vias Airport, El Carmen de Siquirres Airport, Islay Airport, John Wayne Airport-Orange County Airport, Kampong Chhnang Airport, Knox County Regional Airport, Kugaaruk Airport, Leeward Point Field, Mariana Grajales Airport, Odense Airport, Ovar Air Base, Port Augusta Airport, Sandnessjen Airport (Stokka), Summerside Airport, Syukuran Aminuddin Amir Airport, Taura Airport, Trondheim Airport Vrnes",
				(AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList.stream(), 56, 56)));

		assertEquals("Bar Yehuda Airfield, Ein Yahav Airfield, Jacqueline Cochran Regional Airport",
				(AirportsStats.problem2_getAllAirportsInAltitudeRange(airportsList.stream(), -100000, -100)));
	}
	
	
	@Test
	void problem3() {
		List<String> result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList1.stream(), 1);
		assertTrue(result.size() == 1 &&
				result.get(0).equals("New York"));
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList1.stream(), 2);
		assertTrue(result.size() == 2 &&
				result.get(0).equals("New York") &&
				result.get(1).equals("Chicago"));
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList1.stream(), 3);
		assertTrue(result.size() == 3 &&
				result.get(0).equals("New York") &&
				result.get(1).equals("Chicago") &&
				result.get(2).equals("London"));
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList2.stream(), 1);
		assertTrue(result.size() == 1 &&
				result.get(0).equals("New York"));
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList2.stream(), 2);
		assertTrue(result.size() == 2 &&
				result.get(0).equals("New York") &&
				result.get(1).equals("Chicago"));
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList2.stream(), 3);
		assertTrue(result.size() == 3 &&
				result.get(0).equals("New York") &&
				result.get(1).equals("Chicago") &&
				result.get(2).equals("West Chicago"));
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList2.stream(), 4);
		assertTrue(result.size() == 3 &&
				result.get(0).equals("New York") &&
				result.get(1).equals("Chicago") &&
				result.get(2).equals("West Chicago"));
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList.stream(), 5);
		assertTrue(result.size() == 5 &&
				result.get(0).equals("London") &&
				result.get(1).equals("Columbus") &&
				result.get(2).equals("Georgetown") &&
				result.get(3).equals("San Jose") &&
				result.get(4).equals("Greenville"));

		assertTrue(AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList3.stream(), 1).isEmpty());
		
		assertTrue(AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList3.stream(), 10).isEmpty());
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList5.stream(), 1);
		assertTrue(result.size() == 1 &&
				result.get(0).equals("Madang"));
		
		result = AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList5.stream(), 10);
		assertTrue(result.size() == 1 &&
				result.get(0).equals("Madang"));
		
		assertTrue(AirportsStats.problem3_getTopNCitiesWithMostAirports(airportsList.stream(), 0).isEmpty());
	}
	
	
	@Test
	void problem4() {
		assertEquals(14, AirportsStats.problem4_countCities(airportsList1.stream()));
		assertEquals(3, AirportsStats.problem4_countCities(airportsList2.stream()));
		assertEquals(0, AirportsStats.problem4_countCities(airportsList3.stream()));
		assertEquals(13, AirportsStats.problem4_countCities(airportsList4.stream()));
		assertEquals(1, AirportsStats.problem4_countCities(airportsList5.stream()));
		assertEquals(6822, AirportsStats.problem4_countCities(airportsList.stream()));
	}
	
	
	@Test
	void problem5() {
//		lowest = AirportsStats.problem3_getAirportAtLowestAltitude(airportsList5.stream());
//		assertTrue(lowest.isPresent());
//		if (lowest.isPresent()) {
//			Airport result = lowest.get();
//			assertEquals(2, result.getAirportID());
//		}
		Optional<Airport> airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList1.stream(), "airport");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(3699, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList1.stream(), "INTERNATIONAL");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(3747, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList1.stream(), "Police");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(8123, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList1.stream(), "INTERNATIONAL");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(3747, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList1.stream(), "Robert");
		assertFalse(airport.isPresent());
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList3.stream(), "airport");
		assertFalse(airport.isPresent());
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList5.stream(), "airport");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(2, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList5.stream(), "madang");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(2, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList.stream(), "airport");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(1, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList.stream(), "John Wayne");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(3867, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList.stream(), "Gimpo International Airport");
		assertTrue(airport.isPresent());
		if (airport.isPresent()) {
			Airport result = airport.get();
			assertEquals(2378, result.getAirportID());
		}
		
		airport = AirportsStats.problem5_getFirstAirportContainingString(airportsList.stream(), "Gimpo International Airport Gimpo International Airport");
		assertFalse(airport.isPresent());
	}
	
	
	@Test
	void problem6() {
		List<String> result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(-9.443380355834961,147.22000122070312), 1);
		assertTrue(result.size() == 1 &&
				result.get(0).equals("Port Moresby Jacksons International Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(-9.443380355834961,147.22000122070312), 2);
		assertTrue(result.size() == 2 &&
				result.get(0).equals("Port Moresby Jacksons International Airport") &&
				result.get(1).equals("Nadzab Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(-9.443380355834961,147.22000122070312), 3);
		assertTrue(result.size() == 3 &&
				result.get(0).equals("Port Moresby Jacksons International Airport") &&
				result.get(1).equals("Nadzab Airport") &&
				result.get(2).equals("Goroka Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(-9.443380355834961,147.22000122070312), 4);
		assertTrue(result.size() == 4 &&
				result.get(0).equals("Port Moresby Jacksons International Airport") &&
				result.get(1).equals("Nadzab Airport") &&
				result.get(2).equals("Goroka Airport") &&
				result.get(3).equals("Madang Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(-9.443380355834961,147.22000122070312), 5);
		assertTrue(result.size() == 5 &&
				result.get(0).equals("Port Moresby Jacksons International Airport") &&
				result.get(1).equals("Nadzab Airport") &&
				result.get(2).equals("Goroka Airport") &&
				result.get(3).equals("Madang Airport") &&
				result.get(4).equals("Mount Hagen Kagamuga Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(-9.443380355834961,147.22000122070312), 6);
		assertTrue(result.size() == 6 &&
				result.get(0).equals("Port Moresby Jacksons International Airport") &&
				result.get(1).equals("Nadzab Airport") &&
				result.get(2).equals("Goroka Airport") &&
				result.get(3).equals("Madang Airport") &&
				result.get(4).equals("Mount Hagen Kagamuga Airport") &&
				result.get(5).equals("Wewak International Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(-9.443380355834961,147.22000122070312), 7);
		assertTrue(result.size() == 7 &&
				result.get(0).equals("Port Moresby Jacksons International Airport") &&
				result.get(1).equals("Nadzab Airport") &&
				result.get(2).equals("Goroka Airport") &&
				result.get(3).equals("Madang Airport") &&
				result.get(4).equals("Mount Hagen Kagamuga Airport") &&
				result.get(5).equals("Wewak International Airport") &&
				result.get(6).equals("Thule Air Base"));

		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(33.6405, -117.8443), 1);
		assertTrue(result.size() == 1 &&
				result.get(0).equals("Indianola Municipal Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(33.6405, -117.8443), 2);
		assertTrue(result.size() == 2 &&
				result.get(0).equals("Indianola Municipal Airport") &&
				result.get(1).equals("Dupage Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(33.6405, -117.8443), 3);
		assertTrue(result.size() == 3 &&
				result.get(0).equals("Indianola Municipal Airport") &&
				result.get(1).equals("Dupage Airport") &&
				result.get(2).equals("Chicago O'Hare International Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(33.6405, -117.8443), 4);
		assertTrue(result.size() == 4 &&
				result.get(0).equals("Indianola Municipal Airport") &&
				result.get(1).equals("Dupage Airport") &&
				result.get(2).equals("Chicago O'Hare International Airport") &&
				result.get(3).equals("Chicago Midway International Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(33.6405, -117.8443), 5);
		assertTrue(result.size() == 5 &&
				result.get(0).equals("Indianola Municipal Airport") &&
				result.get(1).equals("Dupage Airport") &&
				result.get(2).equals("Chicago O'Hare International Airport") &&
				result.get(3).equals("Chicago Midway International Airport") &&
				result.get(4).equals("One Police Plaza Heliport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList1.stream(), new Coordinates(33.6405, -117.8443), 6);
		assertTrue(result.size() == 6 &&
				result.get(0).equals("Indianola Municipal Airport") &&
				result.get(1).equals("Dupage Airport") &&
				result.get(2).equals("Chicago O'Hare International Airport") &&
				result.get(3).equals("Chicago Midway International Airport") &&
				result.get(4).equals("One Police Plaza Heliport") &&
				result.get(5).equals("La Guardia Airport"));

		assertTrue(AirportsStats.problem6_getTopNAirportsClosestTo(airportsList3.stream(), new Coordinates(33.6405, -117.8443), 1).isEmpty());
		assertTrue(AirportsStats.problem6_getTopNAirportsClosestTo(airportsList3.stream(), new Coordinates(33.6405, -117.8443), 2).isEmpty());

		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList5.stream(), new Coordinates(33.6405, -117.8443), 1);
		assertTrue(result.size() == 1 &&
				result.get(0).equals("Madang Airport"));
		
		result = AirportsStats.problem6_getTopNAirportsClosestTo(airportsList5.stream(), new Coordinates(33.6405, -117.8443), 2);
		assertTrue(result.size() == 1 &&
				result.get(0).equals("Madang Airport"));
	}
	
	
	@Test
	void problem7() {
		OptionalDouble opt = AirportsStats.problem7_averageAltitude(airportsList2.stream());
		assertTrue(opt.isPresent());
		if (opt.isPresent()) {
			double result = opt.getAsDouble();
			assertEquals(350.714, result, EPSILON);
		}
		
		opt = AirportsStats.problem7_averageAltitude(airportsList6.stream());
		assertTrue(opt.isPresent());
		if (opt.isPresent()) {
			double result = opt.getAsDouble();
			assertEquals(2157.5, result, EPSILON);
		}
		
		opt = AirportsStats.problem7_averageAltitude(airportsList7.stream());
		assertTrue(opt.isPresent());
		if (opt.isPresent()) {
			double result = opt.getAsDouble();
			assertEquals(4150.0, result, EPSILON);
		}
		
		opt = AirportsStats.problem7_averageAltitude(airportsList3.stream());
		assertFalse(opt.isPresent());
		
		opt = AirportsStats.problem7_averageAltitude(airportsList.stream());
		assertTrue(opt.isPresent());
		if (opt.isPresent()) {
			double result = opt.getAsDouble();
			assertEquals(1004.7147, result, EPSILON);
		}
	}
	
	
	@Test
	void problem8() {
		Map<Integer, Long> result = AirportsStats.problem8_countAirportsByNumWordsInName(airportsList1.stream());
		assertTrue(result.size() == 4 &&
				result.get(2) == 6 &&
				result.get(3) == 6 &&
				result.get(4) == 5 &&
				result.get(5) == 2);
		
		result = AirportsStats.problem8_countAirportsByNumWordsInName(airportsList2.stream());
		assertTrue(result.size() == 4 &&
				result.get(2) == 1 &&
				result.get(3) == 2 &&
				result.get(4) == 3 &&
				result.get(5) == 1);
		
		assertEquals(0, AirportsStats.problem8_countAirportsByNumWordsInName(airportsList3.stream()).size());

		result = AirportsStats.problem8_countAirportsByNumWordsInName(airportsList4.stream());
		assertTrue(result.size() == 4 &&
				result.get(2) == 6 &&
				result.get(3) == 3 &&
				result.get(4) == 4 &&
				result.get(5) == 1);
		
		result = AirportsStats.problem8_countAirportsByNumWordsInName(airportsList5.stream());
		assertTrue(result.size() == 1 &&
				result.get(2) == 1);
		
		result = AirportsStats.problem8_countAirportsByNumWordsInName(airportsList6.stream());
		assertTrue(result.size() == 2 &&
				result.get(2) == 1 &&
				result.get(3) == 3);
		
		result = AirportsStats.problem8_countAirportsByNumWordsInName(airportsList7.stream());
		assertTrue(result.size() == 2 &&
				result.get(2) == 1 &&
				result.get(3) == 1);
		
		result = AirportsStats.problem8_countAirportsByNumWordsInName(airportsList.stream());
		assertTrue(result.size() == 9 &&
				result.get(1) == 6 &&
				result.get(2) == 3404 &&
				result.get(3) == 2382 &&
				result.get(4) == 1085 &&
				result.get(5) == 421 &&
				result.get(6) == 160 &&
				result.get(7) == 62 &&
				result.get(8) == 18 &&
				result.get(9) == 5);
	}
	
	
	@Test
	void problem9() {
		assertEquals(0.0, AirportsStats.problem9_percentAirportsWithCountryInName(airportsList1.stream()), EPSILON);
		assertEquals(0.0, AirportsStats.problem9_percentAirportsWithCountryInName(airportsList3.stream()), EPSILON);
		assertEquals(0.0, AirportsStats.problem9_percentAirportsWithCountryInName(airportsList5.stream()), EPSILON);
		assertEquals(13.636, AirportsStats.problem9_percentAirportsWithCountryInName(airportsList8.stream()), EPSILON);
		assertEquals(26.923, AirportsStats.problem9_percentAirportsWithCountryInName(airportsList9.stream()), EPSILON);
		assertEquals(0.4507, AirportsStats.problem9_percentAirportsWithCountryInName(airportsList.stream()), EPSILON);
	}
	
	
	@Test
	void problem10() {
		List<Airport> result = AirportsStats.problem10_getAirportWithLongestName(airportsList1.stream());
		assertTrue(result.size() == 1 &&
				result.get(0).getAirportID() == 5);
		
		result = AirportsStats.problem10_getAirportWithLongestName(airportsList2.stream());
		assertTrue(result.size() == 3 &&
				result.get(0).getAirportID() == 3797 &&
				result.get(1).getAirportID() == 3747 &&
				result.get(2).getAirportID() == 3830);
		
		assertEquals(0, AirportsStats.problem10_getAirportWithLongestName(airportsList3.stream()).size());
		
		result = AirportsStats.problem10_getAirportWithLongestName(airportsList5.stream());
		assertTrue(result.size() == 1 &&
				result.get(0).getAirportID() == 2);
		
		result = AirportsStats.problem10_getAirportWithLongestName(airportsList6.stream());
		assertTrue(result.size() == 1 &&
				result.get(0).getAirportID() == 13725);
		
		result = AirportsStats.problem10_getAirportWithLongestName(airportsList7.stream());
		assertTrue(result.size() == 1 &&
				result.get(0).getAirportID() == 11823);

		result = AirportsStats.problem10_getAirportWithLongestName(airportsList10.stream());
		assertTrue(result.size() == 3 &&
				result.get(0).getAirportID() == 3747 &&
				result.get(1).getAirportID() == 3830 &&
				result.get(2).getAirportID() == 3797);

		result = AirportsStats.problem10_getAirportWithLongestName(airportsList.stream());
		assertTrue(result.size() == 1 &&
				result.get(0).getAirportID() == 2564);
	}
}
