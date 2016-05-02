// Wasfi Momen
// HW 4

import java.util.Scanner;
import java.io.*;

public class Program2{

  public static String printReverse(String name) {

    String reverse = "";
    int originalLength = name.length();

    for (int i = originalLength - 1; i >=0; i-- ){

      reverse = reverse + name.charAt(i);

    }
    return reverse;


  }

  public static String printNickName(String name) {
    String firstTwo = name.substring(0, 2);
    String lastTwo = name.substring(name.length()-2);

    return firstTwo + lastTwo;

  }

  public static void printPyramid(String name) {

    // get from beginning
    for (int i=0; i < name.length(); i++) {
      // print chars from index 0 onwards
      for (int j=0; j <=i; j++) {
         System.out.print(name.charAt(i));
      }
      System.out.println();
    }


  }


  public static void main (String [] args){

    String name;

    Scanner scanner1 = new Scanner(System.in);
    System.out.println("What is your first name? \n ");
    name = scanner1.nextLine();
    name = name.toLowerCase();

    System.out.println();
    System.out.println("Your name in reverse is: \n" + printReverse(name));
    System.out.println();
    System.out.println("Your nickname is: \n" + printNickName(name));
    System.out.println();
    System.out.println("Your name in the Pyramid of Order: \n");
    printPyramid(name);

  }
}
