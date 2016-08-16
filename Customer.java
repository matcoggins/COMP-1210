import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.Comparator;
/**
  *@author Mathew Coggins
  *@version 12-01-15
  */
public abstract class Customer implements Comparable<Customer> {
// instance variables
   protected String category;
   protected String acctNumber;
   protected String name;
   protected double[] purchases;

/**
  *constant varaibles.
  */
   public static final double SALES_TAX_RATE = 0.08;
   
// constructor
/**
  *@param acctNumberIn this is the parameter
  *@param nameIn this is the parameter
  */
   public Customer(String acctNumberIn, String nameIn) {
      acctNumber = acctNumberIn;
      name = nameIn;
      purchases = new double[0];
   }
/**method for get acctNumber.
  *
  *@return acctNumber
  */
   public String getAcctNumber() {
      return acctNumber;
   }
/**
  *method for set acctNumber.
  *@param acctNumberIn this is the parameter
  */
   public void setAcctNumber(String acctNumberIn) {
      acctNumber = acctNumberIn;
   }
/**
  *getName method.
  *@return name
  */
   public String getName() {
      return name;
   }
/**
  *setName method.
  *@param nameIn this is the parameter
  */
   public void setName(String nameIn) {
      name = nameIn;
   }
/**
  *getPurchases method.
  *@return purchases
  */
   public double[] getPurchases() {
      return purchases;
   }
/**
  *setPurchases method.
  *@param purchasesIn this is the parameter
  */
   public void setPurchases(double[] purchasesIn) {
      purchases = purchasesIn;
   }
/**
  *addPurchases method.
  *@param purchasesIn this is the parameter0
  */
   public void addPurchases(double...purchasesIn) {
      for (int i = 0; i < purchasesIn.length; i++) {
         purchases = Arrays.copyOf(purchases, purchases.length + 1);
         purchases[purchases.length - 1] = purchasesIn[i];
      }
   }
/**
  *deletePurchases method.
  *@param purchasesIn this is the parameter
  */
   public void deletePurchases(double...purchasesIn) {
      for (int i = 0; i < purchasesIn.length; i++) {
         for (int x = 0; x < purchasesIn.length; x++) {
            if (purchasesIn[i] == purchasesIn[x]) {
               for (int y = x; y < purchases.length - 1; y++) {
                  purchases[y] = purchases[y + 1];
               }
               purchases = Arrays.copyOf(purchases, purchases.length - 1);
            }
            //Arrays.copyOf(purchases, purchases.length - 1);
         }
      }
   }
/**
  *calcSubtotal method.
  *@return subtotal
  */
   public double calcSubtotal() {
      double subtotal = 0.0;
      for (int i = 0; i < purchases.length; i++) {
         subtotal = subtotal + purchases[i];
      }
      return subtotal;
   }
/**
  *calcTotal method.
  *@return total
  */
   public double calcTotal() {
      double total = calcSubtotal() * SALES_TAX_RATE;
      return total + calcSubtotal();
   }
/**
  *toString method.
  *@return result
  */
   public String toString() {
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      String result = "Preferred Customer" + "\nAcctNo/Name: "
         + acctNumber + " " + name + "\nSubtotal: " + df.format(calcSubtotal())
         + "\nTax: " + df.format((calcSubtotal()) * SALES_TAX_RATE)
         + "\nTotal: " + df.format(calcTotal()) + "\nAward Points: "
         + calcAwardPoints();
      return result;
   }
  /**
    *calcAwardPoints method.
    *@return abstract
    */
   public abstract int calcAwardPoints();
/**
  *@param object this is the parameter.
  *@return compareTo.
  */
   public int compareTo(Customer object) {
      return name.toLowerCase()
         .compareTo(object.getName().toLowerCase());
   }
}