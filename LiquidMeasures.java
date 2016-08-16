/**
  *
  */
import java.util.Scanner;
public class LiquidMeasures {
/**
  *Prints to std output.
  *
  *@param args Command line arguments (not used).
  */
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      int ounces = 0;
      int barrels = 0;
      int gallons = 0;
      int quarts = 0;
      
      //Prompt the user for liquid in ounces:
      System.out.print("Enter amount of liquid in ounces: ");
      ounces = userInput.nextInt();
      //Prompt for next line:
      System.out.println("Measures by volume:");
      //Prompt for barrels:
      System.out.println("\tBarrels: " + barrels);
      //Prompt for gallons:
      System.out.println("\tGallons: " + gallons);
      //Prompt for quarts:
      System.out.println("\tQuarts: " + quarts);
      //Prompt for next line:
      System.out.println(ounces + " oz = (" + barrels + " bl * 5376 oz) + ("
         + gallons + " gal * 128 oz) + (" + quarts + " qt * 32 oz)"); 
      if (ounces % 32 == 0){
      }
      else {
         System.out.println("Amount must be a multiple of 32");
      }
   }
}
