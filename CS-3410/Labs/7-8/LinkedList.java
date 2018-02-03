import java.util.*;

/*
    Write your own LinkedList class and implement constructors, getters, and setters and maybe a few other methods.
 */

public class LinkedList {

    public Node head; // references the currently tracked Node
    public int counter; // tracks the number of elements in the list


    public LinkedList () {

    }

    public void insert (Object data, int index ) {
        Node temp = new Node (data); // create a node to hold the passed data.
        Node curr = head;

        // crawl to the passed index
        if(curr != null) {
            for(int i = 0; i < index && curr.getNextNode() != null; i++) {
                curr = curr.getNextNode(); // get the current next node reference.
            }
        }

        temp.setNextNode(curr.getNextNode()); // set the temp node to the current next node reference.

        curr.setNextNode(temp); // set the current node's next node reference to temp.

        counter++; // increment counter
    }

    public void add (Object data) {

        // special case if head is null
        if(head == null) {
            head = new Node(data);
        }

        Node temp = new Node (data);
        Node curr = head; // set current to the head node

        // crawl to the list until we hit null.
        // there we will add the temp node.
        if(curr != null) {
            while(curr.getNextNode() != null) {
                curr = curr.getNextNode();
            }

            // set the link of the last node to temp.
            // temp is now at the end of the list with data and with a null pointer.
            curr.setNextNode(temp);
        }

        // increment counter to give us the list's size.
        counter++;
    }

    public boolean delete (int index) {

        // out of range
        if (index < 1 || index > counter) {
            return false;
        }
        Node curr = head;

        if(head != null) {
            for (int i = 0; i < index; i++) {
                if(curr.getNextNode() == null) {
                    return false;
                }
                curr = curr.getNextNode(); // get the index's nextNode.
            }
            curr.setNextNode(curr.getNextNode().getNextNode()); // get 2 nodes down and set current to that.
            counter--;
            return true;
        }
        return false;
    }

    public Object get (int index) {

        // special case for index below 0.
        if (index <= 0) {
            return null;
        }
        Node curr = null;
        // crawl through the list to the index.
        if(head != null) {
            curr = head.getNextNode();
            for(int i = 0; i < index; i++) {
                // special case for tail.
                if (curr.getNextNode() == null) {
                    return null;
                }
                curr = curr.getNextNode();
            }
            return curr.getNodeData();
        }
        return curr;
    }

    public int size () {
        return counter;
    }

    public String printList () {

        String output = " ";


        if (head != null) {
            Node curr = head.getNextNode();

            // crawl the list until you reach the null terminator.
            while (curr != null) {
                output += "[" + curr.getNodeData() + "]";
                curr = curr.getNextNode();
            }

        }

        return "List: " + output;
    }



}
