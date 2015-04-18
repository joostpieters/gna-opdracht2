package gna;

import java.util.Collection;
//add
import java.io.*;

public class Board
{
	public int[][] iaSpel;
	// construct a board from an N-by-N array of tiles
	public Board( int[][] tiles )
	{
		iaSpel = tiles;
		//throw new RuntimeException("not implemented"); // TODO

	}
	
	// return number of blocks out of place
	public int hamming()
	{
		char[] s1 = iaSpel.toCharArray();
		console.out.printline(s1);
//		int shorter = Math.min(s1.length, s2.length);
//		int longest = Math.max(s1.length, s2.length);
//
//		int result = 0;
//		for (int i=0; i<shorter; i++) {
//			if (s1[i] != s2[i]) result++;
//		}
//
//		result += longest - shorter;
//
//		return result;

		//throw new RuntimeException("not implemented"); // TODO
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

