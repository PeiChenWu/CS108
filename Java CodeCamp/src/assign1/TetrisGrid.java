//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {
	private boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for (int j=0; j < grid[0].length; j++){
			if (FullRow(j)){
				ShiftDownAllTheRows(j);
				j--;
			}
		}
	}
	
	private boolean FullRow(int col){
		for (int i=0; i < grid.length; i++){
			if(!grid[i][col]) return false;
		}
		return true;
	}
	
	private boolean AllFalse(int col){
		for (int i=0; i < grid.length; i++){
			if(grid[i][col]) return false;
		}
		return true;
	}
	
	private void ShiftDownAllTheRows(int col){
		for (int j=col; j < grid[0].length-1; j++) {
			for (int i=0; i < grid.length; i++) {
				grid[i][j] = grid[i][j+1];
			}
			if (AllFalse(j)) return;
		}
		for (int i=0; i < grid.length; i++) grid[i][grid[0].length-1] = false;
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {		
		return grid; // TODO YOUR CODE HERE
	}
}
