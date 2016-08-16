/** 
 * @author Mathew Coggins
 * @version 12-01-15
 */
public class PreferredCustomer extends Customer {
/**
  *@param nameIn this is the type parameter
  *@param acctNumberIn this is the type parameter
  */
   public PreferredCustomer(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Preferred Customer";
   }
/**
  *@return calcAwardPoints
  */
   public int calcAwardPoints() {
      double a = super.calcSubtotal();
      int b = (int) a;
      return b;
   }
}