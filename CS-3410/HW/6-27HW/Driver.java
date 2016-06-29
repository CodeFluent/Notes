import java.util.Random;

public class Driver {

    public static void main (String [] args) {

        Random rand = new Random();

        int min = 1;
        int max = 20;


        // Test the constructors and their methods.
        System.out.println("------------------------------------------");
        System.out.println("| Testing empty parameter constructor... |");
        System.out.println("------------------------------------------");

        // (Technically) Return method ArrayList(). Print size to confirm that ArrayList holds 10 values.
        // Return method size(). See if it gives the ArrayList's size.
        ArrayList a1 = new ArrayList();
        System.out.println("ArrayList's size: " + a1.size());


        // Adding 50 integers ranging from 1 - 20.
        // Testing add() method.
        System.out.print("\nAdd() method called. New values added to ArrayList: (");
        for(int i = 0; i <= 50; i++) {
            int randomInteger = rand.nextInt( max - min + 1) + min;
            a1.add(randomInteger);
            System.out.print(" " + randomInteger);
        }
        System.out.print(" )");
        System.out.println();


        // Return method isEmpty(). See if it returns false.
        System.out.println("\nboolean isEmpty() returned: " + a1.isEmpty());



        int locate = 2; // Used for isIn() and find().

        // Return method isIn(). See if it finds if the object is there.
        System.out.println("\nboolean isIn() for value of " + locate + " is: " + a1.isIn(locate));

        // Return method find(). See if it finds the location of locate.
        System.out.println("\nfind() has found value of " + locate + " at position: " + a1.find(locate) + " (-1 if Object is not found)");


        // Used for add method.
        int at = 0;
        int here = 100;

        // Testing add(int index, Object obn) method. See if it adds to the end of the list.
        a1.add(at, here);
        System.out.print("\nAdd(int index, Object obn) has been called with index at position " + at + " and with Object value " + here);
        System.out.println();


        int index = 0; // Used for get() and remove().

        // To help compare and contrast.
        System.out.println("\nCurrent ArrayList: ");
        System.out.print("[");
        for(int k = 0; k <= a1.size() - 1; k++) {
            System.out.print(" " + a1.get(k));
        }
        System.out.print(" ]");
        System.out.println();

        // Return method get(int index). See if it gets the value of specified index.
        System.out.println("\nget() at index " + index + " returned the value of: " + (a1.get(index)));


        // Return method remove(). See if it removes the object from the ArrayList.

        System.out.print("\nRemoved value at index " + index + ". New ArrayList: [");

        for(int j = 0; j <= a1.size() - 1; j++) {
            System.out.print(" " + a1.get(j));
        }
        System.out.print(" ]");



        System.out.println();
        System.out.println();

        System.out.println("----------------------------------------");
        System.out.println("| Testing one parameter constructor... |");
        System.out.println("----------------------------------------");

        // (Technically) Return method ArrayList(). Print size to confirm that ArrayList holds 10 values.
        // Return method size(). See if it gives the ArrayList's size.
        ArrayList a2 = new ArrayList(50);
        System.out.println("ArrayList's size: " + a2.size());


        // Adding 50 integers ranging from 1 - 20.
        // Testing add() method.
        System.out.print("\nAdd method called. New values added to ArrayList: (");
        for(int i2 = 0; i2 <= 50; i2++) {
            int randomInteger2 = rand.nextInt( max - min + 1) + min;
            a2.add(randomInteger2);
            System.out.print(" " + randomInteger2);
        }
        System.out.print(" )");
        System.out.println();

        // Return method isEmpty(). See if it returns false.
        System.out.println("\nboolean isEmpty() returned: " + a2.isEmpty());


        int locate2 = 2; // Used for isIn() and find().

        // Return method isIn(). See if it finds if the object is there.
        System.out.println("\nboolean isIn() for value of " + locate2 + " is: " + a2.isIn(locate2));

        // Return method find(). See if it finds the location of locate.
        System.out.println("\nfind() has found value of " + locate2 + " at position: " + a2.find(locate2) + " (-1 if Object is not found)");

        // Used for add method.
        int at2 = 0;
        int here2 = 1001;

        // Testing add(int index, Object obn) method. See if it adds to the end of the list.
        a2.add(at2, here2);
        System.out.print("\nAdd(int index, Object obn) has been called with index at position " + at + " and with Object value " + here);
        System.out.println();


        int index2 = 0; // Used for get() and remove().

        // To help compare and contrast.
        System.out.println("\nCurrent ArrayList: ");
        System.out.print("[");
        for(int k2 = 0; k2 <= a2.size() - 1; k2++) {
            System.out.print(" " + a2.get(k2));
        }
        System.out.print(" ]");
        System.out.println();

        // Return method get(int index). See if it gets the value of specified index.
        System.out.println("\nget() at index " + index2 + " returned the value of: " + (a2.get(index2)));


        // Return method remove(). See if it removes the object from the ArrayList.
        System.out.print("\nRemoved value at index " + index2 + ". New ArrayList: [");

        for(int j2 = 0; j2 <= a2.size() - 1; j2++) {
            System.out.print(" " + a2.get(j2));
        }
        System.out.print(" ]");



        System.out.println();
    }
}
