package gna;

import libpract.PriorityFunc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solver
{
	PriorityQueue oQue;
	Collection<Board> coBoards;
	/**
	 * Finds a solution to the initial board.
	 *
	 * @param priority is either PriorityFunc.HAMMING or PriorityFunc.MANHATTAN
	 */
	public Solver(Board initial, PriorityFunc priority)
	{
		if (!initial.isSolvable()) {
			System.out.println("not solvable");
			return;
		}
		coBoards = new ArrayList<Board>();
		// Use the given priority function (either PriorityFunc.HAMMING
		// or PriorityFunc.MANHATTAN) to solve the puzzle.
		if (priority == PriorityFunc.HAMMING) {
			coBoards = new ArrayList<Board>();
			coBoards.add(initial);

			Collection<Board> temp = new ArrayList<Board>();
			Collection<Board> temptemp = new ArrayList<Board>();
			temp.addAll(initial.neighbors());
			while (true) {
				for (Board boTemp : temp) {
					for (Board boNeighbour : boTemp.neighbors()) {
						if (boTemp.hamming() != boNeighbour.hamming()) {
							temptemp.add(boNeighbour);
							System.out.println(boNeighbour.hamming());
						} else if (boNeighbour.hamming() <= 1) {
							coBoards.add(boNeighbour);
							return;
						}
					}
				}
				coBoards.addAll(temp);
				temp.clear();
				temp.addAll(temptemp);
				temptemp.clear();
			}


		} else if (priority == PriorityFunc.MANHATTAN) {
			Comparator<Board> comparator = new BoardPriorityComparatorManhattan();
			PriorityQueue oQue = new PriorityQueue(1, comparator);
			initial.setSprongen(0);
			coBoards = new ArrayList<Board>();
			coBoards.add(initial);
			coBoards.addAll(initial.neighbors());
			oQue.addAll(coBoards);




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
		Collection<Board> coSolution = new ArrayList<Board>();
		for (Board boSelected : coBoards) {
			if (boSelected.hamming() == 0) {
				while (true) {
					for (Board tempBoard : boSelected.neighbors()) {

						if (tempBoard.getSprongen() < boSelected.getSprongen()) {
							coSolution.add(boSelected);
							if (tempBoard.getSprongen() != 0) {
								boSelected = tempBoard;
							} else {
								coSolution.add(tempBoard);
								return coSolution;
							}

						}
					}
				}
			}
		}
		return null;

	}
}


