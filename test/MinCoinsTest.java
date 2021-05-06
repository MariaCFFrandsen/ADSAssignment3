import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinCoinsTest
{


  private int array[] = {22, 10, 7, 1};


  @Test
  public void minCoinsZero()
  {
    Assert.assertEquals(0, Coins.minCoins(array, 0));
  }

  @Test
  public void minCoinsOne()
  {
    Assert.assertEquals(1, Coins.minCoins(array, 1));
  }

  @Test
  public void minCoins60()
  {
    Assert.assertEquals(6, Coins.minCoins(array, 60));
  }

}
