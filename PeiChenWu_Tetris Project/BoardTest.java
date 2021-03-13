package edu.stanford.cs108.tetris;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board tetris1 = new Board(3, 6);
	private Piece pyr1, pyr2, pyr3, pyr4;
	private Piece s_1, s_2;//s_3, s_4;
	
	private Piece l1_m, l2_m, l3_m;//, l4_m;
	private Piece s_1m, s_2m, s_3m;//, s_4m;
	
	@Before
	public void setUp() throws Exception {
		pyr1 = new Piece(Piece.PYRAMID_STR);
		pyr2 = pyr1.computeNextRotation();
		pyr3 = pyr2.computeNextRotation();
		pyr4 = pyr3.computeNextRotation();
		
		s_1 = new Piece(Piece.S1_STR);
		s_2 = s_1.computeNextRotation();
		//s_3 = s_2.computeNextRotation();
		//s_4 = s_3.computeNextRotation();
		
		s_1m = new Piece(Piece.S2_STR);
		s_2m = s_1m.computeNextRotation();
		s_3m = s_2m.computeNextRotation();
		//s_4m = s_3m.computeNextRotation();
		
		l1_m = new Piece(Piece.L2_STR);
		l2_m = l1_m.computeNextRotation();
		l3_m = l2_m.computeNextRotation();
		//l4_m = l3_m.computeNextRotation();
		
	}

	@Test
	public void test1() {
		tetris1.place(pyr1, 0, 0);
		System.out.println(tetris1.toString());
		tetris1.commit();
		assertEquals(1, tetris1.getColumnHeight(0));
		assertEquals(2, tetris1.getColumnHeight(1));
		assertEquals(3, tetris1.getRowWidth(0));
		assertEquals(1, tetris1.getRowWidth(1));
		assertEquals(0, tetris1.getRowWidth(2));
		assertEquals(2, tetris1.dropHeight(pyr3, 0)); 
		assertEquals(1, tetris1.dropHeight(pyr4, 0)); 
		assertEquals(2, tetris1.dropHeight(s_1, 0));	
		assertEquals(1, tetris1.dropHeight(s_2, 1)); 
		assertEquals(2, tetris1.getMaxHeight());
		
		tetris1.place(s_2, 1, 1);
		assertEquals(4, tetris1.getMaxHeight());
		assertEquals(1, tetris1.getColumnHeight(0));
		assertEquals(4, tetris1.getColumnHeight(1));
		assertEquals(3, tetris1.getColumnHeight(2));
		tetris1.undo();
		System.out.println(tetris1.toString());
		tetris1.clearRows();
		System.out.println(tetris1.toString());
		
		tetris1.commit();
		tetris1.place(pyr2, 1, 0);
		tetris1.commit();
		System.out.println(tetris1.toString());
		System.out.println(tetris1.place(pyr3, 0, 2));
		System.out.println(tetris1.toString());
		tetris1.clearRows();
		System.out.println(tetris1.toString());
		tetris1.commit();
		tetris1.place(pyr4, 0, 2);
		System.out.println(tetris1.toString());
		tetris1.clearRows();
		tetris1.commit();
		System.out.println(tetris1.toString());
		tetris1.place(pyr2, 1, 2);
		System.out.println(tetris1.toString());
		tetris1.undo();
		System.out.println(tetris1.toString());
		tetris1.place(pyr2, 1, 2);
		System.out.println(tetris1.toString());
		tetris1.clearRows();
		System.out.println(tetris1.toString());
		tetris1.commit();
		tetris1.place(pyr3, 0, 2);
		tetris1.clearRows();
		System.out.println(tetris1.toString());
		tetris1.undo();
		System.out.println(tetris1.toString());
		assertEquals(5, tetris1.getColumnHeight(0));
		//System.out.println(tetris1.getColumnHeight(0));
		assertEquals(4, tetris1.getColumnHeight(1));
		//System.out.println(tetris1.getColumnHeight(1));
		assertEquals(3, tetris1.getColumnHeight(2));
		//System.out.println(tetris1.getColumnHeight(2));
		assertEquals(2, tetris1.getRowWidth(0));
		//System.out.println(tetris1.getRowWidth(0));
		assertEquals(2, tetris1.getRowWidth(1));
		//System.out.println(tetris1.getRowWidth(1));
		assertEquals(2, tetris1.getRowWidth(2));
		//System.out.println(tetris1.getRowWidth(2));
		assertEquals(2, tetris1.getRowWidth(3));
		//System.out.println(tetris1.getRowWidth(3));
		assertEquals(5, tetris1.getMaxHeight());
		//System.out.println(tetris1.getMaxHeight());
		assertEquals(false, tetris1.getGrid(0, 0));
		//System.out.println(tetris1.getGrid(0, 0));
		
		tetris1.place(pyr2, 1, 3);
		System.out.println(tetris1.toString());
		assertEquals(6, tetris1.getMaxHeight());
		assertEquals(6, tetris1.getColumnHeight(2));
		tetris1.clearRows();
		tetris1.commit();
		System.out.println(tetris1.toString());
		assertEquals(4, tetris1.getMaxHeight());
		tetris1.place(s_2, 0, 2);
		System.out.println(tetris1.toString());
		assertEquals(5, tetris1.getMaxHeight());
		
	}
	
	@Test
	public void test2 () {
		Board tetris2 = new Board(3, 6); 
		tetris2.place(l1_m, 0, 0);
		tetris1.commit();
		System.out.println(tetris2.toString());
		assertEquals(2, tetris2.getRowWidth(0));
		assertEquals(1, tetris2.getRowWidth(1));
		assertEquals(1, tetris2.getRowWidth(2));
		assertEquals(1, tetris2.getColumnHeight(0));
		assertEquals(3, tetris2.getColumnHeight(1));
		assertEquals(0, tetris2.getColumnHeight(2));
		assertEquals(3, tetris2.getMaxHeight());
		assertEquals(false, tetris1.getGrid(0, 0));
		
		assertEquals(2, tetris2.dropHeight(l2_m, 0));	
		
		tetris2.commit();
		tetris2.place(l2_m, 0, 2);
		tetris2.commit();
		System.out.println(tetris2.toString());
		tetris2.clearRows();
		System.out.println(tetris2.toString());
		tetris2.commit();
		tetris2.place(l3_m, 0, 1);
		System.out.println(tetris2.toString());
		assertEquals(4, tetris2.getMaxHeight());
	}
	
}
