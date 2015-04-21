package gna;

import java.util.ArrayList;
import java.util.Collection;

import libpract.PriorityFunc;

public class Solver
{
	Collection<Board> coBoards;
	/**
	 * Finds a solution to the initial board.
	 *
	 * @param priority is either PriorityFunc.HAMMING or PriorityFunc.MANHATTAN
	 */
	public Solver(Board initial, PriorityFunc priority)
	{
		coBoards = new ArrayList<Board>();
		// Use the given priority function (either PriorityFunc.HAMMING
		// or PriorityFunc.MANHATTAN) to solve the puzzle.
		if (priority == PriorityFunc.HAMMING) {

		} else if (priority == PriorityFunc.MANHATTAN) {
			// TODO
		} else {
			throw new IllegalArgumentException("Priority function not supported");
		}

		// TODO
	}
	

	/**
	 * Returns a Collection of board positions as the solution. It should contain the initial
	 * Board as well as the solution (if these are equal only one Board is returned).
	 */
	public Collection<Board> solution()
	{
		return null; // TODO
	}
}


