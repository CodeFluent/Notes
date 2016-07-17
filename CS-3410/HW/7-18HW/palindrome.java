import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
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

    // inputIO() handles most of the program input and output as well as processing the input through regex expressions.
    // It asks and takes user input, then uses String.replaceAll to clean it before passing it off to the Queue and the Stack.
    // In the queue and the stack, the characters of the String are inserted and then forced out for comparison. The value of isPal changes if the comparison shows that the characters from the front of the queue and the top of the stack differ.
    // isPal is checked to see if it is true or not at the end and outputs a message saying whether or not the input was a palindrome.
    //
    // @pre File is a valid file with words inside.
    // @post Processes the file and determines whether the words are palindromes or not.

    public static void inputIO () {

        System.out.println();

        // Provide keyboard input to give file name
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please provide the path of the file: ");
        String userFile = keyboard.nextLine();

        boolean isPal = true;
        String input = " ";
        String process = " ";

        try {
            // Create new File object to take in file.
            // Make new Scanner to take in file for processing.
            File file = new File(userFile);
            Scanner inputFile = new Scanner(file);


            while (inputFile.hasNext()) {

                // Store input word into a String
                input = inputFile.next();
                input = input.replaceAll("[^a-zA-z]", "");

                process = input.toLowerCase();

                // Declare data structures.
                // We do this inside the while loop to intialize a new, clean data structure each time.
                Stack <Character> stack = new Stack <Character> ();
                Queue <Character> queue = new LinkedList <Character>();

                Character analyze = new Character ('a');
                for(int i = 0; i < process.length(); i++) {
                    analyze = process.charAt(i);
                    // analyze = input.replaceAll("[^a-zA-z]", "").toLowerCase().charAt(i);
                    queue.add(analyze);
                    stack.push(analyze);
                }
                // stack and queue now have all the characters in the input String.


                while(!queue.isEmpty()) {
                    // if the queue and stack characters don't match, the word is not a palindrome.
                    if(!queue.remove().equals(stack.pop())) {
                        isPal = false;
                    }
                }

                // check isPal
                if (isPal) {
                    System.out.println();
                    System.out.println(input + " is a palindrome.");
                } else {
                    System.out.println();
                    System.out.println(input + " is not a palindrome.");
                }

            }

        } catch (FileNotFoundException e) {
            // Catch the exception for if there is no file and print out message.
            System.out.println("The input file is empty.");
            System.exit(1);
        }

    }


    public static void main (String [] args) {
        inputIO();
    }
}
