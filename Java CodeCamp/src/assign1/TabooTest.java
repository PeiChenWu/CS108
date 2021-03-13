// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class TabooTest {
	// TODO ADD TESTS
	
    @Test
    public void TabooTest1() {
    	// Rule 1 
        List<String> list = Arrays.asList("a", "c", "a", "b"); // a c a b
        Taboo<String> taboo = new Taboo<String>(list);

        // Testing noFollow
        Set<String> testSet1 = new HashSet<String>(Arrays.asList("c", "b"));
        assertTrue(testSet1.equals(taboo.noFollow("a")));
        
        // Testing noFollow
		Set<String> result_2 = new HashSet<String>();
		result_2.add("c"); result_2.add("b");
		assertEquals(result_2, taboo.noFollow("a"));
		
		// Testing noFollow
		Set<String> result_3 = new HashSet<String>();
		assertEquals(result_3, taboo.noFollow("x"));
        
		// Testing reduce
        List<String> list1 = new ArrayList<String>(); // a c b x c a
        list1.add("a"); list1.add("c"); list1.add("b");
        list1.add("x"); list1.add("c"); list1.add("a");
        List<String> testlist1 = Arrays.asList("a", "x", "c");
        taboo.reduce(list1);
        assertTrue(testlist1.equals(list1));
        
        
        // Rule 2
		List<String> rule_2 = Arrays.asList("a", "c", "a", "b");
		Taboo<String> tb_2 = new Taboo<String>(rule_2);
		
		// Testing reduce
		List<String> list_2 = new ArrayList<String>(); // a b b b b b
		list_2.add("a"); list_2.add("b"); list_2.add("b");
		list_2.add("b"); list_2.add("b"); list_2.add("b");
		List<String> result_6 = Arrays.asList("a");
		tb_2.reduce(list_2);
		assertEquals(result_6, list_2);
		
		// Testing reduce
		List<String> list_3 = new ArrayList<String>();  // a b b b b a
		list_3.add("a"); list_3.add("b"); list_3.add("b");
		list_3.add("b"); list_3.add("b"); list_3.add("a");
		List<String> result_7 = Arrays.asList("a","a");
		tb_2.reduce(list_3);
		assertEquals(result_7, list_3);
        
		
		// Rule 3
		List<String> rule_1 = Arrays.asList("a", "t", "y");
		Taboo<String> tb_1 = new Taboo<String>(rule_1);
		
		// Testing noFollow
		Set<String> result_1 = new HashSet<String>();
		result_1.add("t");
		assertEquals(result_1, tb_1.noFollow("a"));
		
		// Testing noFollow
		Set<String> result_ = new HashSet<String>();
		assertEquals(result_, tb_1.noFollow("y"));
		
		
		// Rule 4
		List<String> rule_3 = Arrays.asList("a", "t", null, "y", "b", null);
		Taboo<String> tb_3 = new Taboo<String>(rule_3);
		
		// Testing noFollow
		Set<String> result_4 = new HashSet<String>(Arrays.asList("t"));
		assertEquals(result_4, tb_3.noFollow("a"));
		
		// Testing noFollow
		Set<String> result_5 = new HashSet<String>(Arrays.asList("b"));
		assertEquals(result_5, tb_3.noFollow("y"));
		
		// Testing noFollow
		Set<String> result_8 = new HashSet<String>();
		assertEquals(result_8, tb_3.noFollow("b"));
		
		// Testing noFollow
		Set<String> result_10 = new HashSet<String>();
		assertEquals(result_10, tb_3.noFollow("t"));
		
		// Testing reduce
		List<String> list_ = new ArrayList<String>(); // a y a y a a a t
		list_.add("a"); list_.add("y"); list_.add("a");
		list_.add("y"); list_.add("a"); list_.add("a");
		list_.add("a"); list_.add("t");
		List<String> result_9 = Arrays.asList("a", "y", "a", "y", "a", "a", "a");
		tb_3.reduce(list_);
		assertEquals(result_9, list_);
		
    }
    
}