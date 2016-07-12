/*
  The UserNode class creates a Node to be put into the LinkedList and holds all the data for the users.
 */

public class UserNode {

  private UserNode next;
  private String firstname = " ";
  private String lastname = " ";
  private String phoneNumber = " ";


  public UserNode() {
    next = null;
  }

  public String getFirstName() {
    return firstname;
  }

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
