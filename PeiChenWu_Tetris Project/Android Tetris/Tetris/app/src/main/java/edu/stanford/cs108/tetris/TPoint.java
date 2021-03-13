//TPoint.java
/*
 This is just a trivial "struct" type class --
 it simply holds an int x/y point for use by Tetris,
 and supports equals() and toString().
 We'll allow public access to x/y, so this
 is not an object really.
 */
package edu.stanford.cs108.tetris;

public class TPoint {
    public int x;
    public int y;

    // Creates a TPoint based in int x,y
    public TPoint(int x, int y) {
        // questionable style but convenient --
        // params with same name as ivars

        this.x = x;
        this.y = y;
    }

    // Creates a TPoint, copied from an existing TPoint
    public TPoint(TPoint point) {
        this.x = point.x;
        this.y = point.y;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TPoint other = (TPoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	// Standard toString() override, produce
    // human-readable String from object
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
