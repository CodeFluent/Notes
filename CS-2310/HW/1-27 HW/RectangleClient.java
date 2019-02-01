/* Write the client class RectangleClient that creates an object of class Rectangle and
initializes its x coordinate, y coordinates, width and height to 5, 12, 4, and 8
respectively.*/

/* Print out the x- coordinate, y-coordinate, width, height and area of
this rectangle (use toString method to print the area). Then change the size of this
rectangle to width = 3 and height = 10 and then print out the area again. */


/* x-coordinate : 5
y-coordinate : 12
Width : 4
Height : 8
Area : 32
Area after the size is changed : 30 */

public class RectangleClient {

  public static void main(String [] args) {

    Rectangle b1 = new Rectangle(5, 12, 4, 8);

    System.out.println("x-coordinate : " + b1.getX());
    System.out.println("y-coordinate : " + b1.getY());
    System.out.println("Width : " + b1.getWidth());
    System.out.println("Height : " + b1.getHeight());
    System.out.println("Area : " + b1.area());
    b1.changeSize(3, 10);
    System.out.println("Area after the size is changed : " + b1.area());


  }
}
