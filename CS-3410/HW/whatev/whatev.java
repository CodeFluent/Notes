import java.util.Random;

/**
 *     @author Wasfi Momen wmomen1@student.gsu.edu

     Purpose: To gain experience with Binary Search Trees and building your own LinkedList.

     Solution: Generate Random numbers and put into a data structure. Transverse the tree recursively and print to screen.

     Data Structures Used: Trees

     Program Use: Program will generate Random numbers and print them to the screen. Then, the tree will be printed to the screen.
 */



public class whatev {


    public static void main(String [] args) {
        Node root = null;
        Tree btree = new Tree();

        // set up random integers from 1 to 99.
        Random rand = new Random();
        int max =  99;
        int min = 1;
        int randomint = 0;

        // initialize array
        int [] array = new int [101];


        // Fill array with 100 values.
        System.out.print("New values in the array:\n [");
        for(int i = 0; i <= 100; i++) {
            randomint = rand.nextInt( max - min + 1) + min;
            array[i] = randomint;
            System.out.print(" " + randomint);
        }
        System.out.print(" ]");



        for(int i = 0; i < array.length - 1; i++) {
            root = btree.insert(root, array[i]);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Values displayed in inOrder transverse: \n");
        btree.inOrder(root);
        System.out.println();


    }

}
