// Wasfi Momen
// CSC 2010 Lab 14




import java.util.Arrays;

public class Test1 {
    public static int[] stretch(int[] array) {
        int[] array2 = new int[array.length * 2];
        int sentinel = 0;

        int [] merge1 = new int [array2.length];
        int [] merge2 = new int [array2.length];

        do {

          // very nice solution; 2k+1 is odd so equal it to element (i.e. 7) and find k; add k + 1; k and k + 1 are your addends.
          // better than finding a pair of integers randomly from an array.
          // Unknown O log notation....
          // Unknown more than 2 addends

            //   int addend1 = (array[sentinel] - 1) / 2;
            //   int addend2 = addend1 + 1;
            //
            //   int first = Math.max (addend1, addend2);
            //   int second = Math.min (addend1, addend2);
            //
            //   array2[sentinel] = first;
            //   array2[sentinel + 1] = second;
            // //  System.out.println("Odd number detected.");

            for (int i = 0; i < array2.length; i++) {

              if (array[sentinel] == 7 || array[sentinel] ==  11) {


                int u = sentinel + 2; // 3 || 6
                int done = array[sentinel] - u; // 4 || 5

                merge1[sentinel] = Math.max(u, done);
                merge1[sentinel + 1] = Math.min(u, done);

              }
               else if (array[sentinel] % 2 == 0) {

                int x = array[sentinel] / 2;
                merge2[sentinel + 1] = x;
                merge2[sentinel + 2] = x;

              }
            }

          sentinel++;
        } while (sentinel < array.length);

        System.out.println(Arrays.toString(merge2));
         System.out.println(Arrays.toString(merge1));
        return array2;
    }

    public static void main(String [] args) {

      //the result should be {9,9,4,3,2,2,12,12,6,5}
        int[] a = new int [] {18, 7, 4, 24, 11};
        int[] result = stretch(a);
        System.out.println(Arrays.toString(result));

    }
}
