

public class TreeNode {

    static int value;
    static TreeNode leftChild;
    static TreeNode rightChild;

    public TreeNode (int data) {
        value = data;
        leftChild = null;
        rightChild = null;
    }

    //
    // public void setValue(Object item) {
    //     value = item;
    // }
    // public Object getValue() {
    //     return value;
    // }
    // public void setLeftChild(TreeNode now) {
    //     leftChild = now;
    // }
    // public TreeNode getLeftChild () {
    //     return leftChild;
    // }
    // public void setRightChild(TreeNode now) {
    //     rightChild = now;
    // }
    // public TreeNode getRightChild () {
    //     return rightChild;
    // }
    //

    public String toString() {
        String here = Integer.toString(value);
        return here;
    }

}
