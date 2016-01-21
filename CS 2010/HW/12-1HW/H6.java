// Wasfi Momen
// HW 6
// 12/1/15


import java.util.*;


public class H6 {

  public static void printReverse (int [] numbers) {

    // a void method that prints out the array in reverse of the way it was entered all on one
    // line separated by commas

    System.out.print("Here are your numbers reversed: ");

    System.out.print(numbers[9]); //fencepost; prints out last value in array; easiest way to do this
    for (int j = numbers.length - 2; j >= 0; j--) { // gets the rest of integers and prints out until j = 0.
      System.out.print( ", " + numbers[j]);
    }

  }

  public static int getLargest (int [] numbers) {

    // a int method that returns the largest value in the array

    int largest = numbers[0];

    for(int f =0; f < numbers.length; f++) {
      if (numbers[f] > largest) { //if without else loop continously works in the for loop for all elements
        largest = numbers[f];
      }
    }

    return largest;

  }


  public static int [] computeTwice (int [] numbers) {

    // a method that returns an array of int which contains two times of all the numbers in the
    // array

    int [] twice = new int [numbers.length];
    int numToTimes = 2;

    // multiply each element by 2
    for (int k = 0; k < numbers.length; k++){
      twice[k] = numbers[k] * numToTimes;
    }

    return twice;

  }

  public static void main (String [] args) {

    Scanner console = new Scanner(System.in);
    int [] numbers = new int [10];

    // take user input and input it into array of predetermined size
    System.out.println();
    for (int i = 0; i < numbers.length; i++){
      System.out.println("Enter a number: ");
      numbers[i] = console.nextInt();
    }

    System.out.println();
    printReverse(numbers);
    System.out.println();
    System.out.println("The largest number is " + getLargest(numbers));
    System.out.println("The array with two times the numbers: " + Arrays.toString(computeTwice(numbers))); //Arrays.toString prevents odd symbols


  }
}
