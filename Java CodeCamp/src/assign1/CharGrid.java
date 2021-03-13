// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int row1 = 0, row2 = 0, col1 = 0, col2 = 0;
		int count = 0;
		for (int i=0; i < grid.length; i++){
			for (int j=0; j < grid[i].length; j++){
				if (grid[i][j] == ch){
					if (count == 0){
						row1 = i; row2 = i;
						col1 = j; col2 = j;
						count++;
					}
					else {
						if (i < row1) row1 = i;
						if (i > row2) row2 = i;
						if (j < col1) col1 = j;	
						if (j > col2) col2 = j;
					}
				}
			}
		}
		if (count==0) return 0;
		return (row2 - row1 + 1)*(col2 - col1 + 1); // TODO ADD YOUR CODE HERE
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int count = 0;
		for (int i=1; i < grid.length-1; i++){
			for (int j=1; j < grid[i].length-1; j++){
				if (ValidPlus(i, j)) count++;
			}
		}
		return count; // TODO ADD YOUR CODE HERE
	}
	
	private boolean ValidPlus(int i, int j){
		// Check the Left Arm
		int Lcount = 0;
		int col = j;
		while(col > 0){
			col--;
			if (grid[i][col] == grid[i][j]){
				Lcount++;
			}
			else break;
		}
		if (Lcount == 0) return false;
		
		// Check the Right Arm
		int Rcount = 0;
		col = j;
		while(col < grid[0].length-1){
			col++;
			if (grid[i][col] == grid[i][j]){
				Rcount++;
			}
			else break;
		}
		if (Rcount == 0) return false;
		if (Lcount != Rcount) return false;
		
		// Check the Upper Arm
		int UpCount = 0;
		int row = i;
		while (row > 0){
			row--;
			if (grid[row][j] == grid[i][j]){
				UpCount++;
			}
			else break;
		}
		if (UpCount == 0) return false;
		if (Lcount != UpCount) return false;
		
		// Check the Lower Arm
		int DownCount = 0;
		row = i;
		while (row < grid.length-1){
			row++;
			if (grid[row][j] == grid[i][j]){
				DownCount++;
			}
			else break;
		}
		if (DownCount == 0) return false;
		if (Lcount != DownCount) return false;
		return true;
	}

}
