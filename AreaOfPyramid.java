/**
  *Prints the inserted values for base and slant height.
  *
  *Calculates the area for the given inserted values.
  */
import java.util.Scanner;
public class AreaOfPyramid {
/**
  *Prints to std output.
  *
  *@param args Command line arguments (not used).
  */
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      // print the first line:
      System.out.println("Enter values for base and slant height"
         + " of a pyramid: ");
      double base = 0;
      double slantHeight = 0;
      double areaofpyramid = 0;
      String finalText = "";
      
      //Prompt the user for base:
      System.out.print("\tbase = ");
      base = userInput.nextDouble();
      //Prompt the user for slant height:
      System.out.print("\tslant height = ");
      slantHeight = userInput.nextDouble();
      //Calculate the area:
      areaofpyramid = base * base + 4 * ((base * slantHeight) / 2);
      finalText = "A pyramid with base = " + base + " and slant height = "
         + slantHeight;
      System.out.print(finalText);
      System.out.println("\nhas an area of " + areaofpyramid + " square units.");
   }
}