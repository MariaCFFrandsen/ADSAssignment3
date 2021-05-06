public class QueensGambit {
  private String[][] array;

  public String[][] NQueens(int N) {
    array = new String[N][N];

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        array[i][j] = "X";
      }
    }

    int j = 0;
    int i = 0;
    int y = 0;
    int x = 0;
    boolean check = true;
    int lastQueenX = 0;
    int lastQueenY = 0;
    int startQueenX = 0;
    int startQueenY = 0;
    int numberOfResets = 0;
    boolean nyBool = true;

    while (true) {

      if (check) {
        array[y][x] = "O";
        lastQueenX = x;
        lastQueenY = y;
        if (checkQueenCounter() == N) {
          return array;
        }
      }

      x++;
      y = 0;
      check = false;
      while (y < N) {
        if (checkIfWeCanPutQueen(y, x)) {
          check = true;
          break;
        }

        y++;
      }


      if (!check) {

        while (nyBool) {
          array[lastQueenY][lastQueenX] = "X";
          //check om vi kan sætte et kryds under hvis ikke det er sidste linje
          if (lastQueenY + 1 != N) {
            boolean b = checkIfWeCanPutQueen(lastQueenY + 1, lastQueenX);
            if (b) {
              array[lastQueenY + 1][lastQueenX] = "O";
              lastQueenY += 1;
              nyBool = false;
            }
            else
            {
              lastQueenY++;
            }
          } else {
            int i1 = checkCoordinatesOfLastQueen(lastQueenX - 1);
            lastQueenX = lastQueenX - 1;
            lastQueenY = i1;
          }
        }
        x = lastQueenX;
        nyBool = true;
      }


      if (checkQueenCounter() == N) {
        return array;
      }
/*
                    if (lastQueenY + 1 == N) {
                        int i1 = checkCoordinatesOfLastQueen(lastQueenX - 1);
                        array[i1][lastQueenX-1] = "X";

                    }


                    if (lastQueenY + 1 != N && checkIfWeCanPutQueen(lastQueenY + 1, lastQueenX)) {
                        array[lastQueenY + 1][lastQueenX] = "O";
                        lastQueenY += 1;
                        nyBool = false;
                    }
                }



 */





            /*
            if (!check) {
                array[lastQueenY][lastQueenX] = "X";
                for (int k = lastQueenY; k < N; k++) {
                    x--;
                    if (checkIfWeCanPutQueen(lastQueenY + 1, lastQueenX)) {
                        array[lastQueenY + 1][lastQueenX] = "O";
                        break;
                    }
                }
            }
             */
            /*
            if (!check && x == N - 1) {
                array[startQueenY][startQueenX] = "X";
                if (startQueenY + 1 != N) {
                    for (int p = 0; p < array.length; p++) {
                        for (int l = 0; l < array.length; l++) {
                            array[p][l] = "X";
                        }
                    }
                    array[startQueenY + 1][startQueenX] = "O";
                    startQueenY = startQueenY + 1;
                    i = -1;
                    y = 0;
                    x = 0;
                    QueenCounter = 1;
                } else {
                    return null;
                }
            }
             */

    }

  }

  //skal være private, men public for test klassens skyld
  public int checkQueenCounter() {
    int counter = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length ; j++) {
        if(array[i][j].equals("O"))
          counter++;
      }
    }
    return counter;
  }


  //i = 0
  //j == 2
  //skal være private, men public for test klassens skyld

  public boolean checkIfWeCanPutQueenHorizontal(int i, int j) {
    int a = i;
    int b = j;

    for (int k = 0; k < j; k++) {
      if (array[i][b - 1].equals("O"))
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
      if (array[a - 1][b - 1].equals("O"))
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

    while (a < array.length - 1 && b > 0) {
      if (array[a + 1][b - 1].equals("O"))
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
    for (int i = 0; i < array.length; i++) {
      if(array[i][lastQueenX].equals("O"))
        return i;
    }
    return 0;
  }

}
