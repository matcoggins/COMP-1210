import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
 /**
*COMP 1210.
*Project07
*@author Mathew Coggins
*10/26/2015
*/
public class CylinderTest {
/** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
     *test for getLabel method.
     */
   @Test public void getLabelTest() {
      Cylinder c = new Cylinder("label", 1.0, 3.0);
      Assert.assertEquals("label", c.getLabel());
   }
   /**
     *test for setLabel method when false.
     */
   @Test public void setLabelTestFalse() {
      Cylinder c = new Cylinder("label", 1.0, 3.0);
      c.setLabel("label");
      Assert.assertEquals(false, c.setLabel(null));
   }
   /**
     *test for setLabel method.
     */
   @Test public void setLabelTest() {
      Cylinder c = new Cylinder("label", 1.0, 3.0);
      c.setLabel("c1");
      Assert.assertEquals("set label error", "c1", c.getLabel());
   }
   /**
     *test for getRadius method.
     */
   @Test public void getRadiusTest() {
      Cylinder c = new Cylinder("label", 1.0, 3.0);
      Assert.assertEquals(1, c.getRadius(), 0.01);
   }
   /**
     *test for setRadius method.
     */
   @Test public void setRadiusTest() {
      Cylinder c = new Cylinder("label", 1.0, 3.0);
      c.setRadius(3.0);
      Assert.assertEquals(3.0, c.getRadius(), 0.01);
   }
   /**
     *test for getHeight method.
     */
   @Test public void getHeightTest() {
      Cylinder c = new Cylinder("label", 1.0, 3.0);
      Assert.assertEquals(3, c.getHeight(), 0.01);
   }
   /**
     *test for setHeight method.
     */
   @Test public void setHeightTest() {
      Cylinder c = new Cylinder("label", 1.0, 3.0);
      c.setHeight(3.0);
      Assert.assertEquals(3.0, c.getHeight(), 0.01);
   }
   /**
     *test for diameter method.
     */
   @Test public void diameterTest() {
      Cylinder c = new Cylinder("label", 5, 15);
      Assert.assertEquals(10, c.diameter(), 0.01);
   }
   /**
     *test for circumference method.
     */
   @Test public void circumferenceTest() {
      Cylinder c = new Cylinder("label", 5, 15);
      Assert.assertEquals(31.41, c.circumference(), 0.01);
   }
   /**
     *test for area method.
     */
   @Test public void areaTest() {
      Cylinder c = new Cylinder("label", 5, 15);
      Assert.assertEquals(628.31, c.area(), 0.01);
   }
   /**
     *test for volume method.
     */
   @Test public void volumeTest() {
      Cylinder c = new Cylinder("label", 5, 15);
      Assert.assertEquals(1178.09, c.volume(), 0.01);
   }
   /**
     *test for toString method.
     */
   @Test public void toStringTest() {
      Cylinder c = new Cylinder("label", 4, 10);
      String string = c.toString();
      Assert.assertEquals(true, string.contains("radius"));
   }
   /**
     *test for getCount method.
     */
   @Test public void getCountTest() {
      Cylinder c = new Cylinder("label", 5, 15);
      c.getCount();
      Assert.assertEquals(0, c.getCount());
   }
   /**
     *test for resetCount method.
     */
   @Test public void resetCountTest() {
      Cylinder c = new Cylinder("label", 1, 2);
      c.resetCount();
      Assert.assertEquals(0, c.getCount());
   }
     /**
     *test for equals method when false.
     */
   @Test public void equalsTestFalse() {
      Cylinder c = new Cylinder("Example", 1, 2);
      String c1 = "";
      Assert.assertEquals(false, c.equals(c1));
   }
   /**
     *test for equals method when false 2.
     */
   @Test public void equalsTestFalse2() {
      Cylinder c = new Cylinder("Example", 1, 2);
      Cylinder c1 = new Cylinder("Example", 3, 4);
      Assert.assertEquals(false, c.equals(c1));
   }
   /**
     *test for equals method when false 3.
     */
   @Test public void equalsTestFalse3() {
      Cylinder c = new Cylinder("Example", 3, 6);
      Cylinder c1 = new Cylinder("Example", 3, 9);
      Assert.assertEquals(false, c.equals(c1));
   }
   /**
     *test for equals method when false 4.
     */
   @Test public void equalsTestFalse4() {
      Cylinder c = new Cylinder("Example", 4, 0);
      Cylinder c1 = new Cylinder("Example1", 5, 10);
      Assert.assertEquals(false, c.equals(c1));
   }
   /**
     *test for equals method when true.
     */
   @Test public void equalsTestTrue() {
      Cylinder c = new Cylinder("Example", 1, 2);
      Cylinder c1 = new Cylinder("Example", 1, 2);
      Assert.assertEquals(true, c.equals(c1));
   }
   /**
     *test for hashCode method.
     */
   @Test public void hashCodeTest() {
      Cylinder c = new Cylinder("label", 1.0, 3.0);
      Assert.assertEquals(0, c.hashCode());
   }
}
