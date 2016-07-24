public class Tree {

    static TreeNode root;

    public Tree () {
        root = null;
    }


    public static void insert(int here) {

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
            root = new TreeNode(here);
            System.out.println("Root");
            return;
        }
        if(root.value < here) {
            root.rightChild = new TreeNode(here);
            System.out.println("Right");
            return;
        } else {
            root.leftChild = new TreeNode(here);
            System.out.println("Left");
            return;
        }

    }

    

    public static void inOrder (TreeNode focus) {

        if(focus != null) {
            inOrder(focus.leftChild);
            System.out.println(focus);
            inOrder(focus.rightChild);
        }
    }
}
