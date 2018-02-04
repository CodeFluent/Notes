/**
 * Class Node creates the nodes for the binary tree.
 * It only has an int value, a left, and a right child.
 *
 * It also has a toString() method to help print out the Nodes.
 */

public class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public String toString() {
        String now = Integer.toString(value);
        return now;
    }
}
