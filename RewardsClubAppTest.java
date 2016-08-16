import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
/**
*@author Mathew Coggins
*@version 12-01-15
*/
public class RewardsClubAppTest {
/** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
   *test for main method
   *@throws IOException e
   *
   */
   @Test public void mainWFileTest() throws IOException {
      RewardsClubApp rewC = new RewardsClubApp();
      String[] args = {"customers.txt"};
      RewardsClubApp.main(args);
      Assert.assertEquals(Customer.SALES_TAX_RATE, 0.08, 0.01);
   }
   /**
   *test for main method
   *@throws IOException e
   */
   @Test public void mainWithoutFileNameTest() throws IOException {
      RewardsClubApp rewC = new RewardsClubApp();
      String[] args = {};
      RewardsClubApp.main(args);
      Assert.assertEquals(Customer.SALES_TAX_RATE, 0.08, 0.01);
   }
}