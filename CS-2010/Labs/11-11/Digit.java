// Wasfi Momen
// Bing Li
// CS 2010
// 12-12:50

import java.util.Scanner;


public class Digit {

	public static boolean hasDigitsOdd(int n){

    while (n != 0){
      if (n % 2 == 0){ //if loop continously runs for every digit in the int.
        return false;
      }
      n = n / 10;
    }
    return true;
	}

	public static boolean hasMidpoint(int n1,int n2,int n3){

    int answer = ((n1 + n2 + n3) / 2);

    if ( (answer == n1) || (answer == n2) || (answer == n3) ){
      return true;
    }

    return false;


	}

	public static void main(String[] args) {


    System.out.println();
    System.out.println("Please specify an integer: \n");
    Scanner console = new Scanner (System.in);

    //block for input console
    int n = console.nextInt();
    n = Math.abs(n); //negatives handle

    System.out.println();
    System.out.println();
    System.out.println("Note true is yes and false is no.");
    System.out.println();
		System.out.println("Are all the digits odd?: ");
    System.out.println(hasDigitsOdd(n));

    System.out.println("________________________________________________________________________________________________");

    System.out.println();
    System.out.println("Please input three integer values: ");
    int n1, n2, n3;
    n1 = console.nextInt();
    n2 = console.nextInt();
    n3 = console.nextInt();

    System.out.println();
    System.out.println("Out of the integers you gave, are one of them the midpoint of the other two?: ");
    System.out.println(hasMidpoint(n1,n2,n3));



	}

}
