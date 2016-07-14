import java.util.Scanner;

/**
 *  Phonedir.java
 *
 *  <p>
 *  Purpose: The purpose of this program is to create a LinkedList data structure that maintains a list of records of certain criteria.
 *
 *  Solution: Create a UserNode class and a UserList class ot manage the UserNodes.
 *
 *  Data Structures Used: LinkedList
 *
 *  Program Use: The program will prompt the user, execute according to user's command, and then prompt user for next command.
 *
 *  @author Wasfi Momen wmomen1@student.gsu.edu
 *  @version 1.0.0
 *
 *
 */


/*
  Example Commands:

      a - Show all records
      d - Delete the current record
      f - Change the first name in the current record
      l - Change the last name in the current record
      n - Add a new record
      p - Change the phone number in the current record
      q - Quit
      s - Select a record from the record list to become the current record

 */



public class phonedir {

public static void main (String [] args) {
    UserList list = new UserList();

    System.out.println();
    System.out.println("A program to keep a Phone Directory\n");

    boolean completed = false;


    do {
        System.out.println("a \t Show all records");
        System.out.println("d \t Delete the current record");
        System.out.println("f \t Change the first name of the current record");
        System.out.println("l \t Change the last name of the current record");
        System.out.println("n \t Add a new record");
        System.out.println("p \t Change the phone number of the current record");
        System.out.println("q \t Quit");
        System.out.println("s \t Select a record from the directory to be the current record\n");

        System.out.print("Enter a command from the list above (q to quit): ");

        Scanner console = new Scanner (System.in);
        String option = console.nextLine().toLowerCase();

        switch(option){
            case "a":
                System.out.println();
                list.display();
                System.out.println();
                break;
            case "d":
                System.out.println();
                list.delete();
                System.out.println();
            case "f":
                System.out.println();
                System.out.print("Enter new first name: ");
                String newfirst;
                newfirst = console.nextLine();
                list.setFname(newfirst);
                System.out.println();
                break;
            case "l":
                System.out.println();
                System.out.print("Enter new last name: ");
                String newlast;
                newlast = console.nextLine();
                list.setLname(newlast);
                System.out.println();
                break;
            case "n":
                System.out.println();
                System.out.print("Enter first name: ");
                String fname, lname, pnum;
                fname = lname = pnum = "";
                fname = console.nextLine();
                System.out.print("\nEnter last name: ");
                lname = console.nextLine();
                System.out.print("\nEnter phone number: ");
                pnum = console.nextLine();
                list.insert(fname, lname, pnum);
                System.out.println();
                break;
            case "p":
                System.out.println();
                System.out.print("Enter new phone number: ");
                String newpnum;
                newpnum = console.nextLine();
                list.setPnum(newpnum);
                System.out.println();
                break;
            case "q":
                completed = true;
                break;
            case "s":
                System.out.println();
                list.delete();
                break;
            default:
                System.out.println();
                System.out.println("Illegal command.");
                System.out.println();
        }

    } while(!completed);

  }
}
