import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
/*
 * @author Mathew Coggins
 * @version 12-01-15
 */
public class RewardsProcessor {
//Fields
   private Customer[] customerElements;
   private String[] invalidRecord;
/**
  *constructor
  */
   public RewardsProcessor() {
      invalidRecord = new String[0];
      customerElements = new Customer[0];
   }

//Methods
/**
 *@return Customer[] 
 */
   public Customer[] getCustomersArray() {
      return customerElements;
   }
/**
 *@return String[] 
 */
   public String[] getInvalidRecordsArray() {
      return invalidRecord;
   }
 /**
 *@param c 
 */
   public void addCustomer(Customer c) {
      customerElements = Arrays.copyOf(customerElements, 
         customerElements.length + 1);
      customerElements[customerElements.length - 1] = c;
   }
/**
 *@param s 
 */
   public void addInvalidRecord(String s) {
      invalidRecord = Arrays.copyOf(invalidRecord, invalidRecord.length + 1);
      invalidRecord[invalidRecord.length - 1] = s;
   }
/**
 *@param fileNameIn 
 *@throws IOException e
 */
   public void readCustomerFile(String fileNameIn) throws IOException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      String cusInfo;
      int cat = 0;
      String acctNumber = "";
      String name = "";
      
      
      
      while (scanFile.hasNextLine()) {
         cusInfo = scanFile.nextLine();
         Scanner readData = new Scanner(cusInfo);
         cat = readData.nextInt();
         acctNumber = readData.next();
         name = readData.next() + " " + readData.next();
         try {
            if (cat == 1) {
               PreferredCustomer cus = new PreferredCustomer(acctNumber, name);
               addCustomer(cus);
               while (readData.hasNext()) {
                  cus.addPurchases(Double.parseDouble(readData.next()));
               }
            }
            else if (cat == 2) {
               PreferredSilverCustomer cus2 = new 
                  PreferredSilverCustomer(acctNumber, name);
               addCustomer(cus2);
               while (readData.hasNext()) {
                  cus2.addPurchases(Double.parseDouble(readData.next()));
               }
            }  
            else if (cat == 3) {
               PreferredGoldCustomer cus3 = new 
                  PreferredGoldCustomer(acctNumber, name);
               addCustomer(cus3);
               while (readData.hasNext()) {
                  cus3.addPurchases(Double.parseDouble(readData.next()));
               }
            } 
            else {
               throw new InvalidCategoryException();
            }
         }
         catch (NumberFormatException error) {
            String output = cusInfo + " *** invalid purchase amount ***\n";
            addInvalidRecord(output);
         }
         catch (InvalidCategoryException error) {
            String output = cusInfo + "*** invalid category ***\n";
            addInvalidRecord(output);
         }
      }
   }   
 /**
 *@return str
 */
   public String generateReport() {
      String str = "----------------------------\n"
         + "Monthly Rewards Club Report\n"
         + "----------------------------\n";
      for (int a = 0; a < customerElements.length; a++) {
         str = str + customerElements[a].toString() + "\n";
      }
      return str;
   }
 /**
 *@return str
 */
   public String generateReportByName() {
      String str = "--------------------------------------\n"
         + "Monthly Rewards Club Report (by Name)\n"
         + "--------------------------------------\n";
      Arrays.sort(customerElements);
      for (int a = 0; a < customerElements.length; a++) {
         str = str + customerElements[a].toString() + "\n";
      }
      return str;
   }
 /**
 *@return str
 */ 
   public String generateReportByTotal() {
      String str = "--------------------------------------\n"
         + "Monthly Rewards Club Report (by Total)\n"
         + "--------------------------------------\n";
      Arrays.sort(customerElements, new TotalCompare());   
      for (int a = 0; a < customerElements.length; a++) {
         str = str + customerElements[a].toString() + "\n";
      }
      return str;
   }
 /**
 *@return str
 */
   public String generateInvalidRecordsReport() {
      String str = "-----------------------\n"
                 + "Invalid Records Report\n"
                 + "-----------------------\n";
      for (String s : invalidRecord) {
         str += s + "\n";
      }
      return str;
   }
}