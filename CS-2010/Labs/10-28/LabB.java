import  java.util.Scanner;

public class LabB{

  public static boolean palindrome(String n1){
    String reversed = new StringBuffer(n1).reverse().toString(); //Using StringBuffer class aka an array of chars; has a reverse method

    if (reversed.equals(n1)){ // check to see if the string n1 is the same as the reversed method
       return true;
  }
    else {
      return false ;
    }
}



public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  System.out.println("What is your word? \n");
  String n1 = input.nextLine(); //check next line for input
  System.out.println();
  if (palindrome(n1) == true){  // gets the boolean and sees if it is true or not; true == palindrome, false == not a palindrome
    System.out.println(n1 + " is a palindrome");
  }
  else {
    System.out.println(n1 + " is not a palindrome");
  }


  }
}
