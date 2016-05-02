// Write the complete Board.java class and the complete solveQueens.java class
// that will solve the "8 Queens" problem described in the slides provided in BrightSpace.
// The slides provide partial solution to the problem.


// Your program should print the solution in the following format.
// One solution is as follows:
//
//  Q  -  -  -  -  -  -  -
//  -  -  -  -  -  -  Q  -
//  -  -  -  -  Q  -  -  -
//  -  -  -  -  -  -  -  Q
//  -  Q  -  -  -  -  -  -
//  -  -  -  Q  -  -  -  -
//  -  -  -  -  -  Q  -  -
//  -  -  Q  -  -  -  -  -

public class solveQueens {

    public static void main (String [] args) {

        Board b = new Board(8);

        b.explore(b , 1);
        b.solveQueens(b);


    }
}
