import java.util.Arrays;
import java.util.Scanner;

/**.
* This program creates 10 random numbers from 1 to 100,
* asks the user to enter a number, and searches for it
* in the array. If found, it shows the index.
*
* @author Santiago Hewett
* @version 1.0
* @since 2025/03/20
*/

final class LinearSearch {

   /**
    * Array size constant.
    */
   public static final int MAX_ARRAY = 10;

   /**
    * Max value for random numbers.
    */
   public static final int MAX_VALUE = 100;

   /**
    * Private constructor to prevent instantiation.
    */
   private LinearSearch() {
       throw new IllegalStateException("Utility class");
   }

   /**
    * Main method.
    *
    * @param args Unused.
    */
   public static void main(final String[] args) throws Exception {
       // Scanner for user input
       Scanner scanner = new Scanner(System.in);

       // User input as string
       String userNumberStr = "";

       // User input as integer
       int userNumberInt = 0;

       // Array of random numbers
       int[] arrayRandInts = new int[MAX_ARRAY];

       // Loop until user enters 'q'
       do {
           // Create and fill the array with random numbers
           arrayRandInts = populatingArrays();

           // Sort the array
           Arrays.sort(arrayRandInts);

           // Ask the user for a number to search
           System.out.println("What number are you searching for in "
            + "the list below? Enter 'q' " + "to quit.");

           for (int index = 0; index < MAX_ARRAY; index++) {
               System.out.print(arrayRandInts[index] + " ");
           }
           System.out.print(" Number: ");

           // Get user input
           userNumberStr = scanner.nextLine();

           // If user types 'q', exit
           if (userNumberStr.equals("q")) {
               // Say goodbye
               System.out.println("Goodbye!");
           } else {
               // Try to convert input to integer
               try {
                   userNumberInt = Integer.parseInt(userNumberStr);

                   // Search for the number
                   for (int index = 0; index < MAX_ARRAY; index++) {
                       // If number is found
                       if (userNumberInt == arrayRandInts[index]) {
                           // Print the index
                           System.out.println("The number "
                                   + userNumberInt
                                   + " is found as early as index "
                                   + index);
                           // Stop searching
                           break;
                       }

                       // If not found after full loop
                       if (index == MAX_ARRAY - 1
                       && userNumberInt != arrayRandInts[index]) {
                           System.out.println("The number "
                                   + userNumberInt
                                   + " was not found in the list.");
                       }
                   }
               } catch (NumberFormatException error) {
                   // If input is not a number
                   System.out.println("Invalid input: "
                           + userNumberStr
                           + ", Please enter a integer");
               }
           }
       } while (!userNumberStr.equals("q"));

       // Close scanner
       scanner.close();
   }

   public static int[] populatingArrays() {
       // Create array
       int[] arrayRandInts = new int[MAX_ARRAY];

       // Fill array with random numbers
       for (int index = 0; index < MAX_ARRAY; index++) {
           arrayRandInts[index] = (int) (Math.random() * MAX_VALUE) + 1;
       }

       // Return the array
       return arrayRandInts;
   }
}
