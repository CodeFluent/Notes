// Calls another method called bubbleSort that accepts an integer array as a parameter
// and sorts the elements in the array using the bubble sort algorithm.
// Print the array before and after it is sorted.

import java.util.*;

public class Bubble {

    public static void bubbleSort (int [] a) {

        int temp;
        for (int j = 0; j < a.length; j++) {
            for (int i = 1; i < a.length; i++) {
                if (a[i] > a[i-1]) {
                    // swap the values
                    temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;
                }
            }

        }
            System.out.println(Arrays.toString(a));

    }

    public static void main (String [] args) {

        int [] num = new int []{5,28,7,46,4,12,9,1,3,8,65};

        System.out.println();
        System.out.println("Before Sorting");
        System.out.println();
        System.out.println(Arrays.toString(num));

        System.out.println();
        System.out.println("After Sorting");
        System.out.println();
        bubbleSort(num);
    }
}
