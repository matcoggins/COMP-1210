import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
/**
*COMP 1210.
*Project05
*@author Mathew Coggins
*10/04/2015
*/
public class CylinderListApp {
/**
  *
  *@param args - is not used.
  *@throws IOException from scanning input file.
  */
   public static void main(String[] args) throws IOException {
      ArrayList<Cylinder> myList = new ArrayList<Cylinder>();
      String cylinderListName = "";
      double radius = 0.0;
      double height = 0.0;
      String label = "";
   
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
   
      Scanner scanFile = new Scanner(new File(fileName));
      cylinderListName = scanFile.nextLine();
   
      while (scanFile.hasNext()) {
         radius = Double.parseDouble(scanFile.nextLine());
         height = Double.parseDouble(scanFile.nextLine());
         label = scanFile.nextLine();
         
         Cylinder c = new Cylinder(label, radius, height);
         myList.add(c);
      }
   
      CylinderList myCylinderList = new CylinderList(cylinderListName, myList);
   
      System.out.println(myCylinderList.toString());
      System.out.println(myCylinderList.summaryInfo());
   }
}