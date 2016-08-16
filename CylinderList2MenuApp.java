import java.util.Scanner;
import java.io.IOException;
/**
*COMP 1210.
*Project06
*@author Mathew Coggins
*10/10/2015
*/
public class CylinderList2MenuApp {
/**
  *main method sets the variables and prints each input according to user.
  *@param args - is not used.
  *@throws IOException from scanning input file.
  */
   public static void main(String[] args) throws IOException {
      String nameList = "no list name";
      Cylinder[] myList = new Cylinder[100];
      int num = 0;
      CylinderList2 myCyls = new CylinderList2(nameList, myList, num);
      String fileName = "no file name";
      String label;
      double radius, height;
      String code = "";
      
      Scanner scan =  new Scanner(System.in);
      System.out.println("Cylinder List System Menu\n"
                       + "R - Read File and Create Cylinder List\n"
                       + "P - Print Cylinder List\n" 
                       + "S - Print Summary\n"  
                       + "A - Add Cylinder\n"
                       + "D - Delete Cylinder\n"
                       + "F - Find Cylinder\n"
                       + "Q - Quit");
                       
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
            
               myCyls = myCyls.readFile(fileName);
            
               System.out.println("\tFile read in and "
                              + "Cylinder List created\n");
               break; 
                    
            case 'P':
               System.out.println(myCyls);
               break;
               
            case 'S':
               System.out.println(myCyls.summaryInfo() + "\n");
               break;
               
            case 'A':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scan.nextLine());
               System.out.print("\tHeight: ");
               height = Double.parseDouble(scan.nextLine());
            
               myCyls.addCylinder(label, radius, height);
               System.out.println("\t*** Cylinder added ***\n");
               break;   
               
            case 'D':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               if (myCyls.deleteCylinder(label) != null) {
                  System.out.println("\t\"" + label + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;  
           
            case 'F':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               Cylinder f = myCyls.findCylinder(label);
            
               if (f != null) {
                  System.out.println(f);
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
                  
            case 'Q': case 'q':
               break;
               
            default:
               System.out.println("\t*** invalid code ***\n");
         }
      
      } while (!code.equalsIgnoreCase("Q"));  
   
   }
}