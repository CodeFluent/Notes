// Write a modified dual version of the selection sort algorithm
// that selects both the largest and smallest elements on each pass
// and moves each of them to the appropriate end of the array.

import java.util.*;

public class Dual {

    public static void selectionSort (int [] a) {
        for (int i = 0; i < a.length / 2; i++) {

            int min = i; // assume min at i
            int max = a.length - i - 1; // max will always exclude i value

                 for (int j = i; j < a.length - i; j++) {
                     if (a[j] < a[min]) {
                         min = j;
                     }
                     if (a[j] > a[max]) {
                         max = j;
                     }
                }

            if (max == i) { // if max == i, then set it to min that way it'll swap equal values and no problem
                max = min;
            }

         swap(a, i, min);
         swap(a, a.length - i - 1, max);

         }
         System.out.println(Arrays.toString(a));
    }

    // helper method
    public static void swap (int [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
