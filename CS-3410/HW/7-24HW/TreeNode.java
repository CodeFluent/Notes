/**
 * Class TreeNode creates the nodes for the binary tree.
 * It only has an int value, a left, and a right child.
 * Intially, left and right child is set to null.
 */

public class TreeNode {

    static int value;
    static TreeNode leftChild;
    static TreeNode rightChild;



    public String toString() {
        String here = Integer.toString(value);
        return here;
    }

}
