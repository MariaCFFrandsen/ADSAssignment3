import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class NQueensTest
{
  private String[][] skakbræt= new String[4][4];

  /**
   * Note til lars: vi tog den lette udvej, og lagde vores private metoder herind, fordi
   * de tager imod coordinater i stedet for et array.
   *
   * Vores "O" er dronninger og vores "X" er tom plads i vores "skakbræt"
   */
  @BeforeEach
  public void NQueensTest()
  {

  }

  @Test
  public void testWrongQueen1()
  {
    fillArrayWithX();
    skakbræt[0][2] = "O";
    Assert.assertFalse(checkIfWeCanPutQueen(0,3));
  }

  @Test
  public void testWrongQueen2()
  {
    fillArrayWithX();
    skakbræt[0][2] = "O";
    Assert.assertFalse(checkIfWeCanPutQueen(1,3));
  }

  @Test
  public void testWrongQueen3()
  {
    fillArrayWithX();
    skakbræt[0][1] = "O";
    Assert.assertFalse(checkIfWeCanPutQueen(2,3));
  }

  @Test
  public void testCorrectQueen1()
  {
    fillArrayWithX();
    skakbræt[0][1] = "O";
    Assert.assertTrue(checkIfWeCanPutQueen(2,1));
  }

  @Test
  public void testCorrectQueen2()
  {
    fillArrayWithX();
    skakbræt[2][2] = "O";
    Assert.assertTrue(checkIfWeCanPutQueen(0,3));
  }

  @Test
  public void testCorrectQueen3()
  {
    fillArrayWithX();
    skakbræt[0][0] = "O";
    Assert.assertTrue(checkIfWeCanPutQueen(3,1));
  }


  public void fillArrayWithX()
  {
    for (int p = 0; p < skakbræt.length; p++) {
      for (int l = 0; l < skakbræt.length; l++) {
        skakbræt[p][l] = "X";
      }
    }
  }












  //i = 0
  //j == 2
  //skal være private, men public for test klassens skyld

  public boolean checkIfWeCanPutQueenHorizontal(int i, int j) {
    int a = i;
    int b = j;

    for (int k = 0; k < j; k++) {
      if (skakbræt[i][b - 1].equals("O"))
        return false;
      b--;
    }
    return true;
  }

  //i=2
  //j = 3
  //skal være private, men public for test klassens skyld

  public boolean checkIfWeCanPutQueenUpperDiagonal(int i, int j) {
    int a = i;
    int b = j;

    while (a > 0 && b > 0) {
      if (skakbræt[a - 1][b - 1].equals("O"))
        return false;

      a--;
      b--;
    }

    return true;
  }


  //i=1
  //j = 2
  //skal være private, men public for test klassens skyld

  public boolean checkIfWeCanPutQueenDownwardsDiagonal(int i, int j) {
    int a = i;
    int b = j;

    while (a < skakbræt.length - 1 && b > 0) {
      if (skakbræt[a + 1][b - 1].equals("O"))
        return false;

      a++;
      b--;
    }

    return true;
  }


  //skal være private, men public for test klassens skyld

  public boolean checkIfWeCanPutQueen(int i, int j) {
    boolean a;
    a = checkIfWeCanPutQueenHorizontal(i, j);
    if (a) {
      a = checkIfWeCanPutQueenUpperDiagonal(i, j);
      if (a) {
        a = checkIfWeCanPutQueenDownwardsDiagonal(i, j);
      }
    }
    return a;
  }



  //skal være private, men public for test klassens skyld

  public int checkCoordinatesOfLastQueen(int lastQueenX) {
    for (int i = 0; i < skakbræt.length; i++) {
      if(skakbræt[i][lastQueenX].equals("O"))
        return i;
    }
    return 0;
  }

}
