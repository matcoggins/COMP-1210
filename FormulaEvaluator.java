import java.util.Scanner;
import java.text.DecimalFormat;
/**
  *COMP 1210
  *Project #3
  *@author Mathew Coggins
  *@version 09-09-15
  */
public class FormulaEvaluator {
/**
  *Evaluates a formula and prints the expected results
  *
  *@param args Command line arguments (not used).
  */
   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      String name = "";
      double value = 0.0;
      double result = 0.0;
      
      //Prompt the user for value of x
      System.out.print("Enter a value for x: ");	
      value = userInput.nextDouble();
      
      //Calculate and print the user input value of x:
      result = Math.pow(((9 * Math.pow(value, 3)) + (7 * Math.pow(value, 2))
         + (5 * value) + 3), 2)	* (Math.sqrt((8 * Math.pow(value, 4)) 
         + -(6 * Math.pow(value, 3)) + (4 * Math.pow(value, 2))
         + Math.abs(20 * value) + 1));
      System.out.print("Result: " + result);
      
      String end;
      end = String.valueOf(result);
       //Prints the # of digits left of decimal
      System.out.print("\n# digits to left of decimal point: ");
      System.out.println(end.indexOf("."));
      int length = end.length();
     
     //Prints the # of digits right of decimal
      System.out.print("# digits to right of decimal point: ");
      System.out.println(length - end.indexOf(".") - 1);
      
      //Prints the decimal format result for value of x 
      DecimalFormat df = new DecimalFormat("#,###,##0.0##");   
      System.out.print("Formatted Result: ");
      System.out.println(df.format(result));
   
   }
}