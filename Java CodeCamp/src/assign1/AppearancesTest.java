package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	
	@Test
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}
	
	@Test
	public void testSameCount3() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(100, 900, 900, 100)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(111, 333, 32, 11)));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(1, 30, 300, 100, 110)));
	}
	
	@Test
	public void testSameCount4() {
		// basic List<Integer> cases
		List<String> a = Arrays.asList("CS108", "CS221", "CS110", "CS161", "CS221", "CS110");
		assertEquals(4, Appearances.sameCount(a,  Arrays.asList("CS108", "CS221", "CS110", "CS161", "CS221", "CS110")));
		assertEquals(0, Appearances.sameCount(a,  Arrays.asList("CS10", "CS22", "CS11", "CS16", "CS21", "CS1110'")));
		assertEquals(1, Appearances.sameCount(a,  Arrays.asList("CS108", "CS2211", "CS1310", "CS1361", "CS2251", "CS1110'")));
		assertEquals(3, Appearances.sameCount(a,  Arrays.asList("CS108", "CS221A", "CS110", "CS161", "CS221", "CS110")));
	}
	
	@Test
	public void testSameCount5(){
		List<Integer> test_1 = Arrays.asList(1);
		assertEquals(0, Appearances.sameCount(test_1, Arrays.asList(2)));
		assertEquals(0, Appearances.sameCount(test_1, Arrays.asList(2,3,2,4,5,3)));
	}
	
	@Test
	public void testSameCount6(){
		List<Integer> test_2 = Arrays.asList();
		assertEquals(0, Appearances.sameCount(test_2, Arrays.asList(0)));
		
		List<String> a = stringToList(" ");
		List<String> b = stringToList("b,a");
		assertEquals(0, Appearances.sameCount(a,b));
	}

	
	// TODO Add more tests
}
