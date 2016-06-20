// Write a Java program that asks the user to enter an array of integers in the main method.
// The program should prompt the user for the number of elements in the array and then the elements of the array.
// The program should then call a method named minGap that accepts the array entered by the user as a parameter
// and returns the minimum 'gap' between adjacent values in the array.
// The main method should then print the value returned by the method.
// The gap between two adjacent values in an array is defined as the difference in value
// between the first element and the second element.
//
// For example, suppose the user entered the following array of integers
// {1, 3, 6, 5, 12}
//
// The first gap is 2 (3 - 1), the second gap is 3 (6 - 3), the third gap is 1 (6 - 5) and the fourth gap is 5 (12 - 6).
// Thus, the call of minGap(array) should return 1 because that is the smallest gap in the array.
// If you are passed an array with fewer than 2 elements, you should return 0.

import java.util.*;


public class Arrays {


  public static void minGap (int [] userArr) {
  // subtract the first and second elements
  int sums;
  int [] sumsArr = new int [userArr.length-1];
 // 1, 3, 5, 6, 12 => 2 (3-1), 2 (5-3), 1 (6-5), 6 (12-6)
  if (userArr.length > 2) {
    for (int j = 0; j < userArr.length - 1; j++) {
        int larger = Math.max(userArr[j], userArr[j+1]);
        int smaller = Math.min(userArr[j], userArr[j+1]);
        sums = larger - smaller;
        sumsArr[j] = sums;

        int index = 0;
        int smallest = sumsArr[0];

        for(int x=0; x < sumsArr.length-1; x++) {
          if (sumsArr[x] < smallest){
            smallest = sumsArr[x];
            index = x;

            }

        }
        System.out.print("The minGap is " + smallest);
      }

    }
  else {
    sums = 0;
    System.out.print(sums);
  }
}

  public static void main (String [] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("How many numbers in the array?: ");
    int numOfEl = input.nextInt();
    int [] userArr = new int [numOfEl];


    System.out.println("What are the elements in your array?: ");

    for(int i=0; i <= userArr.length-1; i++) {
      userArr[i] = input.nextInt();
    }

    System.out.println();


    minGap(userArr);





  }
}
