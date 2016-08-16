import java.util.Scanner;
/**
*COMP 1210.
*Project04
*@author Mathew Coggins
*09/22/2015
*/
public class CylinderApp {
/**
  *@param args Command line arguments not used.
  *this program gets user input for label, height, and radius of a cylinder
  *and then prints the expected output while calculating
  *the diameter, volume, circumference, and area of that cylinder.
  */
   public static void main(String[] args) {
      double radiusIn, heightIn;
      String labelIn;
      Scanner input = new Scanner(System.in);
   
   // get user input for label, radius, and height
      System.out.print("Enter label, radius, and height for a cylinder.\n");
      System.out.print("\tlabel: ");
      labelIn = input.nextLine();
      System.out.print("\tradius: ");
      radiusIn = Double.parseDouble(input.nextLine());
      System.out.print("\theight: ");
      heightIn = Double.parseDouble(input.nextLine());
      
      Cylinder cylinder2 = new Cylinder(labelIn, radiusIn, heightIn);
      System.out.print(cylinder2);
   }
}