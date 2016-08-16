import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
/**
  *@author Mathew Coggins
  *@version 12-01-15
  */
public class RewardsProcessorTest {
/** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
    *Test for getCutomersArray method.
    */
   @Test public void getCustomersArray() {
      Customer[] cus = new Customer[0];
      RewardsProcessor r = new RewardsProcessor();
      Assert.assertArrayEquals(cus, r.getCustomersArray());
   }
   /**
    *Test for getInvalidRecordsArray method.
    */
   @Test public void getInvalidRecordsArray() {
      String[] str = new String[0];
      RewardsProcessor r = new RewardsProcessor();
      Assert.assertArrayEquals(str, r.getInvalidRecordsArray());
   }
   /**
    *Test for addCustomer method.
    */
   @Test public void addCustomer() {
      RewardsProcessor r = new RewardsProcessor();
      Customer cus = new PreferredCustomer("12345", "Example Name");
      Customer[] cusA = {cus};
      r.addCustomer(cus);
      Assert.assertArrayEquals(cusA, r.getCustomersArray());
   }
   /**
    *Test for addInvalidRecord method.
    */
   @Test public void addInvalidRecord() {
      RewardsProcessor r = new RewardsProcessor();
      Customer cus = new PreferredCustomer("12345", "Example Name");
      String[] str = {"Invalid Record"};
      String s1 = "Invalid Record";
      r.addInvalidRecord(s1);
      Assert.assertArrayEquals(str, r.getInvalidRecordsArray());
   }
   /**
    *Test for generateReport method.
    *@throws IOException e
    */
   @Test public void generateReport() throws IOException {
      RewardsProcessor r = new RewardsProcessor();
      r.readCustomerFile("customers.txt");
      String str = r.generateReport();
      Assert.assertEquals(true, str.contains("Gold"));
   }
   /**
    *Test for generateReportFalse method.
    *@throws IOException e
    */
   @Test public void generateReportFalse() throws IOException {
      RewardsProcessor r = new RewardsProcessor();
      r.readCustomerFile("customers.txt");
      String str = r.generateReport();
      Assert.assertEquals(false, str.contains("Movie"));
   }
   /**
    *Test for generateReportByName method.
    *@throws IOException e
    */
   @Test public void generateReportByName() throws IOException {
      RewardsProcessor r = new RewardsProcessor();
      r.readCustomerFile("customers.txt");
      String str = r.generateReport();
      Assert.assertEquals(true, str.contains("Gold"));
   }
   /**
    *Test for generateReportByNameFalse method.
    *@throws IOException e
    */
   @Test public void generateReportByNameFalse() throws IOException {
      RewardsProcessor r = new RewardsProcessor();
      r.readCustomerFile("customers.txt");
      String str = r.generateReport();
      Assert.assertEquals(false, str.contains("Movie"));
   }
   /**
    *Test for generateReportByTotal method.
    *@throws IOException e
    */
   @Test public void generateReportByTotal() throws IOException {
      RewardsProcessor r = new RewardsProcessor();
      r.readCustomerFile("customers.txt");
      String str = r.generateReport();
      Assert.assertEquals(true, str.contains("Gold"));
   }
   /**
    *Test for generateReportByTotalFalse method.
    *@throws IOException e
    */
   @Test public void generateReportByTotalFalse() throws IOException {
      RewardsProcessor r = new RewardsProcessor();
      r.readCustomerFile("customers.txt");
      String str = r.generateReport();
      Assert.assertEquals(false, str.contains("Movie"));
   }
}