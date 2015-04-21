package gna;

import java.util.Comparator;

/**
 * Created by covert on 22/04/15.
 */

public class BoardPriorityComparatorHamming implements Comparator<Board> {
    @Override
    public int compare(Board oA, Board oB){
        if(oA.hamming() < oB.hamming()){
            return -1;
        }
        if(oA.hamming() > oB.hamming()){
            return 1;
        }
        return 0;
    }
}
