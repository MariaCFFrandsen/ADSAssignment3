public class PrintArray {
  private String[][] a;

  public PrintArray()
  {
    a = new String[4][4];
    a[0][1] = "X";
    a[0][3] = "X";
    a[0][0] = "X";
    a[1][1] = "X";
    a[1][2] = "X";
    a[1][3] = "X";
    a[2][0] = "X";
    a[2][1] = "X";
    a[2][2] = "X";
    a[3][0] = "X";
    a[3][2] = "X";
    a[3][3] = "X";

    a[0][2] = "O";
    a[1][0] = "O";
    a[2][3] = "O";
    a[3][1] = "O";
  }

  public String[][] getA() {
    return a;
  }

  public static void presentBoard(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }


}
