// Board.java
package edu.stanford.cs108.tetris;
import java.util.*;

/**
 CS108 Tetris Board.
 Represents a Tetris board -- essentially a 2-d grid
 of booleans. Supports tetris pieces and row clearing.
 Has an "undo" feature that allows clients to add and remove pieces efficiently.
 Does not do any drawing or have any idea of pixels. Instead,
 just represents the abstract 2-d board.
*/
public class Board	{
	// Some ivars are stubbed out for you:
	private int width;
	private int height;
	private boolean[][] grid;
	private boolean DEBUG = true;
	boolean committed;
	private int maxHeight;
	
	private int[] widths;
	private int[] heights;
	
	private boolean[][] backupGrid;
	private int[] backupWidths;
	private int[] backupHeights;
	
	
	// Here a few trivial methods are provided:
	
	/**
	 Creates an empty board of the given width and height
	 measured in blocks.
	*/
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		grid = new boolean[width][height];
		backupGrid = new boolean[width][height];
		committed = true;
		widths = new int[height];
		heights = new int[width];
		backupWidths = new int[height];
		backupHeights = new int[width];
		maxHeight = 0;
	}
	
	
	/**
	 Returns the width of the board in blocks.
	*/
	public int getWidth() {
		return width;
	}
	
	
	/**
	 Returns the height of the board in blocks.
	*/
	public int getHeight() {
		return height;
	}
	
	private void computeMaxHeight() {
		int max = 0;
		for (int i=0; i < heights.length; i++) {
			if (heights[i] > max) {
				max = heights[i];
			}
		}
		maxHeight = max;
	}
	
	/**
	 Returns the max column height present in the board.
	 For an empty board this is 0.
	*/
	public int getMaxHeight() {	 
		return maxHeight;
	}
	
	
	/**
	 Checks the board for internal consistency -- used
	 for debugging.
	*/
	public void sanityCheck() {
		if (DEBUG) {
			int[] checkWidths = new int[height];
			int[] checkHeights = new int[width];
			int checkMaxHeight = 0;
			for (int i=0; i < grid.length; i++) {
				for (int j=0; j < grid[i].length; j++) {
					if (grid[i][j]) {
						checkWidths[j]++;
						checkHeights[i] = j + 1;
						if (checkMaxHeight < j+1)
							checkMaxHeight = j+1;
					}
				}
			}
			if (!Arrays.equals(checkWidths, widths))
				throw new RuntimeException("Widths check failed");
			if (!Arrays.equals(checkHeights, heights))
				throw new RuntimeException("Heights check failed");
			if (checkMaxHeight != maxHeight)
				throw new RuntimeException("Max Height check failed");
		}
	}
	
	/**
	 Given a piece and an x, returns the y
	 value where the piece would come to rest
	 if it were dropped straight down at that x.
	 
	 <p>
	 Implementation: use the skirt and the col heights
	 to compute this fast -- O(skirt length).
	*/
	public int dropHeight(Piece piece, int x) {
		int rest = 0;
		int[] skirt = piece.getSkirt();
		if ((x + skirt.length) > width || x < 0) {
			throw new RuntimeException("out of bounds");
		}
		for (int i=0; i < skirt.length; i++) {
			if (heights[x+i] - skirt[i] > rest)
				rest = heights[x+i] - skirt[i];
		}
		return rest;
	}
	
	/**
	 Returns the height of the given column --
	 i.e. the y value of the highest block + 1.
	 The height is 0 if the column contains no blocks.
	*/
	public int getColumnHeight(int x) {
		return heights[x];
	}
	
	
	/**
	 Returns the number of filled blocks in
	 the given row.
	*/
	public int getRowWidth(int y) {
		 return widths[y];
	}
	
	
	/**
	 Returns true if the given block is filled in the board.
	 Blocks outside of the valid width/height area
	 always return true.
	*/
	public boolean getGrid(int x, int y) {
		return (x < 0 || x >= width || y < 0 || y >= height || grid[x][y]);
	}
	
	private void backup() {
		System.arraycopy(widths, 0, backupWidths, 0, widths.length);
		System.arraycopy(heights, 0, backupHeights, 0, heights.length);
		for (int i=0; i < width; i++) System.arraycopy(grid[i], 0, backupGrid[i], 0, grid[i].length);
	}
	
	private void updateGrid(Piece piece, int x, int y) {
		TPoint[] body = piece.getBody();
		int newX, newY;
		for (int i=0; i < body.length; i++) {
			newX = x + body[i].x;
			newY = y + body[i].y;
			grid[newX][newY] = true;
			widths[newY]++;
			if (heights[newX] < newY + 1) heights[newX] = newY + 1;
		}
		computeMaxHeight();
	}
	
	public static final int PLACE_OK = 0;
	public static final int PLACE_ROW_FILLED = 1;
	public static final int PLACE_OUT_BOUNDS = 2;
	public static final int PLACE_BAD = 3;
	
	/**
	 Attempts to add the body of a piece to the board.
	 Copies the piece blocks into the board grid.
	 Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
	 for a regular placement that causes at least one row to be filled.
	 
	 <p>Error cases:
	 A placement may fail in two ways. First, if part of the piece may falls out
	 of bounds of the board, PLACE_OUT_BOUNDS is returned.
	 Or the placement may collide with existing blocks in the grid
	 in which case PLACE_BAD is returned.
	 In both error cases, the board may be left in an invalid
	 state. The client can use undo(), to recover the valid, pre-place state.
	*/
	public int place(Piece piece, int x, int y) {
		// flag !committed problem
		if (!committed) throw new RuntimeException("place commit problem");
			
		int result = PLACE_OK;
		if (x < 0 || y < 0) result = PLACE_OUT_BOUNDS;
		
		backup();
		int newX, newY;
		for (TPoint pt: piece.getBody()) {
			newX = pt.x + x;
			newY = pt.y + y;
			if (newX < 0 || newX >= width || newY < 0 || newY >= height) return PLACE_OUT_BOUNDS;
			if (grid[newX][newY]) return PLACE_BAD;
		}
		committed = false;
		updateGrid(piece, x, y);
		sanityCheck();

		for (int i=y; i < y + piece.getHeight(); i++) {
			if (widths[i] == width) return PLACE_ROW_FILLED;
		}
		
		return result;
	}
	
	private boolean FullRow(int col) {
		for (int i=0; i < width; i++) {
			if(!grid[i][col]) return false;
		}
		return true;
	}
	
	private void ShiftDownAllTheRows(int col){
		for (int j=col; j < maxHeight-1; j++) {
			for (int i=0; i < grid.length; i++) {
				grid[i][j] = grid[i][j+1];
			}
			widths[j] = widths[j+1];
		}
		for (int i=0; i < width; i++) {
			grid[i][maxHeight-1] = false;
		}
		widths[maxHeight-1] = 0;
		
		int[] heights_ = new int[width];
		for (int i=0; i < width; i++) {
			for (int j=0; j < maxHeight; j++) {
				if (grid[i][j]) heights_[i] = j+1;
			}
			heights[i] = heights_[i];
		}
	}
	
	/**
	 Deletes rows that are filled all the way across, moving
	 things above down. Returns the number of rows cleared.
	*/
	public int clearRows() {
		if (committed) {committed = false; backup();}
		int rowsCleared = 0;
		for (int j=0; j < maxHeight; j++){
			if (FullRow(j)){
				rowsCleared++;
				ShiftDownAllTheRows(j);
				j--;
				maxHeight--;
			}
		}
		sanityCheck();
		return rowsCleared;
	}



	/**
	 Reverts the board to its state before up to one place
	 and one clearRows();
	 If the conditions for undo() are not met, such as
	 calling undo() twice in a row, then the second undo() does nothing.
	 See the overview docs.
	*/
	public void undo() {
		if (backupGrid == null) throw new RuntimeException("No backup grid");
		if (!committed) {
			System.arraycopy(backupWidths, 0, widths, 0, widths.length);
			System.arraycopy(backupHeights, 0, heights, 0, heights.length);
			for (int i=0; i < grid.length; i++) System.arraycopy(backupGrid[i], 0, grid[i], 0, grid[i].length);
		} else return;
		computeMaxHeight();
		commit();
		sanityCheck();
	}
	
	
	/**
	 Puts the board in the committed state.
	*/
	public void commit() {
		committed = true;
	}


	
	/*
	 Renders the board state as a big String, suitable for printing.
	 This is the sort of print-obj-state utility that can help see complex
	 state change over time.
	 (provided debugging utility) 
	 */
	public String toString() {
		StringBuilder buff = new StringBuilder();
		for (int y = height-1; y>=0; y--) {
			buff.append('|');
			for (int x=0; x<width; x++) {
				if (getGrid(x,y)) buff.append('+');
				else buff.append(' ');
			}
			buff.append("|\n");
		}
		for (int x=0; x<width+2; x++) buff.append('-');
		return(buff.toString());
	}
}


