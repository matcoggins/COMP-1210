import java.util.Comparator;
/**
  *@author Mathew Coggins
  *@version 12-01-15
  */
public class TotalCompare implements Comparator<Customer> {
/**
  *@param Customer
  *@param c1 this is the parameter
  *@param c2 this is the parameter
  *@return 0
  */
   public int compare(Customer c1, Customer c2) {
      if (c1.calcTotal() > c2.calcTotal()) {
         return -1;
      }
      else if (c1.calcTotal() < c2.calcTotal()) {
         return 1;
      }
      return 0;
   }
}