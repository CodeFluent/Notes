// Wasfi Momen
// CSC 2010 Lab
// Lab 13
// Li


public class Lab13 {

  public static void swapAll (int [] a1, int [] a2) {

    //note: creating variables is more expensive than just using logic.
    //  java does have a XOR operator ^ that can be used in this program as follows:
    //  a1[0] = a1[0] ^ a2 [0];
    //  a2[0] = a1[0] ^ a2[0];

    int [] place;
    for (int y=0; y<a1.length; y++) {
      place[y] = a1[y];
    } //holds the values of a1

    for (int i=0; i < a1.length; i++) {
          a1 [i] = a2[i]; //swaps the values of a1 with every value in a2
      }

    for (int j=0; j < a2.length; j++ ) {
       a2[j] = place [j];
    }

    for (int it =0; it < a1.length; it++){
      System.out.println("a1" + a1[it] + " " );
    }
  }

  public static void main (String [] args) {

    int[] a1 = {1,2,3,4};
		int[] a2 = {4,3,2,1};
		swapAll(a1,a2);
		//a1 should be {4,3,2,1}
		//a2 should be {1,2,3,4}


  }
}
