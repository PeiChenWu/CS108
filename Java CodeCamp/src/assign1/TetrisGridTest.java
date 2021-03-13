package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class TetrisGridTest {
	
	// Provided simple clearRows() test
	// width 2, height 3 grid
	@Test
	public void testClear1() {
		boolean[][] before =
		{	
			{true, true, false, },
			{false, true, true, }
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	// TODO ADD TESTS

	@Test
	public void testClear2() {
		boolean[][] before =
		{	
			{true, true, true, },
			{true, true, true, }
		};
		
		boolean[][] after =
		{	
			{false, false, false},
			{false, false, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	
	@Test
	public void testClear3() {
		boolean[][] before =
		{	
			{true, true, false},
			{true, false, true}
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear4() {
		boolean[][] before =
		{	
			{true, true, true, },
			{false, false, true, }
		};
		
		boolean[][] after =
		{	
			{true, true, false},
			{false, false, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear5() {
		boolean[][] before =
		{	
			{false, false, true, },
			{true, true, false, }
		};
		
		boolean[][] after =
		{	
			{false, false, true, },
			{true, true, false, }
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear6() {
		boolean[][] before =
		{	
			{true, true, true, false, true, true, true },
			{true, false, true, true, false, false, true },
			{true, true, true, true, false, true, true }
		};
		
		boolean[][] after =
		{	
			{true, false, true, true, false, false, false },
			{false, true, false, false, false, false, false },
			{true, true, false, true, false, false, false }
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear7() {
		boolean[][] before =
		{	
			{true, false,},
			{true, false,}
		};
		
		boolean[][] after =
		{	
			{false, false},
			{false, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear8() {
		boolean[][] before =
		{	
			{true},
			{true}
		};
		
		boolean[][] after =
		{	
			{false},
			{false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear9() {
		boolean[][] before =
		{	
			{true},
			{false}
		};
		
		boolean[][] after =
		{	
			{true},
			{false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear10() {
		boolean[][] before =
		{	
			{true, true, true}
		};
		
		boolean[][] after =
		{	
			{false, false, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear11() {
		boolean[][] before =
		{	
			{true, true, false, false, true, true, true },
			{false, false, true, true, false, true, true },
			{true, true, true, true, false, true, true }
		};
		
		boolean[][] after =
		{	
			{true, true, false, false, true, false, false },
			{false, false, true, true, false, false, false },
			{true, true, true, true, false, false, false }
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear12() {
		boolean[][] before =
		{	
			{true, true, true, true, true, true, true },
			{false, false, true, true, false, true, true },
			{true, true, true, true, false, false, false }
		};
		
		boolean[][] after =
		{	
			{true, true, true, true, true, false, false },
			{false, false, false, true, true, false, false },
			{true, true, false, false, false, false, false }
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear13() {
		boolean[][] before =
		{	
			{true, true, true, true, true, true, true },
			{false, false, true, true, false, true, true },
			{true, true, true, true, false, false, false }
		};
		
		boolean[][] after =
		{	
			{true, true, true, true, true, false, false },
			{false, false, false, true, true, false, false },
			{true, true, false, false, false, false, false }
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
	@Test
	public void testClear14() {
		//case with no removal
		boolean[][] before =
		{	
			{ false, true},
			{false, true},
			{true, true},
			{false, true},
			{false, true},
			{true, false}
		};
		
		boolean[][] after =
		{	
			{false, true },
			{false, true},
			{true, true},
			{false, true},
			{false, true},
			{true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();
		
		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
}

