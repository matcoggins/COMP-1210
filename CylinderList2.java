import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
/**
*COMP 1210.
*Project05
*@author Mathew Coggins
*10/04/2015
*/
public class CylinderList2 {
   private String cylinders;
   private Cylinder[] cyList = new Cylinder[100];
   private int numElements = 0;
// Constructor

/**
  *@param cylindersIn this is the parameter
  *@param cyListIn this is the parameter
  *@param mentsIn this is the parameter
  */
   public CylinderList2(String cylindersIn, Cylinder[] cyListIn, int mentsIn) {
      cylinders = cylindersIn;
      cyList = cyListIn;
      numElements = mentsIn;
   }
   
// Methods

/**
  *@param getName
  *@return cylinders
  */
   public String getName() {
      return cylinders;
   }
   /**
     *@param getList
     *@return cyList
     */
   public Cylinder[] getList() {
      return cyList;
   }
/**
  *@param numberOfCylinders
  *@return int
  */
   public int numberOfCylinders() {
      return numElements;
   }
/**
  *@param totalArea
  *@return totalArea
  */
   public double totalArea() {
      double totalArea = 0.0;
      int index = 0;
      while (index < numberOfCylinders()) {
         totalArea += cyList[index].area();
         index++;
      }
      return totalArea;
   }
   /**
     *@param totalVolume
     *@return totalVolume
     */
   public double totalVolume() {
      double totalVolume = 0.0;
      int index = 0;
      while (index < numberOfCylinders()) {
         totalVolume += cyList[index].volume();
         index++;
      }
      return totalVolume;
   }
   /**
     *@param totalHeight
     *@return totalHeight
     */
   public double totalHeight() {
      double totalHeight = 0.0;
      int index = 0;
      while (index < numberOfCylinders()) {
         totalHeight += cyList[index].getHeight();
         index++;
      }
      return totalHeight;
   }
   /**
     *@param totalDiameter
     *@return totalDiameter
     */
   public double totalDiameter() {
      double totalDiameter = 0.0;
      int index = 0;
      while (index < numberOfCylinders()) {
         totalDiameter += cyList[index].diameter();
         index++;
      }
      return totalDiameter;
   }
   /**
     *@param averageArea
     *@return averageArea
     */
   public double averageArea() {
      double avgArea = 0.0;
      if (numberOfCylinders() != 0) {
         avgArea = (totalArea() / numberOfCylinders());
      }
      return avgArea;
   }
   /**
     *@param averageVolume
     *@return averageVolume
     */
   public double averageVolume() {
      double avgVolume = 0.0;
      if (numberOfCylinders() == 0) {
         avgVolume = 0; 
      }
      else if (numberOfCylinders() != 0) {
         avgVolume = (totalVolume() / numberOfCylinders());
      }
      return avgVolume;
   }
   /**
     *@param toString
     *@return result
     */
   public String toString() {
      String result = "\n" + cylinders + "\n";
      int index = 0;
      while (index < numElements) {
         result += "\n" + cyList[index] + "\n";
         index++;
      }
      return result;
   }
   /**
     *@param summaryInfo
     *@return result
     */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = "----- " + getName() + " Summary -----" 
         + "\nNumber of Cylinders: " + numberOfCylinders()
         + "\nTotal Area: " + df.format(totalArea())
         + "\nTotal Volume: " + df.format(totalVolume())
         + "\nTotal Height: " + df.format(totalHeight())
         + "\nTotal Diameter: " + df.format(totalDiameter())
         + "\nAverage Area: " + df.format(averageArea())
         + "\nAverage Volume: " + df.format(averageVolume());
      return result;
   }
   /**
    *reads in ctlinder list data and creates a 
    *CylinderList object.
    *
    *@param fileNameIn for fileName to read
    *@throws IOException from scanning input file.
    *@return CylinderList
    *
    */
   public CylinderList2 readFile(String fileNameIn) throws IOException {
   
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Cylinder[] listCs = new Cylinder[100];
      double radius = 0;
      double height = 0;
      String label = "";
      int numCyl = 0;
      
      cylinders = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         radius = Double.parseDouble(scanFile.nextLine());
         height = Double.parseDouble(scanFile.nextLine());
         
         Cylinder c = new Cylinder(label, radius, height);
         listCs[numCyl] = c;
         numCyl++;
      }
      CylinderList2 cL = new CylinderList2(cylinders, listCs, numCyl);
      return cL;
   }
   /**
     *add cylinder object to the list.
     *@param labelIn this is the parameter
     *@param radiusIn this is the parameter
     *@param heightIn this is the parameter
     *
     */
   public void addCylinder(String labelIn, double radiusIn, double heightIn) {
      Cylinder c = new Cylinder(labelIn, radiusIn, heightIn);
      cyList[numElements] = c;
      numElements++;
   }
   /**
     *deletes a cylinder if found.
     *@param labelIn for label
     *@return result
     */
   public Cylinder deleteCylinder(String labelIn) {
      Cylinder deletedCyl = null;
      for (int i = 0; i < numElements; i++) {
         if (cyList[i].getLabel().equalsIgnoreCase(labelIn)) {
            deletedCyl = cyList[i];
            for (int j = i; j < numElements - 1; j++) {
               cyList[j] = cyList[j + 1];
            }
            cyList[numElements - 1] = null;
            numElements--;
            break;
         }
      }
      return deletedCyl;
   }
   /**
     *finds a cylinder.
     *@param labelIn for label
     *@return null
     */
   public Cylinder findCylinder(String labelIn) {
      Cylinder findCyl = null;
      for (int i = 0; i < numElements; i++) {
         if (cyList[i].getLabel().equalsIgnoreCase(labelIn)) {
            findCyl = cyList[i];
            break;
         }
      }
      return findCyl;
   }
   /**
     *finds cylinder with smallest radius.
     *@param findCylinderWithSmallestRadius
     *@return null
     */
   public Cylinder findCylinderWithSmallestRadius() {
      if (numElements == 0) {
         return null;
      }
      int i = 0;
      int j = 0;
      while (j < numElements) {
         if (cyList[j].getRadius() < cyList[i].getRadius()) {
            i = j;
         }
         j++;
      }
      return cyList[i];
   }
   /**
     *finds cylinder with largest radius.
     *@param findCylinderWithLargestRadius
     *@return null
     */
   public Cylinder findCylinderWithLargestRadius() {
      if (numElements == 0) {
         return null;
      }
      int i = 0;
      int j = 0;
      while (j < numElements) {
         if (cyList[j].getRadius() > cyList[i].getRadius()) {
            i = j;
         }
         j++;
      }
      return cyList[i];
   }
/**
  *finds cylinder with smallest height.
  *@param findCylinderWithSmallestHeight
  *@return null
  */
   public Cylinder findCylinderWithSmallestHeight() {
      if (numElements == 0) {
         return null;
      }
      int i = 0;
      int j = 0;
      while (j < numElements) {
         if (cyList[j].getRadius() < cyList[i].getRadius()) {
            i = j;
         }
         j++;
      }
      return cyList[i];
   }
   /**
     *finds cylinder with largest height.
     *@param findCylinderWithLargestHeight
     *@return null
     */
   public Cylinder findCylinderWithLargestHeight() {
      if (numElements == 0) {
         return null;
      }
      int i = 0;
      int j = 0;
      while (j < numElements) {
         if (cyList[j].getRadius() > cyList[i].getRadius()) {
            i = j;
         }
         j++;
      }
      return cyList[i];
   }
}