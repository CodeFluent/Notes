import java.util.Random;
import java.util.ArrayList;
/**
 *     @author Wasfi Momen wmomen1@student.gsu.edu

     Purpose: To gain experience with Binary Search Trees and building your own LinkedList.

     Solution: Generate Random numbers and put into a data structure. Transverse the tree recursively and print to screen.

     Data Structures Used: Trees

     Program Use: Program will generate Random numbers and print them to the screen. Then, the tree will be printed to the screen.
 */

public class BSTree {



    public static void main(String [] args) {

        Tree btree = new Tree();

        // set up random integers from 1 to 99.
        Random rand = new Random();
        Integer max =  new Integer(99);
        int min = 1;
        int randomint = 0;

        // initialize array
        int [] array = new int [100];


        // Fill ArrayList with 100 values.
        System.out.print("New values in ArrayList:\n [");
        for(int i = 0; i <= 1; i++) {
            randomint = rand.nextInt( max - min + 1) + min;
            array[i] = randomint;
            System.out.print(" " + randomint);
        }
        System.out.print(" ]");

        
        for(int i = 0; i < array.length - 1; i++) {
            int k = array[i];
            // System.out.println(k);
            btree.addNode(k);
        }

    }
}
