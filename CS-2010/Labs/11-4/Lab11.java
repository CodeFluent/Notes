// Wasfi Momen
// Lab 11

import java.util.Scanner;

public class Lab11{

    public static void Fibonnaci(int maximum){

       //variables used in calculation,
       //but pass off to next value after calculation
       int lastInt = 0;
       int nextInt = 1;

       int i = 0; //sentinel for the while loop

      while (i < maximum){
        System.out.printf((lastInt + nextInt) + ", " );

        if(i > 0){
          int store = nextInt;
          nextInt = lastInt + nextInt;
          lastInt = store;
        }
          i++;
  }

}

    public static void main (String [] args){

      int maximum;

      Scanner input = new Scanner(System.in);

      System.out.println();
      System.out.println("Enter an integer: \n");
      maximum =  input.nextInt();
      System.out.println();

      System.out.println();
      System.out.println();
      Fibonnaci (maximum);



    }

}
