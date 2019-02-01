// calls a method insertionsort that accepts an integer array as a parameter
// and sorts the elements in the array using the insertionsort algorithm.
// Print the array before it is sorted and after it is sorted.

import java.util.*;


public class InsertionSort {

    public static void insertionSort (int [] num ) {

        int j; // track outer loop
        int temp; // temp var
        int i; // track inner loop

        for (j = 1; j < num.length; j++) {
                temp = num[j];
                for(i = j - 1; (i >= 0) && (num[ i ] < temp); i--){ // get index of element and see if the element is <
                    // the previous
                    num[i+1] = num[i];  // switch the two elements
                }
                num[ i+1 ] = temp; // place correct element in where the other one used to be
            }
            System.out.println(Arrays.toString(num));
        }




    public static void main (String [] args ) {

        int [] array = new int []{45,23,2,5,87,24};

        System.out.println();
        System.out.println("Before Sorting");
        System.out.println();
        System.out.println(Arrays.toString(array));

        System.out.println();
        System.out.println("After Sorting");
        System.out.println();
        insertionSort(array);
    }
}
