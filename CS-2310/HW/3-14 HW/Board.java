
import java.util.*;


public class Board {

    static int size;
    static int row;
    static int col;
    static String [][] display;

    public Board (int size) {

        this.size = size;
        this.display = new String [this.size][this.size];

        // intialize String array with clean board
        for (int i = 0; i < display.length; i++) {
            for (int j = 0; j < display[0].length; j++) {
                System.out.print(display[i][j]="-");
            }
            System.out.println("");
        }
    }

    // Searches for a solution to the 8 queens problem
    // with this board, reporting the first result found.

    public static void solveQueens(Board board) {
        if (!explore(board, 1)) {
             System.out.println("No solution found.");
             } else {
                 System.out.println("One solution is as follows:");
                 System.out.println(board);
            }
    }


    // Recursively searches for a solution to 8 queens on this
    // board, starting with the given col, returning true if a
    // solution is found and storing that solution in the board.
    // PRE: queens have been safely placed in cols 1 to (col-1)

    public static boolean explore(Board board, int col) {
        if (col > board.size()) {
             return true;
             // base case: all cols are placed
              } else {
                  // recursive case: place a queen in this col.
                  for (int row = 1; row <  board.size(); row++) {
                      if (board.isSafe(row, col)) {
                                  board.place(row, col);
                                  if (explore(board, col + 1 ) ) {
                                      return true; // choose
                                         }
                                  board.remove(row, col); // backtrack
                              }
                            }
                            return false;
                        }
                    }



    // Place Q whereever row and col are.
    public void place (int row, int col) {
        display[row][col] = "Q";
    }

    // Remove Q from wheever row and col are.
    public void remove (int row, int col) {
        display[row][col] = "-";
    }

    // get size of board
    public int size() {
        return size;
    }


    public boolean isSafe(int row, int column) {
    for (int y = 0; y < size; y++)
    {
        if (display[row][y] == "Q")
            return true; // possible horizontal attack

        int x1 = row - column + y;
        if (0 <= x1 && x1 < size && display[x1][y] == "Q")
            return true; // diagonal NW

        int x2 = row + column - y;
        if (0 <= x2 && x2 < size && dsi[x2][y] == "Q")
            return true; // diagonal SW
    }

    return false;
}
    // true if Queen can be placed here
    // public boolean isSafe (int row, int col) {
    //     int i;
    //     int j;
    //
    //     // Since explore() looks for col to col-1,
    //     // it assumes that the queen won't collide
    //     // with anything to the right of it.
    //     // only left hand side needs to be checked.
    //
    //     //  X  -  -  X  -  -  X  -
    //     //  -  X  -  X  -  X  -  -
    //     //  -  -  X  X  X  -  -  -
    //     //  X  X  X  Q  X  X  X  X
    //     //  -  -  X  X  X  -  -  -
    //     //  -  X  -  X  -  X  -  -
    //     //  X  -  -  X  -  -  X  -
    //     //  -  -  -  X  -  -  -  X
    //
    //     // check same row all cols
    //     for (i = 0; i < col; i++){
    //         if(display[row][i] == "Q") {
    //             return false;
    //         }
    //     }
    //     // check the left upper diagonal by
    //     // getting int row and int col
    //     // and decrementing them to the
    //     // location of the queen.
    //     for (i = row, j = col; i >= 0 && j >= 0; i--, j-- ) {
    //         if(display[i][j] == "Q") {
    //             return false;
    //         }
    //     }
    //
    //     // check the left lower diagonal by
    //     // getting the int row and int col
    //     // and incrementing the rows up while
    //     // decreasing col to the location of the queen.
    //     for (i = row, j = col; i < size && j >= 0; i++, j-- ) {
    //         if(display[i][j] == "Q") {
    //             return false;
    //         }
    //     }
    //
    //     return true;
    // }

    // get rows and col
    // put a Q there
    // fill in rest of spaces with dashes
    public String toString () {
        return Arrays.deepToString(display);

    }

}
