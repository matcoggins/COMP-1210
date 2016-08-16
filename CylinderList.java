import java.util.ArrayList;
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
   private ArrayList<Cylinder> cyList;
// Constructor

/**
  *@param cylindersIn this is the parameter
  *@param cyListIn this is the parameter
  */
   public CylinderList2(String cylindersIn, ArrayList<Cylinder> cyListIn) {
      cylinders = cylindersIn;
      cyList = cyListIn;
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
  *@param numberOfCylinders
  *@return int
  */
   public int numberOfCylinders() {
      return cyList.size();
   }
/**
  *@param totalArea
  *@return totalArea
  */
   public double totalArea() {
      double totalArea = 0.0;
      int index = 0;
      while (index < cyList.size()) {
         totalArea += cyList.get(index).area();
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
      while (index < cyList.size()) {
         totalVolume += cyList.get(index).volume();
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
      while (index < cyList.size()) {
         totalHeight += cyList.get(index).getHeight();
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
      while (index < cyList.size()) {
         totalDiameter += cyList.get(index).diameter();
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
      if (cyList.size() != 0) {
         avgArea = totalArea() / cyList.size();
      }
      return avgArea;
   }
   /**
     *@param averageVolume
     *@return averageVolume
     */
   public double averageVolume() {
      double avgVolume = 0.0;
      if (cyList.size() != 0) {
         avgVolume = totalVolume() / cyList.size();
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
      while (index < cyList.size()) {
         result += "\n" + cyList.get(index) + "\n";
         index++;
      }
      return result;
   }
   /**
     *@param summaryInfo
     *@return result
     */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,###,###,##0.0##");
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
      ArrayList<Cylinder> listCs = new ArrayList<Cylinder>();
      double radius = 0;
      double height = 0;
      String label = "";
      
      cylinders = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         radius = Double.parseDouble(scanFile.nextLine());
         height = Double.parseDouble(scanFile.nextLine());
         
         Cylinder c = new Cylinder(label, radius, height);
         listCs.add(c);
      }
      CylinderList cL = new CylinderList(cylinders, listCs);
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
      cyList.add(c);
   }
   /**
     *deletes a cylinder if found.
     *@param labelIn for label
     *@return result
     */
   public Cylinder deleteCylinder(String labelIn) {
      int index = -1;
      for (Cylinder c : cyList) {
         if (c.getLabel().equalsIgnoreCase(labelIn)) {
            index = cyList.indexOf(c);
            break;
         }
      }
      if (index >= 0) {
         String label = cyList.get(index).getLabel();
         double radius = cyList.get(index).getRadius();
         double height = cyList.get(index).getHeight();
         Cylinder cyl = new Cylinder(label, radius, height);
         cyList.remove(index);
      
         return cyl;
      }
      else {
         return null;
      }
   }
   /**
     *finds a cylinder.
     *@param labelIn for label
     *@return null
     */
   public Cylinder findCylinder(String labelIn) {
      int index = -1;
      for (Cylinder c : cyList) {
         if (c.getLabel().equalsIgnoreCase(labelIn)) {
            index = cyList.indexOf(c);
         }
      }
      if (index >= 0) {
         String label = cyList.get(index).getLabel();
         double radius = cyList.get(index).getRadius();
         double height = cyList.get(index).getHeight();
         Cylinder cyl = new Cylinder(label, radius, height);
         return cyl;
      }
      else {
         return null;
      }
   }
}