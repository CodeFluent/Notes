/* Write a client class that should intialize to x,y (10,5) and radius 7. Print the object. Print out its circumfurence
and area. If point (5,7) lies within the circle print "(5,7) lies within the cirucle" else print "(5,7) does not lie within
the circle"
*/

public class CircleClient {

  public static void main (String [] args) {

    Circle c1 = new Circle (10, 5, 7);
    System.out.println(c1.toString());
    System.out.println();
    System.out.println("Circumfurence is " + c1.getCircumference());
    System.out.println();
    System.out.println(c1.contain(5,7));

  }

}
