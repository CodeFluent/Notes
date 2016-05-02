// Wasfi Momen
// CSC 2010

import java.util.*;

public class GuessingGame {

  public static void winner(int randnum, int tries) {

    Scanner console = new Scanner(System.in);

    while (tries < 10){
      System.out.println("What is your guess?");
      int placenum = console.nextInt();

      if (placenum > randnum) {
        System.out.println("Too High!");
        tries++;
      }
      else if (placenum < randnum) {
        System.out.println("Too Low!");
        tries++;
      }
      else if (placenum == randnum) {
        System.out.println("You guessed my number in " + tries + " tries!");
        System.out.println("Thanks for playing the number guessing game!");
        break;
      }

     if (tries == 10) { // check tries (is bad practice to do this)
       loser(randnum); // call loser function cuz user is a loser
     }

    }


  }

  public static void loser(int randnum) {

    System.out.println();
    System.out.println("You lost!");
    System.out.println("My actual number was: " + randnum);

  }

  public static void main (String [] args){

    System.out.println();
    System.out.println("Welcome to the number guessing game where you will guess a number from 1 to 100.");

    Random num = new Random();
    int randnum = num.nextInt(100) + 1; //we want to include 100
    int tries = 0;

    winner(randnum, tries);




  }
}
