import  java.util.Scanner;


public class LabA{

  public static String changeNameFormat(String n1){
    String splitFirst, splitLast;
    splitFirst = n1.substring(0, n1.indexOf(" ")); // gets from first index 0 (the first letter) and breaks at the space
    splitLast = n1.substring( n1.indexOf(" ") + 1, n1.length()); //gets from space to end of line, better than a for loop

    return (splitLast + ", " + splitFirst);


}



public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  System.out.println("What is your name?\n");
  System.out.println();
  String n1;
  System.out.println(changeNameFormat(input.nextLine()));

  }
}
