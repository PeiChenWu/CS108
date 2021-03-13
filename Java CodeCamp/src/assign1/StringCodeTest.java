// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCodeTest {
	//
	// blowup
	//
	@Test
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	@Test
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
		assertEquals("22", StringCode.blowup("22"));
	}
	
	@Test
	public void testBlowup4() {
		
		assertEquals("a", StringCode.blowup("a"));
		assertEquals("abcdaaa", StringCode.blowup("abcd2a"));
		assertEquals("abcdaaa", StringCode.blowup("abcd2a1"));
		assertEquals("abcd", StringCode.blowup("abcd1"));
		assertEquals("attttxzzz", StringCode.blowup("a3tx2z"));
		assertEquals("2xxx", StringCode.blowup("12x"));
		assertEquals("at", StringCode.blowup("at2"));
		assertEquals("2xxx", StringCode.blowup("12x3"));
	}
	
	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	@Test
	public void testRun4() {
		assertEquals(1, StringCode.maxRun(" "));
		assertEquals("s   ", StringCode.blowup("s2 "));
		assertEquals("a33111  ", StringCode.blowup("a231 "));
		assertEquals(2, StringCode.maxRun("11"));
		assertEquals(2, StringCode.maxRun("92345611"));
		assertEquals(1, StringCode.maxRun("1"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(1, StringCode.maxRun(" "));
		assertEquals(2, StringCode.maxRun("1  2 5 s"));
	}
	
	// TODO Need test cases for stringIntersect
	
	@Test
	public void stringIntersectTest1() {
		// Basic tests
		assertEquals(true, StringCode.stringIntersect("123", "123", 1));
		assertEquals(true, StringCode.stringIntersect("123", "123", 2));
		assertEquals(true, StringCode.stringIntersect("123", "123", 3));
		assertEquals(false, StringCode.stringIntersect("123", "123", 4));
		assertEquals(false, StringCode.stringIntersect("123", "000", 1));
		assertEquals(false, StringCode.stringIntersect("apple", "Aped", 2));
		assertEquals(false, StringCode.stringIntersect("", "Aped", 2));
		assertEquals(true, StringCode.stringIntersect("aaaaap", "Aped", 1));
		assertEquals(true, StringCode.stringIntersect("aaaaap", "aped", 2));
		assertEquals(false, StringCode.stringIntersect("", "", 1));
		assertEquals(true, StringCode.stringIntersect("a", "a", 1));
		assertEquals(false, StringCode.stringIntersect("abc", "abc", 4));
		assertEquals(false, StringCode.stringIntersect("ab", "acd", 2));
		assertEquals(true, StringCode.stringIntersect("   ", "   ", 3));
	}

	@Test
	public void teststringIntersectTest2() {
		assertEquals(false, StringCode.stringIntersect("ab", "abc", 3));
		assertEquals(false, StringCode.stringIntersect("1123", "1232", 5));
		assertEquals(true, StringCode.stringIntersect("ab", "abc", 1));
		assertEquals(true, StringCode.stringIntersect("ab", "abc", 2));
		assertEquals(true, StringCode.stringIntersect("noteb", "the notebook", 5));
		assertEquals(true, StringCode.stringIntersect("the notebook", " noteb", 5));
	}
}
