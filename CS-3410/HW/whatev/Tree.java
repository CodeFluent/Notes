public class Tree {


    /**
     * insert() takes an integer parameter and a Node object and places a new Node accordingly based on if the data of the node is greater than, less than or equal to the root value. This method is called recursively.
     * @param   root is a Node object that will be passed in and recursively called in insert
     * @param   here is the int value of the new Node to be added to the tree.
     * @return  returns a Node object to its proper position in the Tree.
     */
    public Node insert(Node root, int here) {
        if (root == null) {
            root = new Node();
            root.value = here;
            // System.out.print("Root ");
        } else if (here < root.value) {
            // here is less than root.value, new TreeNode is placed in the left subtree.
            root.leftChild = insert(root.leftChild, here);
            // System.out.print("Left ");
        } else {
            // here is greater than or equal to root.value, new TreeNode is placed in the right subtree.
            root.rightChild = insert(root.rightChild, here);
            // System.out.print("Right ");
        }

        return root;
    }

    /**
     * inOrder() takes a Node object as a parameter and recursively looks for the root in an inOrder transverse aka Left-Parent-Right. Each Node is analyzed for its Node children.
     * @param root is the Node object being passed in to transverse the tree in inOrder transversal.
     */
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.leftChild);
        System.out.print(" " + root);
        inOrder(root.rightChild);
    }
}
