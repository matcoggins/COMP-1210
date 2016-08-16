import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Mathew Coggins
 * @version 12-01-15
 */
public class PreferredCustomerTest {
/**Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
/**
  *Test for getAcctNumber.
  */
   @Test public void getAcctNumberTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      Assert.assertEquals("12345", c.getAcctNumber());
   }
/**
  *Test for setAcctNumber.
  */
   @Test public void setAcctNumberTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      c.setAcctNumber("3");
      Assert.assertEquals("3", c.getAcctNumber());
   }
/**
  *Test for getName.
  */
   @Test public void getNameTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      Assert.assertEquals("Example Name", c.getName());
   }
/**
  *Test for setName.
  */
   @Test public void setNameTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      c.setName("Name");
      Assert.assertEquals("Name", c.getName());
   }
/**
  *Test for getPurchases.
  */
   @Test public void getPurchasesTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      double[] purchases = {1, 2, 3, 4};
      c.addPurchases(purchases);
      Assert.assertArrayEquals(purchases, c.getPurchases(), 0.01);
   }
/**
  *Test for setPurchases.
  */
   @Test public void setPurchasesTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      double[] purchases;
      purchases = new double[1];
      c.setPurchases(purchases);
      Assert.assertEquals(purchases, c.getPurchases());
   }
/**
  *Test for addPurchases.
  */
   @Test public void addPurchasesTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      double[] purchases = {1, 2, 3, 4};
      c.addPurchases(purchases);
      Assert.assertArrayEquals(purchases, c.getPurchases(), 0.01);
   }
/**
  *Test for deletePurchases.
  */
   @Test public void deletePurchasesTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      double[] purchases = {1, 2, 3, 4};
      double[] purchasesIn = {1, 3};
      c.addPurchases(purchases);
      c.deletePurchases(purchasesIn);
      double[] result = {2, 4};
      Assert.assertArrayEquals(result, c.getPurchases(), 0.01);
   }
/**
  *Test for calcTotal.
  */
   @Test public void calcTotalTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      double[] purchases = {1, 2, 3, 4};
      c.addPurchases(purchases);
      double x = 1.0 + 2 + 3 + 4;
      x = x * .08 + x;
      Assert.assertEquals(x, c.calcTotal(), .01);
   }
/**
  *Test for calcSubtotal.
  */
   @Test public void calcSubtotalTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      double[] purchases = {1, 2, 3, 4};
      c.addPurchases(purchases);
      double x = 1.0 + 2 + 3 + 4;
      Assert.assertEquals(x, c.calcSubtotal(), .01);
   }
/**
  *Test for toString.
  */
   @Test public void toStringTest() {
      PreferredCustomer c = new PreferredCustomer("12345", "Example Name");
      String variable = c.toString();
      Assert.assertEquals(true, variable.contains("Tax"));
   }
/**
  *Test for calcAwardPoints.
  */
   @Test public void calcAwardPointsTest() {
      double[] purchases = new double[100];
      PreferredCustomer p = new PreferredCustomer("1000", "Jones, Mike");
      Assert.assertEquals(0, p.calcAwardPoints(), 0.01);
   }
}