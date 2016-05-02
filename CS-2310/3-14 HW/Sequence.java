// Write a method writeSequence that accepts an integer n as a parameter and prints a
// symmetric sequence of n numbers with descending integers ending
// in 1 followed by ascending integers beginning with 1.
//
// Example Output:

// Call              Output
// writeSequence(1); 1
// writeSequence(2); 1 1
// writeSequence(3); 2 1 2
// writeSequence(4); 2 1 1 2
// writeSequence(5); 3 2 1 2 3
// writeSequence(6); 3 2 1 1 2 3
// writeSequence(7); 4 3 2 1 2 3 4
// writeSequence(8); 4 3 2 1 1 2 3 4
// writeSequence(9); 5 4 3 2 1 2 3 4 5
// writeSequence(10); 5 4 3 2 1 1 2 3 4 5

// Notice that for odd numbers the sequence has a single 1
// in the middle while for even values it has two 1s in the middle.
// A client using this method would have to call println to print the line of output.


public class Sequence {

    public static void writeSequence(int n) {

            // base case
            if (n == 1) {
                System.out.print(n);
            } else if (n == 2) {                        // without recursive case
                System.out.print(n / 2 + " " + n / 2);
            } else if (n % 2 == 0) {
                System.out.print(n / 2 + " ");
                writeSequence(n - 2);                   // recursive case
                System.out.print(" " + n / 2);
            } else if (n % 2 == 1) {
                System.out.print((n / 2 + 1) + " ");
                writeSequence(n - 2);                   // recursive case
                System.out.print(" " + (n / 2 + 1));
            }
   }

    public static void main (String [] args) {
        writeSequence(1);
        System.out.println();
        writeSequence(2);
        System.out.println();
        writeSequence(3);
        System.out.println();
        writeSequence(4);
        System.out.println();
        writeSequence(5);
        System.out.println();
        writeSequence(6);
        System.out.println();
        writeSequence(7);
        System.out.println();
        writeSequence(8);
        System.out.println();
        writeSequence(9);
        System.out.println();
        writeSequence(10);
        System.out.println();


    }
}
