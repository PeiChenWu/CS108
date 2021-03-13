// Test cases for CharGrid -- a few basic tests are provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharGridTest {
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
		assertEquals(1, cg.charArea('x'));
		assertEquals(1, cg.charArea('y'));
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', 'x', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(9, cg.charArea(' '));
		assertEquals(1, cg.charArea('x'));
	}
	
	@Test
	public void testCharArea3() {
		char[][] grid = new char[][] {
				{'a', 'b', 'c', 'd'},
				{'a', ' ', 'c', 'b'},
				{'d', 'b', 'c', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(12, cg.charArea('a'));
		assertEquals(9, cg.charArea('b'));
		assertEquals(3, cg.charArea('c'));
		assertEquals(1, cg.charArea(' '));
		assertEquals(12, cg.charArea('d'));
	}
	
	@Test
	public void testCharArea4() {
		char[][] grid = new char[][] {
				{'a'},
				{}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.charArea('a'));
	}
	
	@Test
	public void testCharArea5() {
		char[][] grid = new char[][] {
				{},{}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(0, cg.charArea('a'));
	}
	
    @Test
    public void testCharArea6() {
        char[][] grid = new char[][]{
                {' '},
                {'b'},
                {'b'}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(1, cg.charArea(' '));
        assertEquals(2, cg.charArea('b'));
        assertEquals(0, cg.charArea('a'));
    }
    
    @Test
    public void testCharArea7() {
        char[][] grid = new char[][]{
                {'c', 'a', ' '}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(1, cg.charArea('a'));
        assertEquals(1, cg.charArea(' '));
        assertEquals(1, cg.charArea('c'));
    }
	
	@Test
	public void testCountPlus1() {
		char[][] grid = new char[][] {
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
				{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
				{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
				{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
				{' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(2, cg.countPlus());
	}
	
	@Test
	public void testCountPlus2() {
		char[][] grid = new char[][] {
				{' ', ' ', 'p', ' ', ' ', 'a', ' ', ' ', ' '},
				{' ', ' ', 'p', 'p', 'a', 'a', 'a', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', 'a', 'x', 'x', 'x'},
				{' ', ' ', 'p', 'p', 'p', 'y', ' ', 'x', ' '},
				{' ', ' ', 'p', ' ', 'y', 'y', 'y', 'z', ' '},
				{'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z'},
				{' ', ' ', 'x', 'x', ' ', ' ', ' ', 'z', ' '}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(3, cg.countPlus());
	}
	
	@Test
	public void testCountPlus3() {
		char[][] grid = new char[][] {
				{' ', 'A', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{'A', 'A', 'A', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', 'A', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', 'z', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', 'z', ' '},
				{' ', ' ', ' ', ' ', ' ', 'z', 'z', 'z', 'z'},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', 'z', ' '},
				{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(2, cg.countPlus());
	}
	
	@Test
	public void testCountPlus4() {
		char[][] grid = new char[][] {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.countPlus());
	}
	
    @Test
    public void testCountPlus5() {
        char[][] grid = new char[][]{
                {'c', 'a', ' '},
                {'a', 'a', 'a'},
                {' ', 'a', ' '}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(1, cg.countPlus());
    }
    
    @Test
    public void testCountPlus6() {
        char[][] grid = new char[][]{
                {' ', ' ', 'x', ' ', ' '},
                {' ', ' ', 'x', ' ', ' '},
                {'x', 'x', 'x', 'x', 'a'},
                {' ', ' ', 'x', ' ', ' '},
                {' ', ' ', 'x', ' ', ' '}

        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(0, cg.countPlus());
    }
    
    @Test
    public void testCountPlus7() {
        char[][] grid = new char[][]{
                {'c', 'v', ' ', 'a', 'a', 'a', ' ', 'a', ' '},
                {'v', 'v', 'v', 'a', 'a', 'a', ' ', 'a', ' '},
                {' ', 'v', ' ', 'a', 'a', 'v', ' ', 'a', ' '},
                {' ', ' ', ' ', 'v', 'v', 'v', 'v', 'v', ' '},
                {' ', 'a', ' ', 'a', ' ', 'v', ' ', 'a', ' '},
                {' ', 'a', ' ', 'a', ' ', 'a', ' ', 'a', ' '}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(2, cg.countPlus());
    }
    
    @Test
    public void testCountPlus8() {
        char[][] grid = new char[][]{
                {'a', 'c', 'c'}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(0, cg.countPlus());
    }
    
    @Test
    public void testCountPlus9() {
        char[][] grid = new char[][]{
                {'a'},
                {'a'},
                {'a'}

        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(0, cg.countPlus());
    }
    
    @Test
    public void testCountPlus10() {
        char[][] grid = new char[][]{
                {'x', 'x', 'x'},
                {'x', 'x', 'x'},
                {'x', 'x', 'x'},
                {'x', 'x', 'x'},

        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(0, cg.countPlus());
    }
    
    @Test
    public void testCountPlus11() {
        char[][] grid = new char[][]{
                {'c'}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(0, cg.countPlus());
    }
}

