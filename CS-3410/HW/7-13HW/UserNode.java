/*
  The UserNode class creates a Node to be put into the LinkedList and holds all the data for the users.
 */

public class UserNode {

  public static  UserNode next;
  public static  String firstname;
  public static  String lastname;
  public static  String phoneNumber;

/*
 * The constructor for UserNode assumes that it is always the head of the list unless otherwise. It will automatically be set to null.
 *
 */
  public UserNode() {
    next = null;

  }

 /**
  * getFirstName() returns the user's name.
  * @return {String}
  */
  public String getFirstName() {
    return firstname;
  }

 /**
  * Takes a String name and sets it as the Firstname of the UserNode.
  * @param name is to set the user's firstname in Usernode.
  */
  public void setFirstName(String name) {
    firstname = name;
  }

  public String getLastName() {
    return lastname;
  }

  public void setLastName(String lname) {
    lastname = lname;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phone) {
    phoneNumber = phone;
  }

  public UserNode getNext() {
    return next;
  }

  public void setNext(UserNode nextNode) {
    next = nextNode;
  }

  public String toString () {
      return firstname + " " + lastname + " " + phoneNumber;
  }


}
