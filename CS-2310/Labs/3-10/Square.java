// Write a program that calls a recursive method called writeSquares that accepts an interger parameter n
// and prints the first n squares separated by commas, with the odd squares in descending order
// followed by the even squares in ascending order.
//
// Output:
// writeSquares(9); 81,49,25,9,1,4,16,36  <-- descending, odd
// writeSquares(1); 1
// writeSquares(8); 49,25,9,1,4,16,36,64  <-- ascending, even
// writeSquares(4); 9,1,4,16              <-- ascending, even


public class Square {

    public static void writeSquares (int n) {

        if (n == 0) { // base case
            System.out.println();
        } else if (n % 2 == 0){
            // do even case, print lowest first then highest
            int k = n * n;
            writeSquares(n-1);  // recursive case
            System.out.print(", " + k);
        } else {
            // do odd case, print highest first then lowest
            System.out.print( (n*n) );

            // recursive case
            if (n > 1) {
            System.out.print( ", " );
            writeSquares(n-1);
            }

        }
    }

    public static void main (String [] args) {

        System.out.println();
        System.out.print("writeSquares(9): ");
        writeSquares(9);
        System.out.println();
        System.out.println();
        System.out.print("writeSquares(1): ");
        writeSquares(1);
        System.out.println();
        System.out.println();
        System.out.print("writeSquares(8): ");
        writeSquares(8);
        System.out.println();
        System.out.println();
        System.out.print("writeSquares(4): ");
        writeSquares(4);
        System.out.println();
    }

}
