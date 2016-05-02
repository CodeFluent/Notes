/*
* Wasfi Momen
* CSC 2010
* Homework 3
*
*/

public class Numbers{
  public static void printNumbers(){
    System.out.print("The numbers from 1 through 30 are: \n " );

    // fencepost problem. solved by printing terms - 1. better than just printing first number.
    for(int i=1; i<=30;i++){
      if (i <= 29){
        System.out.print(i + ", ");
      }
      else{
        System.out.print("and "+ i + ". ");
      }
    }
  }

  public static void printoddNumbers(){
    System.out.println("The odd numbers from 1 through 30 are: ");
    for(int i=1; i<=30; i++){
      if (i % 2 == 1){
        System.out.print(i + ", ");
      }
      else if (i == 30){
        System.out.print("and " + i + ".");
      }
    }
  }
  public static void printevenNumbers(){
    System.out.println("The even numbers from 1 through 30 are: ");
    for(int i=1; i <=30;i++){
      if (i % 2 == 0 && i<30){
        System.out.print(i + ", ");
      }
      else if (i == 30){
        System.out.println("and " + i + ".");
      }
    }
  }

  public static void oneHundred(){
    System.out.println("The sum of numbers 1 to 100 is: ");
    int sum = 0;
    for(int i=1; i<=100; i++){
      sum+=i;
    }
    System.out.print(sum);
  }

  public static void Multiply() {

       System.out.println("Multiplication table");
       System.out.println("____________________________");
	for (int start=1;start<=10;start++){

       for(int i = 1; i<=10;i++) {

          System.out.println(start+"*"+i+" = "+(i*start));
       }

 System.out.println("_____________________");
  }

  }

public static void main (String [] args){



  printNumbers();
  System.out.println();
  System.out.println();
  printoddNumbers();
  System.out.println();
  System.out.println();
  printevenNumbers();
  System.out.println();
  System.out.println();
  oneHundred();
  System.out.println();
  System.out.println();
  Multiply();
}
}
