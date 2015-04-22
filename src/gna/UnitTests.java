package gna;

import libpract.PriorityFunc;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * A number of JUnit tests for Solver.
 *
 * Feel free to modify these to automatically test puzzles or other functionality
 */
public class UnitTests {
  //http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
  private int[][] fncBoardReader(String strPath){
    BufferedReader br = null;
    List<Integer> lstTemp = new ArrayList<Integer>();
    try {

      String sCurrentLine;

      br = new BufferedReader(new FileReader(strPath));

      while ((sCurrentLine = br.readLine()) != null) {
        String[] strs = sCurrentLine.trim().split("\\s+");
        for (int i = 0; i < strs.length; i++) {
          lstTemp.add(Integer.parseInt(strs[i]));
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {

    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    //omzetting naar int[]
    int iCounter = -1, iWidth = (int) Math.sqrt(lstTemp.size() - 1);
    int[][] iaaTemp = new int[iWidth][iWidth];
    for (Integer iTemp : lstTemp) {
      if (iCounter != -1)
        iaaTemp[(iCounter / iWidth)][(iCounter % iWidth)] = iTemp;
      iCounter++;
    }


    return iaaTemp;
  }
  @Test
  public void IsSolvableTest() {
		int[][] iaSpel = fncBoardReader("/home/covert/code/gna/gna-opdracht2/boards/puzzle3x3-impossible.txt");
        Board SpelBord = new Board(iaSpel);
        assertEquals(false, SpelBord.isSolvable());
  }

  @Test
  public void SolverTest() {
    Solver solver = new Solver(new Board(fncBoardReader("/home/covert/code/gna/gna-opdracht2/boards/puzzle32.txt")), PriorityFunc.HAMMING);
    Collection<Board> temp = solver.solution();
  }
}
