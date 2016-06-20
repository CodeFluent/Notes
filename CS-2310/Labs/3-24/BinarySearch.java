// calls another method called binarySearch that takes two parameters, an integer and an integer array.
// The call should perfom a binarySearch and should return the index of the integer in the array if found
// and return -(insetionPoint + 1) if the number is not found.
// Print out the index of the main method.

public class BinarySearch {

    public static int binarySearch (int a, int [] b) {

       int start = 0;
       int end = b.length - 1;
       while (start <= end) { // sort till index of b -1
           int m = (start + end) / 2; //get the middle of the array
           if (a == b[m]) {
               return m;
           }
           if (a < b[m]) {
               end = m - 1;
           } else {
               start = m + 1;
           }
       }
       return end;
   }

    public static void main (String [] args) {

        int num = 4;
        int [] b = new int [] {4,45,67,1,12,34,21,23,9,2};
        System.out.print("Index of " + num + ": " + binarySearch(num, b));

    }
}
