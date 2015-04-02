package gna;

import java.util.Collection;

public class Board
{
	// construct a board from an N-by-N array of tiles
	public Board( int[][] tiles )
	{
		throw new RuntimeException("not implemented"); // TODO
	}
	
	// return number of blocks out of place
	public int hamming()
	{
		throw new RuntimeException("not implemented"); // TODO
	}
	
	// return sum of Manhattan distances between blocks and goal
	public int manhattan()
	{
		throw new RuntimeException("not implemented"); // TODO
	}
	
	// does this board position equal y
	public boolean equals(Object y)
	{
		throw new RuntimeException("not implemented"); // TODO
	}
	
	// return a Collection of all neighboring board positions
	public Collection<Board> neighbors()
	{
		throw new RuntimeException("not implemented"); // TODO
	}
	
	// return a string representation of the board
	public String toString()
	{
		return "<empty>"; // TODO
	}

	// is the initial board solvable?
	public boolean isSolvable()
	{
		throw new RuntimeException("not implemented"); // TODO
	}
}

