public class Tree {


    /**
     * insert() takes an integer parameter and places a new TreeNode accordingly based on if the data of the node is greater than, less than or equal to
     * @param here integer parameter that will be put into a new TreeNode and placed into the tree.
     * @post will place a new TreeNode with the integer parameter into the correct position in the Tree.
     */
    public TreeNode insert(TreeNode root, int here) {

        // TreeNode newNode = new TreeNode(here);
        //
        // // special case if the root is null
        // if(root == null) {
        //         root = newNode;
        //         System.out.println("Yo");
        //     }  else {
        //         TreeNode curr = root;
        //         TreeNode parent;
        //
        //         // infinite loop until return.
        //         while(true) {
        //             parent = curr; // set the parent to the root for now.
        //
        //             // Case 1: newNode value is less than parent so it is in left subtree.
        //             if(newNode.value < curr.value) {
        //                 curr = curr.leftChild;
        //
        //                 // current has no leftChild, the newNode is the leftChild.
        //                 if(curr == null) {
        //                     parent.leftChild = newNode;
        //
        //                     return;
        //                 }
        //             } else {
        //
        //             // Case 2: newNode value is greater than or equal the parent so it is rightsubtree.
        //             curr = curr.rightChild;
        //
        //             // current has no rightChild, the newNode is the rightChild.
        //             if(curr == null) {
        //                 System.out.println("rightChild");
        //
        //                 parent.rightChild = newNode;
        //                 return;
        //             }
        //             }
        //         }
        //
        //     }

        if(root == null) {
            root = new TreeNode();
            root.value = here;
        }
        // here is greater than or equal to root.value, new TreeNode is placed in the right subtree.
        else if(here < root.value) {
            root.leftChild = insert(root.leftChild, here);
        } else {
            root.rightChild = insert(root.rightChild, here);
        }

        //  else if(root.value <= here) {
        //     root.rightChild = insert(root.rightChild, here);
        // } else {
        //     // here is less than root.value, new TreeNode is placed in the left subtree.
        //     root.leftChild = insert(root.leftChild, here);
        // }

        return root;

    }


    // LPR
    public void inOrder (TreeNode focus) {

        if(focus == null) {
            return;

        }

        inOrder(focus.leftChild);
        System.out.println(focus);
        inOrder(focus.rightChild);
    }
}
