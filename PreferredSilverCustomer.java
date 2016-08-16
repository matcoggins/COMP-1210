import java.text.DecimalFormat;
/**
  *@author Mathew Coggins
  *@version 12-01-15
  */
public class PreferredSilverCustomer extends Customer {
   protected double discountRate = 0.05;
/**Constructor.
  *@param acctNumberIn this is the parameter
  *@param nameIn this is the parameter
  */
   public PreferredSilverCustomer(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Preferred Silver Customer";
   }
   /**
     *@return discountRate
     */
   public double getDiscountRate() {
      return discountRate;
   }
   /**
     *@param discountRateIn this is the parameter
     */
   public void setDiscountRate(double discountRateIn) {
      discountRate = discountRateIn;
   }
   /**
     *@return b
     */
   public int calcAwardPoints() {
      double a = super.calcSubtotal();
      int b = (int) a;
      return b * 10;
   }
   /**
     *@return sub
     */
   public double calcSubtotal() {
      double subtotal = 0.0;
      for (int i = 0; i < purchases.length; i++) {
         subtotal = subtotal + purchases[i];
      }
      return subtotal * (1 - discountRate);
   }
   /**
     *@return result
     */
   public String toString() {
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      String result = category + "\nAcctNo/Name: "
         + super.acctNumber + " " + name + "\nSubtotal: "
         + df.format(super.calcSubtotal()) + "\nTax: "
         + df.format((calcSubtotal()) * SALES_TAX_RATE)
         + "\nTotal: " + df.format(super.calcTotal())
         + "\nAward Points: " + calcAwardPoints()
         + "\n(includes 0.05 discount rate applied to Subtotal)";
      return result;
   }
}