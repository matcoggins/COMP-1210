import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
  *@author Mathew Coggins
  *@version 12-01-15
  */
public class PreferredGoldCustomerTest {
/** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
     *test for the getBonusAwards method.
     */
   @Test public void getBonusAwardPointsTest() {
      PreferredGoldCustomer c = 
         new PreferredGoldCustomer("12345", "Example Name");
      double bonusAwardPoints = 1000;
      Assert.assertEquals(1000, c.getBonusAwardPoints(), .01);
   }
   /**
     *test for the setBonusAwards method.
     */
   @Test public void setBonusAwardPointsTest() {
      PreferredGoldCustomer c = 
         new PreferredGoldCustomer("12345", "Example Name");
      c.setBonusAwardPoints(1000);
      Assert.assertEquals(1000, c.getBonusAwardPoints(), 0.01);
   }
   /**
     *test for the calcAwardPoints method.
     */
   @Test public void calcAwardPointsTest() {
      double[] purchases = new double[100];
      PreferredGoldCustomer p = 
         new PreferredGoldCustomer("1000", "Jones, Mike");
      Assert.assertEquals(0, p.calcAwardPoints(), 0.01);
   }
      /**
     *test for the calcAwardPoints method.
     */
   @Test public void calcAwardPoints2Test() {
      PreferredSilverCustomer p = 
         new PreferredSilverCustomer("7887", "Lucky One");
      double[] purchases = {600};
      p.addPurchases(purchases);
      Assert.assertEquals(6000, p.calcAwardPoints());
   }
   /**
     *test for the toString method.
     */
   @Test public void toStringTest() {
      PreferredGoldCustomer c = 
         new PreferredGoldCustomer("12345", "Example Name");
      String variable  = c.toString();
      Assert.assertEquals(true, variable.contains("Tax"));
   }
     /**
     *test for the toString method.
     */
   @Test public void toString2Test() {
      PreferredSilverCustomer c = 
         new PreferredSilverCustomer("12345", "Example Name");
      double[] purchases = {300};
      c.addPurchases(purchases);
      String variable  = c.toString();
      Assert.assertEquals(false, 
         variable.contains("includes 1000 bonus points added to Award Points"));
   }
}
