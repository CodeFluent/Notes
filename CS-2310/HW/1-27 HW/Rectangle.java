// A Rectangle stores an (x, y) coordinate of its top/left corner, a
// width and height.


public class Rectangle {
 private int x;
 private int y;
 private int width;
 private int height;

 // constructs a new Rectangle with the given x,y, width, and height
 public Rectangle(int x, int y, int w, int h) {
   this.x=x;
   this.y=y;
   this.width=w;
   this.height=h;
 }

 // returns the fields' values
 public int getX() {
   return x;
 }
 public int getY() {
   return y;
 }
 public int getWidth() {
   return width;
 }
 public int getHeight() {
   return height;
 }

 // Write an instance method called area that will be placed inside the Rectangle
 // class. The method returns the area of the rectangle.
 public int area() {
     return width * height;
 }

 // This method changes the height and width of the rectangle. The
 // method accepts newWidth and newHeight as parameters and changes the value of
 // width and height to this new width and height.
 public void changeSize(int newWidth, int newHeight) {
   width = newWidth;
   height = newHeight;
 }

 // returns a string such as {(5,12), 4x8}

}
