import java.text.DecimalFormat;
/**
*COMP 1210.
*Project05
*@author Mathew Coggins
*09/22/2015
*/
public class Cylinder {
// declare instance variables
   private String label;
   private double radius = 0;
   private double height = 0;
   
// declare class variables
   private static int count = 0;

// constructor

/**
  *@param labelIn this is the parameter
  *@param radiusIn this is the parameter
  *@param heightIn this is the parameter
  */
   public Cylinder(String labelIn, double radiusIn, double heightIn) {
      label = labelIn.trim();
      radius = radiusIn;
      height = heightIn;
   }
   
// methods

/**
  *@param getLabel
  *@return label
  */
   public String getLabel() {
      return label;
   }
   /**
     *@param labelIn this is the parameter
     *@return boolean
     *
     *
     *
     *
     *
     */
   public boolean setLabel(String labelIn) {
      if (labelIn == null) {
         return false;
      }
      else {
         label = labelIn.trim();
         return true;
      } 
   }
   /**
     *@param getRadius
     *@return radius
     */
   public double getRadius() {
      return radius;
   }
   /**
     *@param radiusIn this is the parameter
     */
   public void setRadius(double radiusIn) {
      radius = radiusIn;
   }
   /**
     *@param getHeight
     *@return height
     */
   public double getHeight() {
      return height;
   }
   /**
     *@param heightIn this is the parameter
     */
   public void setHeight(double heightIn) {
      height = heightIn;  
   }
   /**
     *@param diameter
     *@return diameter
     */
   public double diameter() {
      double diameter = 2 * radius;
      return diameter;
   }
   /**
     *@param circumference
     *@return circumference
     */
   public double circumference() {
      double circumference = 2 * Math.PI * radius;
      return circumference;
   }
   /**
     *@param area
     *
     *@return area
     */
   public double area() {
      double area = (2 * Math.PI * radius * height)
         + (2 * Math.PI * radius * radius);
      return area;
   }
   /**
     *@param volume
     *
     *@return volume
     */
   public double volume() {
      double volume = (Math.PI * radius * radius) * height;
      return volume;
   }
   /**
     *
     *@return string
     *
     *
     *
     *
     *
     *
     *
     */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##"); 
      return "\"" + label + "\"" + " is a cylinder with radius = "
         + df.format(radius) + " units and height = " + df.format(height)
         + " units," + "\n" + "which has diameter = " + df.format(diameter())
         + " units, circumference = " + df.format(circumference())
         + " units," + "\n" + "area = " + df.format(area())
         + " square units, and volume = "
         + df.format(volume()) + " cubic units.";
   } 
   /**
     *@param getCount
     *
     *@return count
     */
   public static int getCount() {
      return count;
   }
   /**
     *@param resetCount
     *
     *@return count
     */
   public static int resetCount() {
      count = 0;
      return count;
   }
   /**
     *@param obj this is the parameter
     *
     *@return false
     */
   public boolean equals(Object obj) {
      if (!(obj instanceof Cylinder)) {
         return false;
      }
      Cylinder c = (Cylinder) obj;
   
      return (label.equals(c.getLabel())
         && Math.abs(radius - c.getRadius()) < .00001
         && Math.abs(height - c.getHeight()) < .00001);
   }
   /**
     *@param hashCode
     *
     *@return 0
     */
   public int hashCode() {
      return 0;
   }
}