import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
/**
  *COMP 1210
  *Project #3
  *@author Mathew Coggins
  *@version 09-09-15
  */
public class TicketInfo {
/**
  *Implements different things to get printed result of a ticket
  *
  *@param args Command line arguments (not used).
  */
   static final double STUDENT_DISCOUNT = .80;
   static final double FACULTY_STAFF_DISCOUNT = .20;

   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      String ticketCode = "";
      
      //print first line of code
      System.out.print("Enter your ticket code: ");
      ticketCode = userInput.nextLine().trim();
     
      //write if else statement
      if (ticketCode.length() < 27) {
         System.out.print("Invalid Ticket Code.\nTicket code"
            + " must have at least 27 characters.");
      }
      else {
      //declare strings and substrings
         String ticketType = ticketCode.substring(0, 3);
         String section = ticketCode.substring(4, 5);
         String row = ticketCode.substring(5, 7);
         String seat = ticketCode.substring(8, 9);
         String price1 = ticketCode.substring(9, 12);
         String price2 = ticketCode.substring(12, 14);
         String date = ticketCode.substring(14, 16);
         String date2 = ticketCode.substring(16, 18);
         String date3 = ticketCode.substring(18, 22);
         String time = ticketCode.substring(22, 24);
         String time2 = ticketCode.substring(24, 26);
         String eventName = ticketCode.substring(26, 39);
         //convert strings to int or double
         int section2 = 0;
         section2 = Integer.parseInt(section);
         int row2 = 0;
         row2 = Integer.parseInt(row);
         int seat2 = 0;
         seat2 = Integer.parseInt(seat);
         double price = 0.0;
         price = Double.parseDouble(price1);
         double cost = 0.0;
         //formats price to actual currency type
         NumberFormat formatter = NumberFormat.getCurrencyInstance();
         String priceString = formatter.format(price);
      
         if (ticketType.equals("REG")) {
            cost = price;
         }
         if (ticketType.equals("STU")) {
            cost = price * FACULTY_STAFF_DISCOUNT;
         }
         if (ticketType.equals("F/S")) {
            cost = price * STUDENT_DISCOUNT;
         }
         //formats cost to actual currency type
         String costString = formatter.format(cost);  
         //declares raffle and generates a random number for it            
         int raffle;
         raffle = (int) (Math.random() * 100000) + 1;
      
      //print the output
         DecimalFormat df = new DecimalFormat("#,###,##0.0##");
         System.out.print("\nEvent: " + eventName 
            + "   Date: " + date + "/" + date2 + "/" + date3 
            + "   Time: " + time + ":" + time2);
         System.out.print("\nSection: " + section2 
            +  "   Row: " + row2 
            + "   Seat: " + seat2);
         System.out.print("\nPrice: " + priceString 
            + "   Ticket Type: " + ticketType 
            + "   Cost: " + costString);
         System.out.print("\nRaffle Number: " + raffle);
        
      }
   }
}