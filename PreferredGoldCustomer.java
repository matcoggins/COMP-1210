import java.text.DecimalFormat;
/**
  *@author Mathew Coggins
  *@version 12-01-15
  */
public class PreferredGoldCustomer extends PreferredSilverCustomer {
   private int bonusAwardPoints = 1000;
   protected double discountRate = 0.15;

/**Constructor.
  *@param acctNumberIn this is the parameter
  *@param nameIn this is the parameter
  */
   public PreferredGoldCustomer(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Preferred Gold Customer";
      setDiscountRate(.15);
   }
   /**
     *@return bonusAwardPoints
     */
   public int getBonusAwardPoints() {
      return bonusAwardPoints;
   }
   /**
     *@param bonusAwardPointsIn this is the parameter
     */
   public void setBonusAwardPoints(int bonusAwardPointsIn) {
      bonusAwardPoints = bonusAwardPointsIn;
   }
   /**
     *@return b
     */
   public int calcAwardPoints() {
      if (super.calcSubtotal() > 500) {
         return 20 * (int) super.calcSubtotal()
            + bonusAwardPoints;
      }
      else {
         return 20 * (int) super.calcSubtotal();
      }
   }
   /**
     *@return result
     */
   public String toString() {
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      String result = "Preferred Gold Customer" + "\nAcctNo/Name: "
            + super.acctNumber + " " + name + "\nSubtotal: "
            + df.format(super.calcSubtotal()) + "\nTax: "
            + df.format((calcSubtotal()) * SALES_TAX_RATE)
            + "\nTotal: " + df.format(super.calcTotal())
            + "\nAward Points: " + (calcAwardPoints())
            + "\n(includes 0.15 discount rate applied to Subtotal)"
            + "\n(includes 1000 bonus points added to Award Points)";
      return result;
   }
}