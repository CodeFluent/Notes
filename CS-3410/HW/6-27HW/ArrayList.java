import java.util.Arrays;

/**
  @author Wasfi Momen wmomen1@student.gsu.edu

  Purpose: The purpose of this program is to create an ArrayList data structure
  to be used in other Java applications.

  Solution: The solution to this program will include making several methods for
  a standard List data structure using Arrays. All operations for the ArrayList
  will be made through the Arrays library in Java as well as its operations.

  Data Structures Used: Arrays

  Program Use: Client programs will be able to call ArrayList() or
  ArrayList(int size) to create an ArrayList and then use several methods to add,
  remove, and operate on the values inside the ArrayList.

*/

  // TODO:
  //   - Preconditions, Postconditons, and Invariants.

public class ArrayList {

  private Object [] elements;
  private int size; // Size of the ArrayList.

  // Empty constructor for the ArrayList class.
  // Creates a default ArrayList with size of 10.
  public ArrayList() {
    elements = new Object[10];
    this.size = elements.length;
  }

  // Constructor for ArrayList that takes and int parameter size
  // to intialize the size of the ArrayList.
  public ArrayList(int size) {
    this.size = size;
    elements = new Object[size];
  }

  // Places Object at the end of the ArrayList.
  // If ArrayList is full, double its size.
  // Postconditons:
  //    - If using empty constructor, nulls wil be at the beginning of the ArrayList.
  //    - New Values will be added at the end of ArrayList and ArrayList will be doubled in size.
  public void add(Object x) {
    checkSize(size + 1);
    elements[size++] = x;
  }


  // Add Object at given int index in the ArrayList.
  // Postconditons:
  //    - Object at index will be replaced with new Object value.
  public void add(int index, Object x) {
    checkSize(size + 1);
    elements[index] = x;
  }

  // Checks the current size of the Object array.
  // Used to see whether the array needs to be doubled in size to add a new value.
  private void checkSize(int capacity) {
    int currentCapacity = elements.length; // get current array length.

    // If the currentCapacity is less than the int capacity passed in, then double the array length.
    if (capacity > currentCapacity) {
      elements = Arrays.copyOf(elements, elements.length * 2);
    }

  }

  // Retrieves object at given int index.
  public Object get(int index) {

      if (index < size) { // check to see if index is in the array.
          return elements[index];
      } else {
          // if not, then throw an exception.
          throw new ArrayIndexOutOfBoundsException();
      }

  }

  // Allows to retrieve the number of elements from the ArrayList.
  // Preconditions:
  //    - ArrayList has been intialized with one of the constructors.
  // Postconditions:
  //    - size() will also count nulls as elements.
  public int size() {
    return size;
  }

  // Tests to see if ArrayList is empty
  // Invariant: Will always return false if size > 0.
  public boolean isEmpty() {
    return size == 0; // == operator also is a boolean function, so if size = 0, then it will return true.
  }

  // Wil return true if the Object obn is in the ArrayList and false if it is not in the ArrayList.
  public boolean isIn(Object obn) {
    return find(obn) >= 0; // find(Object n) returns an int, so we can use the value returned. find() will return values less than 0 if and only if the Object is not in the ArrayList.
  }

  // Will return to the location of the first
  // occurence of Object n.
  public int find(Object n) {
    if (n == null) { // check for nulls
      for (int i = 0; i < size; i++) {
        if (elements[i] == null) {
          return i; // returns the index at which Object value is null. return breaks loop.
        }
      }
    } else {
      for (int h = 0; h < size; h++) {
        if (n.equals(elements[h])) {
          return h; // returns the index at which Object is found.
        }
      }
    }
    return -1; // For if the Object is not found in the ArrayList.
  }

  // Will remove the first occurence of
  // Object n.
  public void remove(Object n) {

    if (n == null) { // check for nulls
      for (int j = 0; j < size; j++) {
        if (elements[j] == null) {
            removeHelper(elements, j); // remove the Object value at index j.
        }
      }
    } else {
      for (int k = 0; k < size; k++) {
        if (n.equals(elements[k])) {
           removeHelper(elements, k); // remove the Object value at index k.
        }
      }
    }
  }

  // helper function to for the remove() method. copies arrays without the specified index value.
  private void removeHelper(Object [] obn, int index) {
    Object [] obn2 = new Object [obn.length - 1]; // get size of new array.
    // copy to new array including the values from 0 till index and index till obn.length, but excluding index itself.
    System.arraycopy(obn, 0, obn2, 0, index);
    System.arraycopy(obn, index + 1, obn2, index, obn.length - index - 1);
  }


}
