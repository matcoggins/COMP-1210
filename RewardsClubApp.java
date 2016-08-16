import java.io.IOException;
import java.io.FileNotFoundException;
/** 
  * @author Mathew Coggins
  * @version 12-01-15
  */
public class RewardsClubApp {
/**
  *@param args 
  *@throws IOException e
  */
   public static void main(String[] args) throws IOException {
      try {
         if (args.length != 0) {
            RewardsProcessor rew = new RewardsProcessor();
            rew.readCustomerFile(args[0]);
            System.out.print(rew.generateReport());
            System.out.print(rew.generateReportByName());
            System.out.print(rew.generateReportByTotal());
            System.out.print(rew.generateInvalidRecordsReport());
         }
         else {
            System.out.println("File name expected as command line argument.\n"
               + "Program ending.");
         }
      }     
      catch (FileNotFoundException error) {
         System.out.println("*** Attempted to read file: " + args[0]
            + " (The system cannot find the file specified)");
      }
      catch (IOException error) {
      }
   }
}