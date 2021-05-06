import java.util.HashMap;

public class Coins
{

  private static HashMap<Integer, Integer>  map = new HashMap<>();

  static int minCoins(int coins[], int amount)
  {
    if (amount == 0) return 0;

    int res = amount;
    int sub_res = 0;

    for (int i=0; i< coins.length; i++)
    {
      if (coins[i] <= amount)
      {
        if (map.containsValue(amount-coins[i]))
        {
          sub_res = map.get(amount-coins[i]);
        }
        else
        {
          sub_res = minCoins(coins, amount-coins[i]);
          map.put(amount-coins[i], sub_res);
        }
        if (sub_res + 1 < res)
        {
          res = sub_res + 1;
        }

      }
    }
    map.put(amount, res);
    return res;
  }
}
