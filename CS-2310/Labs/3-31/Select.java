// Calls a method called selectionSort that accepts an integer aay as a paramerter
// and sorts the elements in the aay using the selection sort algorithm.
// Print the aay before and after it is sorted.

import java.util.*;

public class Select {

    public static void selectionSort (int [] a) {

        for (int i = 0; i < a.length-1; i++) {
            for (int j=i+1; j<a.length; j++) { // get neat element in index
                if (a[i] > a[j]) { // i > j, so swap
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));

    }

    public static void main (String [] args) {

        int [] array = new int []{2,4,1,3};

        System.out.println();
        System.out.println("Before Sorting");
        System.out.println();
        System.out.println(Arrays.toString(array));

        System.out.println();
        System.out.println("After Sorting");
        System.out.println();
        selectionSort(array);

    }
}
