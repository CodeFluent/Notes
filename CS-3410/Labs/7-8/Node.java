import java.util.*;

public class Node {

    Node next; // pointer for the next node in the list
    Object item; // data for the Node

    public Node (Object newItem) {
        next = null; // set intially to null
        item = newItem;
    }

    public Node (Object newItem, Node nextNode) {
        next = nextNode;
        item = newItem;
    }

    public void setNodeData (Object value) {
        item = value;
    }

    public Object getNodeData () {
        return item;
    }

    public void setNextNode (Node here) {
        next = here;
    }

    public Node getNextNode () {
        return next;
    }

}
