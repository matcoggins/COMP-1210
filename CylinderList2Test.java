import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
 /**
*COMP 1210.
*Project07
*@author Mathew Coggins
*10/26/2015
*/
public class CylinderList2Test {
/** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
     *test for getName method.
     */
   @Test public void getNameTest() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("cylinders", cyl1, 0);
      Assert.assertEquals("cylinders", cList.getName());
   }
   /**
     *test for getList method.
     */
   @Test public void getListTest() {
      Cylinder a = new Cylinder("a", 1, 3);
      Cylinder b = new Cylinder("b", 2, 4);
      Cylinder c = new Cylinder("c", 3, 5);
      Cylinder[] cyList = {a, b, c};
      CylinderList2 cList = new CylinderList2("ListIn", cyList, 3);
      Assert.assertEquals(cyList, cList.getList());
   }
   /**
     *test for NumberOfCylinders method.
     */
   @Test public void numberOfCylindersTest() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 2);
      Assert.assertEquals(2, cList.numberOfCylinders());
   }
   /**
     *test for totalArea method.
     */
   @Test public void totalAreaTest() {
      Cylinder a = new Cylinder("a", 1, 3);
      Cylinder b = new Cylinder("b", 2, 4);
      Cylinder c = new Cylinder("c", 3, 5);
      double var = a.area() + b.area() + c.area();
      Cylinder[] cyList = {a, b, c};
      CylinderList2 cList = new CylinderList2("ListIn", cyList, 3);
      Assert.assertEquals(var, cList.totalArea(), 0.01);
   }
   /**
     *test for totalVolume method.
     */
   @Test public void totalVolumeTest() {
      Cylinder a = new Cylinder("a", 1, 3);
      Cylinder b = new Cylinder("b", 2, 4);
      Cylinder c = new Cylinder("c", 3, 5);
      double var = a.volume() + b.volume() + c.volume();
      Cylinder[] cyList = {a, b, c};
      CylinderList2 cList = new CylinderList2("ListIn", cyList, 3);
      Assert.assertEquals(var, cList.totalVolume(), 0.01);
   }
   /**
     *test for totalHeight method.
     */
   @Test public void totalHeightTest() {
      Cylinder a = new Cylinder("a", 1, 3);
      Cylinder b = new Cylinder("b", 2, 4);
      Cylinder c = new Cylinder("c", 3, 5);
      double var = a.getHeight() + b.getHeight() + c.getHeight();
      Cylinder[] cyList = {a, b, c};
      CylinderList2 cList = new CylinderList2("ListIn", cyList, 3);
      Assert.assertEquals(var, cList.totalHeight(), 0.01);
   }
   /**
     *test for totalDiameter method.
     */
   @Test public void totalDiameter() {
      Cylinder a = new Cylinder("a", 1, 3);
      Cylinder b = new Cylinder("b", 2, 4);
      Cylinder c = new Cylinder("c", 3, 5);
      double var = a.diameter() + b.diameter() + c.diameter();
      Cylinder[] cyList = {a, b, c};
      CylinderList2 cList = new CylinderList2("ListIn", cyList, 3);
      Assert.assertEquals(var, cList.totalDiameter(), 0.01);
   }
   /**
     *test for averageArea method.
     */
   @Test public void averageAreaTest() {
      Cylinder a = new Cylinder("a", 1, 2);
      Cylinder b = new Cylinder("b", 3, 4);
      Cylinder c = new Cylinder("c", 5, 6);
      Cylinder[] cyl1 = {a, b, c};
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 3);
      Assert.assertEquals("Average Test", 165.45, cList.averageArea(), 0.01);
   }
   /**
     *test for averageArea method 2.
     */
   @Test public void averageAreaTest2() {
      CylinderList2 cList = new CylinderList2(null, null, 0);
      Assert.assertEquals("Average Test", 0, cList.averageArea(), 0.01);
   }
   /**
     *test for averageVolume method.
     */
   @Test public void averageVolumeTest() {
      Cylinder a = new Cylinder("a", 1, 2);
      Cylinder b = new Cylinder("b", 3, 4);
      Cylinder c = new Cylinder("c", 5, 6);
      Cylinder[] cyl1 = {a, b, c};
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 3);
      Assert.assertEquals("Average Test", 196.87, cList.averageVolume(), 0.01);
   }
   /**
     *test for averageVolume method 2.
     */
   @Test public void averageVolumeTest2() {
      CylinderList2 cList = new CylinderList2(null, null, 0);
      Assert.assertEquals("Average Test", 0, cList.averageVolume(), 0.01);
   }
   /**
     *test for toString method.
     */
   @Test public void toStringTest() {
      Cylinder c = new Cylinder("c", 1, 2);
      Cylinder[] list = {c};
      CylinderList2 cList = new CylinderList2("ListIn", list, 1);
      String var = cList.toString();
      Assert.assertEquals(true, var.contains("units"));
   }
   /**
     *test for summaryInfo method.
     */
   @Test public void summaryInfoTest() {
      Cylinder c = new Cylinder("c", 1, 2);
      Cylinder[] cyl1 = {c};
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      System.out.println(cList.summaryInfo());
   }
   /**
     *test for readFile method.
     *@throws IOException from scanning input file.
     */
   @Test public void readFileTest() throws IOException {
      Cylinder c = new Cylinder("c", 1, 2);
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList = cList.readFile("cylinder_1.dat");
      Assert.assertEquals(4, cList.numberOfCylinders());
   }
   /**
     *test for addCylinder method.
     */
   @Test public void addCylinderTest() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 5);
      Assert.assertEquals("Add Cylinder Tested", "Add Cylinder Tested");
   }
   /**
     *test for deleteCylinder method.
     */
   @Test public void deleteCylinderTest() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 5);
      cList.addCylinder("Example Two", 6, 15);
      cList.addCylinder("Example Three", 9, 10);
      Assert.assertEquals("Find Cylinder Tested", cyl1[1], 
         cList.deleteCylinder("Example Two"));
   }
   /**
     *test for deleteCylinder method.
     */
   @Test public void deleteCylinderTest2() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 5);
      cList.addCylinder("Example Two", 6, 15);
      cList.addCylinder("Example Three", 9, 10);
      Assert.assertEquals("Find Cylinder Tested", null, 
         cList.deleteCylinder("Example Four"));
   }
   /**
     *test for findCylinder method.
     */
   @Test public void findCylinderTest() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 5);
      cList.addCylinder("Example Two", 6, 15);
      cList.addCylinder("Example Three", 9, 10);
      Assert.assertEquals("Find Cylinder Tested", cyl1[1], 
         cList.findCylinder("Example Two"));
   }
    /**
      *test to findCylinder method 2.
      */
   @Test public void findCylinderTest2() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 5);
      cList.addCylinder("Example Two", 6, 15);
      cList.addCylinder("Example Three", 9, 10);
      Assert.assertEquals("Find Cylinder Tested", null, 
         cList.findCylinder("Example Four"));
   }
   /**
     *test to findSmallestRadius method.
     */
   @Test public void findSmallestRadiusTest() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 5);
      cList.addCylinder("Example Two", 6, 15);
      cList.addCylinder("Example Three", 9, 10);
      Assert.assertEquals("Find Cylinder Tested", cyl1[0], 
         cList.findCylinderWithSmallestRadius());
   }
   /**
     *test to findSmallestRadius method 2.
     */
   @Test public void findSmallestRadiusTest2() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 6, 5);
      cList.addCylinder("Example Two", 3, 15);
      cList.addCylinder("Example Three", 9, 10);
      Assert.assertEquals("Find Cylinder Tested", cyl1[1], 
         cList.findCylinderWithSmallestRadius());
   }
   /**
     *test to findSmallestRadius method 3.
     */
   @Test public void findSmallestRadiusTest3() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2(null, null, 0);
      Assert.assertEquals("Find Cylinder Tested", null, 
         cList.findCylinderWithSmallestRadius());
   }
   /**
     *test to findLargestRadius method.
     */
   @Test public void findLargestRadiusTest1() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 9, 5);
      cList.addCylinder("Example Two", 6, 15);
      cList.addCylinder("Example Three", 3, 10);
      Assert.assertEquals("Find Cylinder Tested", cyl1[0], 
         cList.findCylinderWithLargestRadius());
   }
   /**
     *test to findLargestRadius method 2.
     */
   @Test public void findLargestRadiusTest2() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 5);
      cList.addCylinder("Example Two", 9, 15);
      cList.addCylinder("Example Three", 6, 10);
      Assert.assertEquals("Find Cylinder Tested", cyl1[1], 
         cList.findCylinderWithLargestRadius());
   }
   /**
     *test for emptyLargestRadius.
     */
   @Test public void emptyFindLargestRadiusTest3() {
      CylinderList2 cList = new CylinderList2(null, null, 0);
      Assert.assertEquals("Find Cylinder", 
         null, cList.findCylinderWithLargestRadius());
   }
   /**
     *test for findSmallestHeight method.
     */
   @Test public void findSmallestHeightTest() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 10);
      cList.addCylinder("Example Two", 6, 15);
      cList.addCylinder("Example Three", 9, 5);
      Assert.assertEquals("Find Cylinder Tested", cyl1[2], 
         cList.findCylinderWithLargestHeight());
   }
   /**
     *test to findSmallestHeight method 2.
     */
   @Test public void findSmallestHeightTest2() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 6, 15);
      cList.addCylinder("Example Two", 3, 5);
      cList.addCylinder("Example Three", 9, 10);
      Assert.assertEquals("Find Cylinder Tested", cyl1[1], 
         cList.findCylinderWithSmallestHeight());
   }
   /**
     *test for emptyFindSmallestHeight.
     */
   @Test public void emptyFindSmallestHeightTest3() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2(null, null, 0);
      Assert.assertEquals("Find Cylinder Tested", null, 
         cList.findCylinderWithSmallestHeight());
   }
   /**
     *test for findLargetHeight method.
     */
   @Test public void findLargestHeightTest() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 3, 5);
      cList.addCylinder("Example Two", 6, 10);
      cList.addCylinder("Example Three", 9, 15);
      Assert.assertEquals("Find Cylinder Tested", cyl1[2], 
         cList.findCylinderWithLargestHeight());
   }
   /**
     *test for findLargestHeight method 2.
     */
   @Test public void findLargestHeightTest2() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2("ListIn", cyl1, 0);
      cList.addCylinder("Example One", 9, 15);
      cList.addCylinder("Example Two", 6, 10);
      cList.addCylinder("Example Three", 3, 5);
      Assert.assertEquals("Find Cylinder Tested", cyl1[0], 
         cList.findCylinderWithLargestHeight());
   }
   /**
     *test for emptyfindLargestHeight method.
     */
   @Test public void findLargestHeightTest3() {
      Cylinder[] cyl1 = new Cylinder[100];
      CylinderList2 cList = new CylinderList2(null, null, 0);
      Assert.assertEquals("Find Cylinder Tested", null, 
         cList.findCylinderWithLargestHeight());
   }
}
