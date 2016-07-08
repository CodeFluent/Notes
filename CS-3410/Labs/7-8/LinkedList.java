/*
    Write your own LinkedList class and implement constructors, getters, and setters and maybe a few other methods.
 */

public class LinkedList {

    private Node head;
    private int counter; // tracks the number of elements in the list

    public LinkedList (Object data) {
        counter = 0;
        head = null; // head will start off null
    }

    public void insert () {}
    public void delete () {}
    public int size () {}
    public void printList () {}



}

private class Node {

    Node next; // pointer for the next node in the list
    Object datum; // data for the Node

    public Node (Object data) {
        next = null; // set intially to null
        datum = data;
    }

    public Node (Object data, Node nextNode) {
        next = nextNode;
        datum = data;
    }

    public void setNodeData (Object value) {
        data = value;
    }

    public Object getNodeData () {
        return data;
    }

    public void setNextNode (Node here) {
        next = here;
    }

    public Node getNextNode () {
        return next;
    }

}
