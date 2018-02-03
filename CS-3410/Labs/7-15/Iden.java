import java.util.Scanner;


/**
 *  Write a recursive function that accepts one paramter and test to see if the input parameter to the function is a legitamate java identifier.
 *
 * Criteria:
 * 	- A java identifier can start with a letter (lower or upper case), a $ or an underscore.
 * 	- Can contain digits anywhere after these characters.
 *
 *  Write a driver program to test this function. Prompt the user for a java identifier and test it Run the program infinitely until the user enters No to not run the program again.
 *
 *  Grammar:
 *  	<identifier> = <letter> | <identifier> <letter> | <identifier> <digit>
 *  	<letter> = a | b | ... | z | A | B | ... | Z | _ | $
 *  	<digit> = 0 | 1 | ... | 9
 *
 *  TODO: Work with $identifier and _identifier
 */

public class Iden {

    public static boolean isIdentifier (String candid) {
        if(candid.length() == 1){

            // only possible if string is length 1 if it is a letter.
            // cannot only have _ or $
            if(candid.matches("[a-zA-Z]")) {
                return true;
            } else {
                return false;
            }
        }
        // check the last character in the string and see if its a letter, digit, underscore, or $
        // recursively call back without the last character
        else if (candid.substring(candid.length()-1).matches("^[\\$a-zA-Z0-9_]+$")) {
            return isIdentifier(candid.substring(0, candid.length()-1));
        } else {
            return false;
        }
    }

    public static void main (String [] args) {

        Scanner console = new Scanner (System.in);
        System.out.println("Enter candidate: ");

        while(console.hasNextLine()) {
            String answer = console.nextLine();


            if(answer.equals("No")){
                System.out.println("\tExiting.");
                break;
            } else {
                if(isIdentifier(answer)) {
                    System.out.println("\tValid Java Identifier.");
                } else {
                    System.out.println("\tNot a Valid Java Identifier.");
                }
                System.out.println("\nEnter candidate: ");

            }
        }


    }
}
