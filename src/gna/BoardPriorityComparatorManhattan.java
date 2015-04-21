package gna;

import java.util.Comparator;

public class BoardPriorityComparatorManhattan implements Comparator<Board> {
    @Override
    public int compare(Board oA, Board oB){
        if(oA.manhattan() < oB.manhattan()){
            return -1;
        }
        if(oA.manhattan() > oB.manhattan()){
            return 1;
        }
        return 0;
    }
}
