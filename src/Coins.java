import java.util.HashMap;

public class Coins
{

  private HashMap<Integer, Integer> map = new HashMap<>();



  static int minCoins(int coins[], int amount)
  {
    if (amount == 0) return 0;

    // Initialize result
    int res = amount;

    // Try every coin that has smaller value than V
    for (int i=0; i< coins.length; i++)
    {
      if (coins[i] <= amount)
      {
        int sub_res = minCoins(coins, amount-coins[i]);

        // Check for INT_MAX to avoid overflow and see if
        // result can minimized
        if (sub_res + 1 < res)
          res = sub_res + 1;
      }
    }
    return res;
  }
}
