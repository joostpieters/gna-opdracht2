package gna;

import java.util.Comparator;

public class BoardPriorityComparatorManhattan implements Comparator<Board> {
    @Override
    public int compare(Board oA, Board oB){
        if (oA.manhattan() + oA.getSprongen() < oB.manhattan() + oB.getSprongen()) {
            return -1;
        }
        if (oA.manhattan() + oA.getSprongen() > oB.manhattan() + oB.getSprongen()) {
            return 1;
        }
        return 0;
    }
}
