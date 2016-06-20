/* Definme a class named Circle. A Circle objkecct stores a readios and the x,y coordinates of the center point. Each circle object should have
3 private fields, x-coordinate, y-coordinate and readios. Each Circle object should have the following public methods.

- circle(x,y,radius)
- getx
-gety
-getradius
- getarea
- getcircumference
- to String (for cicrle's circumfurence using 2pir)
   "Circle [center=(75,20), radius=30]"
- contains(x,y) returns true if the x,y coordinates lie within the cirucle else return false. (calculate the distance between the center
and the x,y and compare with radius)

*/

import java.util.*;

public class Circle {

  private double radius;
  private double x;
  private double y;

  public Circle (double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }
  public double getRadius() {
    return radius;
  }
  public double getArea() {
    return radius * radius * Math.PI;
  }
  public double getCircumference() {
    return 2 * Math.PI * radius;
  }
  public String toString() {
    // "Circle [center=(75,20), radius=30]"
    //return String.format(" The thing is (%.2f , %.2f)", x, y);
    return ("Circle [center=(" + x + "," + y + "), "+ "radius= "+ radius + "]");
 }
 public String contain(double x1, double y1) {
   //  contains(x,y) returns true if the x,y coordinates lie within the cirucle else return false.
  // (calculate the distance between the center and the x,y and compare with radius)
   double i = (x1 - x) * (x1 - x);
   double j = (y1 - y) * (y1 - y);

   if ((i + j) < radius * radius) {
     return "(" + x1 + "," + y1 + ") lies within the circle." ;
   }
   else {
     return "(" + x1 + "," + y1 + ") does not lie within the circle." ;
   }

   }


 }
