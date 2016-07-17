import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 	@author Wasfi Momen wmomen1@student.gsu.edu
 *
 * Purpose: To gain experience with Stacks and Queues as well as experience with
 * system-level functions and libraries.
 *
 * Solution: Read each character tokenized from the file and input it into a
 * queue. Once the file has been read, copy contents of the queue into a stack.
 * Pop each character from the queue and the stack and compare for equality.
 * If the two characters are equal by the end of the word, the word is a
 * palindrome.
 *
 * Data Structures Used: Stacks and Queues
 *
 * Program Use: User will input a file, program will check to see if words are
 * palindrome and the console will display words with a palindrome.
 */

public class palindrome {

    public static void inputIO () {
        // Provide keyboard input to give file name
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please provide the path of the file: ");
        String userFile = keyboard.nextLine();

        try {
            // Create new File object to take in file.
            // Make new Scanner to take in file for processing.
            File file = new File(userFile);
            Scanner inputFile = new Scanner(file);
            String 

            while (inputFile.hasNext()) {

            }

        } catch (FileNotFoundException e) {
            // Catch the exception for if there is no file and print out message.
            System.out.println("The input file is empty.");
            System.exit(1);
        }

    }


    public static void main (String [] args) {

    }
}
