public class main
{
  public static void main(String[] args)
  {
    int coins[] = {22, 10, 7, 1};
    int V = 80;
    System.out.println ( "Minimum coins required is "
        + Coins.minCoins(coins, V));


    //Coins.tester();
    PrintArray arrayPrinter = new PrintArray();
    QueensGambit skakbræt = new QueensGambit();
    arrayPrinter.presentBoard(skakbræt.NQueens(15));

  }
}
