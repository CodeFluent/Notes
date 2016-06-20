// Write another class called Circle that has 2 fields; a double field called radius
// and a Point object that stores coordinates of the central point of the circle.
// The class should have the necessary accessors, mutators, and constructors.
//
// Use the compareTo method to define a natural order for the Circle class. The objects
// should be ordered based on the area of the circle. If the circle have equal area then they
// should be ordered according to the x-coordinates and if the x-coordinates are the same, then use
// the y-coordinates to define the order.

import java.util.*;

public class Circle extends Point implements Comparable <Circle> {


    private double radius = 0.0;
    private Point center;
    private int x;
    private int y;


    public Circle(Point center, int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return  Math.PI * radius * radius;
    }

    public int compareTo (Circle c) {


        if (c.getArea() == this.getArea()) {
            if (c.getX() < this.getX()) {
                return 1;
            }
            else if (c.getX() > this.getX()) {
                return -1;
            }
            else if (c.getX() == this.getX()) {
                if (c.getY() < this.getY()) {
                    return 1;
                }
                else if (c.getY() > this.getY()) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
        else if (c.getArea() != this.getArea()) {
            if (c.getArea() < this.getArea()) {
                return 1;
            }
            else if (c.getArea() > this.getArea()) {
                return -1;
            }
            else {
                return 0;
            }
        }
        return 0;
    }

    public String toString() {
        return "( area = " + this.getArea() + ")";
    }


}
