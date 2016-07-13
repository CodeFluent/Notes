/*
  UserList contains all the functions required to create a list of UserNodes.
 */

public class UserList {

  public UserNode head;
  private int length;

public UserList () {
	head = null;
	length = 0;
  }

/**
 * returns false if the length of the list is zero.
 * @return {boolean}
 * @post returns false if the list has UserNodes.
 */
public boolean isEmpty(){
	return (length <= 0);
  }

public void insert(String firstname, String lastname, String phoneNumber) {
	UserNode current = head;
	UserNode previous = null;
	UserNode newNode = new UserNode();

	newNode.setFirstName(firstname);
	newNode.setLastName(lastname);
	newNode.setPhoneNumber(phoneNumber);


    length++;


  }
 /**
  * delete() deletes the currently selected UserNode from the UserList.
  */
 public void delete() {
     UserNode current = head;

     length--;

 }
 /**
  * select() sets the current UserNode to the selected UserNode by the firstname and lastname paramters.
  * @param   {firstname} a String firstname to search for in the UserList
  * @param   {lastname} a String lastname to search for in the UserList
  * @return  {UserNode}
  * @post    will set the current head as the UserNode specified by the paramters.
  */

 public UserNode select(String firstname, String lastname) {

 }

 public UserNode setFname(String firstname) {
     UserNode current = head;
     current.setFirstName(firstname);

     return current;
 }

 public UserNode setLname(String lastname) {
     UserNode current = head;
     current.setLastName(lastname);

     return current;
 }

 public UserNode setPNumber(String phoneNumber) {
     UserNode current = head;
     current.setPhoneNumber(phoneNumber);

     return current;
 }




}
