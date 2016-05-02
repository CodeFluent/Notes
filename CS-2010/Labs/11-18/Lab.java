// Wasfi Momen
// CSC 2010 Lab
// Lab 13
// Li


public class Lab {

public static void swapAll (int [] a1, int [] a2) {

    //note: creating variables is more expensive than just using logic.
    //  java does have a XOR operator ^ that can be used in this program as follows:
    //  a1[0] = a1[0] ^ a2 [0];
    //  a2[0] = a1[0] ^ a2[0];

    int [] place = a1;
    a1 = a2;
    a2 = place;

    System.out.print("Value of a1: ");

    for (int i=0; i < a1.length; i++) {
      System.out.print(a1[i] + " ");
    }

    System.out.println();
    System.out.print("Value of a2: ");

    for (int j=0; j < a2.length; j++) {
      System.out.print(a2[j] + " ");
    }

}
 public static void main (String [] args)  {

    int[] a1 = {1,2,3,4};
		int[] a2 = {4,3,2,1};
		swapAll(a1,a2);
		//a1 should be {4,3,2,1}
		//a2 should be {1,2,3,4}


  }
}
