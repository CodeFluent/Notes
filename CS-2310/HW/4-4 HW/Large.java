// Write a modified version of selection sort algorithm
// that selects the largest element each time and movies it to the end of the array,
// rather than selecting the smallest element and moving it to the beginning.


import java.util.*;

public class Large {

    public static void largeselectionSort (int [] a) {
        int temp,i,j;
        int alength = a.length; // represents length of array

            for (i = alength - 1; i > 0; i--) { // iterate through loop from the end - 1 to the beginning
                int first = 0;
                    for (j = 1; j <= i; j++) {
                        if (a[j] > a[first]) // if current value is > first, then swap
                        first = j;
                    }
                // swap values
                temp = a[first];
                a[first] = a[i];
                a[i] = temp;

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
        largeselectionSort(array);

    }
}
