import java.util.*;

public class Test {

    public static void main(String[] args) {
        LinkedList now = new LinkedList();

        now.add("1");
        now.add("2");
        now.add("3");
        now.add("4");
        now.add("5");

        System.out.println("Print: " + now.printList() );
        System.out.println("Size: " + now.size());
        System.out.println("Value at index of 3: " + now.get(3));
        System.out.println("Remove index 2: " + now.delete(2));
        System.out.println("Value at index of 3: " + now.get(3));
        System.out.println("Size: " + now.size());
        System.out.println("Print: " + now.printList());
    }
}
