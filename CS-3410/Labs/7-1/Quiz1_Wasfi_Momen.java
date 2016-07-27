import java.util.*;

/*
    Lab Quiz

    Write a program that will test a SelectionSort(ArrayList<Integer> name)

    Requirements:
        - DONE:0 Prompt the user to enter a number and now fill the ArrayList with that many randomly generated integers with that many randomly generated integers number randing from 1 to 50.
        - DONE:10 Print these numbers from the ArrayList on the screen.
        - DONE:20 Call the SelectionSort() method passing the ArrayList full with those numbers.
        - DONE:30 Print the resulting sorted ArrayList of numbers on the screen.
 */

public class Quiz1_Wasfi_Momen {

    public static void selectionSort(ArrayList <Integer> a1) {

        int temp, last_one;

        for(int i = a1.size() - 1; i > 0; i--) {
            last_one = 0; // index of to-be sorted.
            for (int j = 1; j <= i; j++) {
                // next value is lower than current, so assign index for swapping.
                if( a1.get(j) < a1.get(last_one)) {
                    last_one = j;
                }
                // swap values
                // temp = array1[last_one];
                // array1[last_one] = array1[i];
                // array1[i] = temp;

                temp = a1.get(last_one);
                a1.set(last_one, a1.get(i));
                a1.set(i, temp);
            }
        }

        // Print the ArrayList.
        System.out.print("\nSorted ArrayList: [");

        for(Integer l: a1){
            System.out.print(" " + l);
        }
        System.out.print(" ]");

    }


    public static void main (String [] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("How many elements in the ArrayList?: ");
        int size = console.nextInt(); // gets the size of the ArrayList

        ArrayList <Integer> list1 = new ArrayList <Integer>();


        Random rand = new Random();
        int min = 1;
        int max = 50;

        System.out.print("New values in ArrayList: [");
        for(int i = 0; i <= size - 1; i++) {
            int randomInteger = rand.nextInt( max - min + 1) + min;
            list1.add(randomInteger);
            System.out.print(" " + randomInteger);
        }
        System.out.print(" ]");

        selectionSort(list1);


    }
}
