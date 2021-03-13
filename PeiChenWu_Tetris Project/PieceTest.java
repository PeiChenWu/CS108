package edu.stanford.cs108.tetris;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.*;

/*
  Unit test for Piece class -- starter shell.
 */
public class PieceTest {
	// You can create data to be used in the your
	// test cases like this. For each run of a test method,
	// a new PieceTest object is created and setUp() is called
	// automatically by JUnit.
	// For example, the code below sets up some
	// pyramid and s pieces in instance variables
	// that can be used in tests.
	private Piece pyr1, pyr2, pyr3, pyr4;
	private Piece s, sRotated;

	@Before
	public void setUp() throws Exception {
		pyr1 = new Piece(Piece.PYRAMID_STR);
		pyr2 = pyr1.computeNextRotation();
		pyr3 = pyr2.computeNextRotation();
		pyr4 = pyr3.computeNextRotation();
		s = new Piece(Piece.S1_STR);
		sRotated = s.computeNextRotation();
	}
	
	// Here are some sample tests to get you started
	
	@Test
	public void testSampleSize() {
		// Check size of pyr piece
		assertEquals(3, pyr1.getWidth());
		assertEquals(2, pyr1.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, pyr2.getWidth());
		assertEquals(3, pyr2.getHeight());
		
		assertEquals(2, pyr4.getWidth());
		assertEquals(3, pyr4.getHeight());
		
		// Now try with some other piece, made a different way
		Piece l = new Piece(Piece.STICK_STR);
		assertEquals(1, l.getWidth());
		assertEquals(4, l.getHeight());
	}
	
	
	// Test the skirt returned by a few pieces
	@Test
	public void testSampleSkirt() {
		// Note must use assertTrue(Arrays.equals(... as plain .equals does not work
		// right for arrays.
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, pyr1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0, 1}, pyr3.getSkirt()));
		
		assertTrue(Arrays.equals(new int[] {0, 0, 1}, s.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0}, sRotated.getSkirt()));
	}
	
	private Piece s1, s2, s3, s4;
	private Piece l1, l2, l3, l4;
	private Piece l1_m, l2_m, l3_m, l4_m;
	private Piece s_1, s_2, s_3, s_4;
	private Piece s_1m, s_2m, s_3m, s_4m;
	private Piece square1, square2, square3, square4;
	private Piece p1, p2, p3, p4;
	
	// Test different bodies
	@Before
	public void setUp2() throws Exception {
		s1 = new Piece(Piece.STICK_STR);
		s2 = s1.computeNextRotation();
		s3 = s2.computeNextRotation();
		s4 = s3.computeNextRotation();
		
		l1 = new Piece(Piece.L1_STR);
		l2 = l1.computeNextRotation();
		l3 = l2.computeNextRotation();
		l4 = l3.computeNextRotation();
		
		l1_m = new Piece(Piece.L2_STR);
		l2_m = l1_m.computeNextRotation();
		l3_m = l2_m.computeNextRotation();
		l4_m = l3_m.computeNextRotation();
		
		s_1 = new Piece(Piece.S1_STR);
		s_2 = s_1.computeNextRotation();
		s_3 = s_2.computeNextRotation();
		s_4 = s_3.computeNextRotation();
		
		s_1m = new Piece(Piece.S2_STR);
		s_2m = s_1m.computeNextRotation();
		s_3m = s_2m.computeNextRotation();
		s_4m = s_3m.computeNextRotation();
		
		square1 = new Piece(Piece.SQUARE_STR);
		square2 = square1.computeNextRotation();
		square3 = square2.computeNextRotation();
		square4 = square3.computeNextRotation();
		
		p1 = new Piece(Piece.PYRAMID_STR);
		p2 = p1.computeNextRotation();
		p3 = p2.computeNextRotation();
		p4 = p3.computeNextRotation();
	}
	
	@Test
	public void testSampleSize2() {
		// Check size of stick piece
		assertEquals(1, s1.getWidth());
		assertEquals(4, s1.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(4, s2.getWidth());
		assertEquals(1, s2.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(1, s3.getWidth());
		assertEquals(4, s3.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(4, s4.getWidth());
		assertEquals(1, s4.getHeight());
		
		
		// Check size of L piece
		assertEquals(2, l1.getWidth());
		assertEquals(3, l1.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(3, l2.getWidth());
		assertEquals(2, l2.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, l3.getWidth());
		assertEquals(3, l3.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(3, l4.getWidth());
		assertEquals(2, l4.getHeight());
		
		// Check size of L_m piece
		assertEquals(2, l1_m.getWidth());
		assertEquals(3, l1_m.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(3, l2_m.getWidth());
		assertEquals(2, l2_m.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, l3_m.getWidth());
		assertEquals(3, l3_m.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(3, l4_m.getWidth());
		assertEquals(2, l4_m.getHeight());
		
		// Check size of s_ piece
		assertEquals(3, s_1.getWidth());
		assertEquals(2, s_1.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, s_2.getWidth());
		assertEquals(3, s_2.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(3, s_3.getWidth());
		assertEquals(2, s_3.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, s_4.getWidth());
		assertEquals(3, s_4.getHeight());
		
		// Check size of s_m piece
		assertEquals(3, s_1m.getWidth());
		assertEquals(2, s_1m.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, s_2m.getWidth());
		assertEquals(3, s_2m.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(3, s_3m.getWidth());
		assertEquals(2, s_3m.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, s_4m.getWidth());
		assertEquals(3, s_4m.getHeight());
		
		// Check size of square piece
		assertEquals(2, square1.getWidth());
		assertEquals(2, square1.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, square2.getWidth());
		assertEquals(2, square2.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, square3.getWidth());
		assertEquals(2, square3.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, square4.getWidth());
		assertEquals(2, square4.getHeight());
		
		// Check size of pyr piece
		assertEquals(3, p1.getWidth());
		assertEquals(2, p1.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, p2.getWidth());
		assertEquals(3, p2.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(3, p3.getWidth());
		assertEquals(2, p3.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, p4.getWidth());
		assertEquals(3, p4.getHeight());
	}
	
	// Test the skirt returned by a few pieces
	@Test
	public void testSampleSkirt2() {
		// Note must use assertTrue(Arrays.equals(... as plain .equals does not work
		// right for arrays.
		assertTrue(Arrays.equals(new int[] {0}, s1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0, 0, 0}, s2.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0}, s3.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0, 0, 0}, s4.getSkirt()));
		
		assertTrue(Arrays.equals(new int[] {0,0}, l1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, l2.getSkirt()));
		assertTrue(Arrays.equals(new int[] {2,0}, l3.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 1, 1}, l4.getSkirt()));
		
		assertTrue(Arrays.equals(new int[] {0,0}, l1_m.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 1, 0}, l2_m.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 2}, l3_m.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, l4_m.getSkirt()));
		
		assertTrue(Arrays.equals(new int[] {0, 0, 1}, s_1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0}, s_2.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0, 1}, s_3.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0}, s_4.getSkirt()));
		
		assertTrue(Arrays.equals(new int[] {1, 0, 0}, s_1m.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 1}, s_2m.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0, 0}, s_3m.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 1}, s_4m.getSkirt()));
		
		assertTrue(Arrays.equals(new int[] {0, 0}, square1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0}, square2.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0}, square3.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 0}, square4.getSkirt()));
		
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, p1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0}, p2.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0, 1}, p3.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 1}, p4.getSkirt()));
	}
	
	@Test
	public void testMakeFastRotation() {
		Piece[] pieces = Piece.getPieces();	// the array of root pieces
		Piece stick = pieces[Piece.STICK];
		Piece stick2 = stick.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0, 0, 0}, stick2.getSkirt()));
		Piece stick3 = stick2.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0}, stick3.getSkirt()));
		Piece stick4 = stick3.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0, 0, 0}, stick4.getSkirt()));
		Piece stick5 = stick4.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0}, stick5.getSkirt()));
		assertTrue(stick.equals(stick5));
		
		Piece L = pieces[Piece.L1];
		Piece L2 = L.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, L2.getSkirt()));
		Piece L3 = L2.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {2, 0}, L3.getSkirt()));
		Piece L4 = L3.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 1, 1}, L4.getSkirt()));
		Piece L5 = L4.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0}, L5.getSkirt()));
		assertTrue(L.equals(L5));
		
		Piece L_ = pieces[Piece.L2];
		Piece L2_ = L_.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {1, 1, 0}, L2_.getSkirt()));
		Piece L3_ = L2_.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 2}, L3_.getSkirt()));
		Piece L4_ = L3_.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, L4_.getSkirt()));
		Piece L5_ = L4_.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0}, L5_.getSkirt()));
		assertTrue(L_.equals(L5_));
		
		Piece S1 = pieces[Piece.S1];
		Piece S2 = S1.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {1, 0}, S2.getSkirt()));
		Piece S3 = S2.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0, 1}, S3.getSkirt()));
		Piece S4 = S3.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {1, 0}, S4.getSkirt()));
		Piece S5 = S4.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0, 1}, S5.getSkirt()));
		assertTrue(S1.equals(S5));
		
		Piece S1_ = pieces[Piece.S2];
		Piece S2_ = S1_.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 1}, S2_.getSkirt()));
		Piece S3_ = S2_.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {1, 0, 0}, S3_.getSkirt()));
		Piece S4_ = S3_.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 1}, S4_.getSkirt()));
		Piece S5_ = S4_.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {1, 0, 0}, S5_.getSkirt()));
		assertTrue(S1_.equals(S5_));
		
		Piece P1 = pieces[Piece.PYRAMID];
		Piece P2 = P1.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {1, 0}, P2.getSkirt()));
		Piece P3 = P2.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {1, 0, 1}, P3.getSkirt()));
		Piece P4 = P3.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 1}, P4.getSkirt()));
		Piece P5 = P4.fastRotation();	// get the next rotation, fast way
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, P5.getSkirt()));
		assertTrue(P1.equals(P5));
	}
	
}
