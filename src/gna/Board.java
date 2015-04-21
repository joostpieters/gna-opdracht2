package gna;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Board
{
	private int[][] iaSpel;
	private int iSprongen;
	// construct a board from an N-by-N array of tiles
	public Board( int[][] tiles ){
		iaSpel = tiles;
		//throw new RuntimeException("not implemented"); // TODO
	}
	
	// return number of blocks out of place
	public int hamming(){
		int iCounter = 0;
		for(int x = 0; x < iaSpel.length; x++){
			for (int y = 0; y < iaSpel.length; y++){
				if (iaSpel[x][y] != (x * iaSpel.length + y)){
					iCounter++;
				}
			}
		}
		return iCounter;
	}
	
	// return sum of Manhattan distances between blocks and goal
	public int manhattan()
	{
		int iCounter = 0;
		for(int x = 0; x < iaSpel.length; x++){
			for(int y = 0; y < iaSpel.length; y++){
				if(iaSpel[x][y] == (x*iaSpel.length + y)){
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
		if (iaNull[0] != iaSpel.length){
			// een rechter buur
			Board iaNeighbour = new Board(fncSwitch(iaSpel,1,0));
			iaNeighbour.setSprongen(getSprongen() + 1);
			idxCollection.add(iaNeighbour);
		}
		if (iaNull[0] != 0){
			//een linker buur
			Board iaNeighbour = new Board(fncSwitch(iaSpel,-1,0));
			iaNeighbour.setSprongen(getSprongen() + 1);
			idxCollection.add(iaNeighbour);
		}
		if (iaNull[1] != iaSpel.length){
			//een onder buur
			Board iaNeighbour = new Board(fncSwitch(iaSpel,0,-1));
			iaNeighbour.setSprongen(getSprongen() + 1);
			idxCollection.add(iaNeighbour);
		}
		if(iaNull[1] != 0){
			//een boven buur
			Board iaNeighbour = new Board(fncSwitch(iaSpel,0,1));
			iaNeighbour.setSprongen(getSprongen() + 1);
			idxCollection.add(iaNeighbour);
		}

		return idxCollection;
	}

	// return a string representation of the board
	public String toString()
	{
		String strOutput="";
		for(int x = 0; x < iaSpel.length; x++){
			for(int y = 0; y < iaSpel.length; y++){
				strOutput += iaSpel[x][y];
			}
		}
		return strOutput;
	}

	// is the initial board solvable?
	public boolean isSolvable()
	{
		while (iaSpel[iaSpel.length-1][iaSpel.length-1] != 0){
			if (fncFindLoc(0)[0] != iaSpel.length ){
				iaSpel = fncSwitch(iaSpel,-1,0);
			}
			if(fncFindLoc(0)[1] != iaSpel.length){
				iaSpel = fncSwitch(iaSpel,0,-1);

			}
		}
		//één dim array
		int[] iaTemp = new int[(int) Math.pow(iaSpel.length,2)];
		for(int x = 0; x < iaSpel.length; x++){
			for (int y = 0; y < iaSpel.length; y++){
				iaTemp[x*iaSpel.length + y] = iaSpel[x][y];
			}
		}
		//formule toepassen
			//lijst itereren
		int iTeller = 1 ,iNoemer = 1;
		for(int i = 0; i < iaTemp.length - 1; i++) {
			for (int j = i + 1 ; j < iaTemp.length; j++){
				iTeller *= fncSingleFind(iaTemp, j) - fncSingleFind(iaTemp, i);
				iNoemer *= j - i;
			}
		}
		return (iTeller/iNoemer > 0);
	}
	//nominaal uitgewerkt
	private int[][] fncSwitch(int[][] iaTemp, int iX, int iY)
	{
		int[] iaNull = fncFindLoc(0);
		iaTemp[iaNull[0]][iaNull[1]] = iaTemp[iaNull[0] + iX][iaNull[1] + iY];
		iaTemp[iaNull[0] + iX][iaNull[1] + iY] = 0;
		return iaTemp;
	}
	private int[] fncFindLoc(int iFind)
	{
		for(int x = 0; x < iaSpel.length; x++){
			for (int y = 0; y < iaSpel.length; y++){
				if (iaSpel[x][y] == iFind){
					return new int[]{x,y};
				}
			}
		}
		return null;
	}
	private int fncSingleFind(int[] iaTemp, int iFind){
		for(int i = 0; i< iaTemp.length;i++){
			if(iaTemp[i] == iFind){
				return i;
			}
		}
		return -1;
	}

	//getters en setters iSprongen
	void setSprongen (int iTemp){
		iSprongen = Math.abs(iTemp);
	}

	int getSprongen(){
	return iSprongen;
	}

}

