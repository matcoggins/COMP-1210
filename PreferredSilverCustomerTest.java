import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
  *@author Mathew Coggins
  *@version 12-01-15
  */
public class PreferredSilverCustomerTest {
/** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
     *test for the getDiscountRate method.
     */
   @Test public void getDiscountRateTest() {
      PreferredSilverCustomer c = 
         new PreferredSilverCustomer("12345", "Example Name");
      double discountRate = 0.05;
      Assert.assertEquals(0.05, c.getDiscountRate(), 0.01);
   }
   /**
     *test for the setDiscountRate method.
     */
   @Test public void setDiscountRateTest() {
      PreferredSilverCustomer c = 
         new PreferredSilverCustomer("12345", "Example Name");
      c.setDiscountRate(0.05);
      Assert.assertEquals(0.05, c.getDiscountRate(), 0.01);
   }
   /**
     *test for the calcAwardPoints method.
     */
   @Test public void calcAwardPointsTest() {
      double[] purchases = new double[100];
      PreferredSilverCustomer p = 
         new PreferredSilverCustomer("1000", "Jones, Mike");
      Assert.assertEquals(0, p.calcAwardPoints(), 0.01);
   }
   /**
     *test for the calcSubtotal method.
     */
   @Test public void calcSubtotalTest() {
      PreferredSilverCustomer c = 
         new PreferredSilverCustomer("12345", "Example Name");
      double[] purchases = {1, 2, 3, 4};
      c.addPurchases(purchases);
      double x = 1.0 + 2 + 3 + 4;
      Assert.assertEquals(9.5, c.calcSubtotal(), 0.01);
   }
   /**
     *test for the toString method.
     */
   @Test public void toStringTest() {
      PreferredSilverCustomer c = 
         new PreferredSilverCustomer("12345", "Example Name");
      String variable  = c.toString();
      Assert.assertEquals(true, variable.contains("Tax"));
   }

}
