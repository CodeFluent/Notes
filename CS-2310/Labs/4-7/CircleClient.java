// Also write a client class that creates an array of circles and use the Arrays.sort()
// method to see if the compareTo method you wrote works as intended.

import java.util.*;


public class CircleClient {

    public static void main (String [] args) {

        Circle [] ca1 = new Circle [3];

        Point c = new Point (2,3);
        Circle circle = new Circle(c, 50);

        Point c1 = new Point ();
        c1.setX(3);
        c1.setY(5);
        Circle circle1 = new Circle(c1, 23);

        Point c2 = new Point (2,9);
        Circle circle2 = new Circle(c2, 2);


        ca1[2] = circle2;
        ca1[1] = circle1;
        ca1[0] = circle;

        System.out.println();
        System.out.println("------------Unsorted------------");
        System.out.println();
        System.out.println(Arrays.toString(ca1));


        Arrays.sort(ca1);


        System.out.println();
        System.out.println("------------Sorted------------");
        System.out.println();
        System.out.println(Arrays.toString(ca1));


    }
}
