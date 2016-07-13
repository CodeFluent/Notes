/*
  The UserNode class creates a Node to be put into the LinkedList and holds all the data for the users.
 */

public class UserNode {

  private UserNode next;
  private String firstname = " ";
  private String lastname = " ";
  private String phoneNumber = " ";

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
    name = firstname;
  }

  public String getLastName() {
    return lastname;
  }

  public void setLastName(String lname) {
    lname = lastname;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phone) {
    phone = phoneNumber;
  }

  public UserNode getNext() {
    return next;
  }

  public UserNode setNext(UserNode nextNode) {
    nextNode = next;
  }


}
