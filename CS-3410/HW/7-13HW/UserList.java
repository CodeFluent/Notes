
/*
  UserList contains all the functions required to create a list of UserNodes.
 */

public class UserList {

  private UserNode head;
  private int length;

public UserList () {

  }

/**
 * returns false if the length of the list is zero.
 * @return {boolean}
 * @post returns false if the list has UserNodes.
 */
public boolean isEmpty(){
	return (length == 0);
  }


/**
 * insert() takes in 3 parameters for a new UserNode and adds the UserNode to the correct place.
 * @param  firstname is a String passed to create the UserNode's firstname.
 * @param  lastname is a String passed to create the UserNode's lastname.
 * @param  phoneNumber is a String passed to create the UserNode's phoneNumber.
 * @post inserts a UserNode into the correct position into the UserList.
 */

public void insert(String firstname, String lastname, String phoneNumber) {


    UserNode prev = null;
	UserNode newNode = new UserNode();
    // System.out.println("frst" + head);
     newNode.setNext(head);

	newNode.setFirstName(firstname);
	newNode.setLastName(lastname);
	newNode.setPhoneNumber(phoneNumber);
    // System.out.println(newNode);
    // System.out.println("second" + head);
    UserNode current = newNode;


    // Special case of if head is null.
    if(isEmpty()) {
        newNode.setNext(head);
        head = newNode;
        length++;
        // System.out.println(head.toString());
    } else {


            String lname = head.getLastName();
            String lname2 = newNode.getLastName();
            // System.out.println("head" +lname);
            // System.out.println("newnode" +lname2);

            int ln = lname.compareToIgnoreCase(lname2); // returns -1, 0, 1
            // System.out.println(ln);
            if (ln > 0) { // newNode goes beforek if (prev == null) {
                    newNode.setNext(current);
                    head = newNode;
                    System.out.println("\n Current record is: " + head.toString());
                    length++;
                }

                prev.setNext(newNode);
                newNode.setNext(current);
                length++;


            } else  { // newNode goes after, newNode is tail.
                if(current.getNext() == null) {
                    current.setNext(newNode);
                    newNode.setNext(null);
                    length++;

                }
                prev = current;
                current = current.getNext();
            }

    }
  }


 /**
  * delete() deletes the currently selected UserNode from the UserList.
  * @post deletes the currently selected UserNode.
  */
 public UserNode delete() {
     UserNode curr = head;

     if (isEmpty()) {
         System.out.println("List is empty.");
     } else {
         head = head.getNext();
         System.out.println("Deleted: " + head.toString());
     }
     return curr;


 }
 /**
  * select() sets the prev UserNode to the selected UserNode by the firstname and lastname paramters.
  * @param   {firstname} a String firstname to search for in the UserList
  * @param   {lastname} a String lastname to search for in the UserList
  * @post    will set the current head as the UserNode specified by the paramters.
  */

 public void select(String firstname, String lastname) {
     UserNode curr = head;

     if(isEmpty()) {

     }
 }

 public void display() {
     UserNode curr = head;

     if (curr == null) {
         System.out.println("No current records.");
     } else {
         System.out.print("First Name\t");
         System.out.print("Last Name\t");
         System.out.print("Phone Number\n");
         System.out.print("--------\t");
         System.out.print("--------\t");
         System.out.print("--------\t");
         System.out.println();

         for( int i = 0 ; i < length; i++) {
             System.out.print(curr.getFirstName() + "\t");
             System.out.print(curr.getLastName() + "\t");
             System.out.print(curr.getPhoneNumber() + "\t");
             curr = curr.getNext();
         }
     }
     System.out.println(length);
 }

 public void setFname(String firstname) {

     if(isEmpty()) {
         System.out.println("No current record");
     } else {
         head.setFirstName(firstname);
         System.out.println("\nCurrent record is: " + head.toString());
     }
 }

 public void setLname(String lastname) {

     if(isEmpty()) {
         System.out.println("No current record");
     } else {
         head.setLastName(lastname);
         System.out.println("\nCurrent record is: " + head.toString());
     }
 }

 public void setPnum(String pnum) {

     if(isEmpty()) {
         System.out.println("No current record");
     } else {
         head.setPhoneNumber(pnum);
         System.out.println("\nCurrent record is: " + head.toString());
     }
 }




}
