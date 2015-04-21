package gna;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import libpract.PriorityFunc;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * A number of JUnit tests for Solver.
 *
 * Feel free to modify these to automatically test puzzles or other functionality
 */
public class UnitTests {
  //http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
  private int[][] fncBoardReader(String strPath){
    BufferedReader br = null;
    String strTemp = "";
    try {

      String sCurrentLine;

      br = new BufferedReader(new FileReader(strPath));

      while ((sCurrentLine = br.readLine()) != null) {
        strTemp += " " + sCurrentLine;
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    //omzetting naar int[]
    int[] iaTemp = new int[strTemp.length()];
    for (int i = 0; i < strTemp.length();i++){
     iaTemp[i] = Integer.parseInt(strTemp.split("")[i]);
    }

    //omzetting naar int[][]
    int[][] iaaTemp = new int[iaTemp[0]][iaTemp[0]];
    for(int i = 1; i < iaTemp.length; i++){
      iaaTemp[(int)(i / iaTemp[0])][i % iaTemp[0]] = iaTemp[i];
    }
  return iaaTemp;
  }
  @Test
  public void IsSolvableTest() {
		int[][] iaSpel = fncBoardReader("./board/puzzle3x3-impossible.txt");
        Board SpelBord = new Board(iaSpel);
        assertEquals(false, SpelBord.isSolvable());
  }
}
