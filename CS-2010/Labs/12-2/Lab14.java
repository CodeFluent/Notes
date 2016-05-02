// Wasfi Momen
// Lab 14


import java.util.Arrays;

public class Lab14 {

  public static int[] stretch(int[] array) {

      int[] result = new int[2*array.length];
      int sentinel = 0;


      do {

        for(int y = 0; y < array.length; y++) {

          result[2 * y] = array[y] % 2 + array[y] / 2; // stores evens
          result[2 * y + 1] = array[y] / 2; // stores odds

        }

        sentinel++;

      } while(sentinel < array.length);


        return result;

}
  public static void main (String [] args) {

    // the result should be {9,9,4,3,2,2,12,12,6,5}
    int [] make = new int [] {18, 7, 4, 24, 11};
    int [] output = stretch(make);
    System.out.print(Arrays.toString(output));


    }
}
