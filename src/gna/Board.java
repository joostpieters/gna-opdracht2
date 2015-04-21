package gna;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Board
{
	private int[][] iaSpel;
	// construct a board from an N-by-N array of tiles
	public Board( int[][] tiles )
	{
		iaSpel = tiles;
		//throw new RuntimeException("not implemented"); // TODO
	}
	
	// return number of blocks out of place
	public int hamming()
	{
		throw new RuntimeException("not implemented"); // TODO
	}
	
	// return sum of Manhattan distances between blocks and goal
	public int manhattan()
	{
		int iCounter = 0;
		for(int x; x < iaSpel.length; x++)
		{
			for(int y; y < iaSpel.length; y++)
			{
				if(iaSpel[x][y] == (x*iaSpel.length + y))
				{
						continue;
					} else {
						iCounter += Math.abs((iaSpel[x][y] / iaSpel.length) - x);
						iCounter += Math.abs((iaSpel[x][y] % iaSpel.length) - y);
				}
			}
		}
		return iCounter;
	}

	// does this board position equal y
	public boolean equals(Object y)
	{
		return y == this;
	}
	
	// return a Collection of all neighboring board positions
	public Collection<Board> neighbors()
	{
		Collection<Board> idxCollection = new ArrayList<Board>();

		int[] iaNull = fncFindLoc(0);
		if (iaNull[0] != iaSpel.length)
		{
			// een rechter buur
			int[][] iaNeighbour = iaSpel;
			iaNeighbour[iaNull[0]][iaNull[1]] = iaNeighbour[iaNull[0]+1][iaNull[1]];
			iaNeighbour[iaNull[0+1]][iaNull[1]] = 0;
			idxCollection.add(new Board(iaNeighbour));
		}
		if (iaNull[0] != 0)
		{
			//een linker buur
			int[][] iaNeighbour = iaSpel;
			iaNeighbour[iaNull[0]][iaNull[1]] = iaNeighbour[iaNull[0]-1][iaNull[1]];
			iaNeighbour[iaNull[0-1]][iaNull[1]] = 0;
			idxCollection.add(new Board(iaNeighbour));
		}
		if (iaNull[1] != iaSpel.length)
		{
			//een onder buur
			int[][] iaNeighbour = iaSpel;
			iaNeighbour[iaNull[0]][iaNull[1]] = iaNeighbour[iaNull[0]][iaNull[1-1]];
			iaNeighbour[iaNull[0]][iaNull[1-1]] = 0;
			idxCollection.add(new Board(iaNeighbour));
		}
		if(iaNull[1] != 0)
		{
			//een boven buur
			int[][] iaNeighbour = iaSpel;
			iaNeighbour[iaNull[0]][iaNull[1]] = iaNeighbour[iaNull[0]][iaNull[1+1]];
			iaNeighbour[iaNull[0]][iaNull[1+1]] = 0;
			idxCollection.add(new Board(iaNeighbour));
		}

		return idxCollection;
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

	private int[] fncFindLoc(int iFind)
	{
		for(int x; x < iaSpel.length; x++)
		{
			for (int y; y < iaSpel.length; y++)
			{
				if (iaSpel[x][y] == iFind)
				{
					int[] iaReturn = {x,y};
				}
			}
		}
		return iaReturn;
	}
}

