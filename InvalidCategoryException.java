/** 
 * @author Mathew Coggins
 * @version 12-01-15
 */
public class InvalidCategoryException extends Exception
//extends RuntimeException 
{
/**
  *constructor.
  */
   public InvalidCategoryException() {
      super("*** invalid category ***");
   }
}