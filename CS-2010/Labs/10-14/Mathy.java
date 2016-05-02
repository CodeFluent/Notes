/*
* Wasfi Momen
* CS Lab 8
*/

public class Mathy{

  public static void main(String[] args){
      int num1, num2;
      double d1, d2, d3;
      String fname, lname;
      System.out.println(); // print out space to keep it nice and clean
      method1(10,20);
      System.out.println(); // print out space to keep it nice and clean
      method2(5.0,10.0,100.0);
      System.out.println(); // print out space to keep it nice and clean
      method3("Bing","Li");
  }
    public static void method1(int num1, int num2){
        //difference  postive integer
        int numDiff = num1 - num2;
        System.out.println("The difference of " + num1 + " and " + num2+ " is " + numDiff+ ".");
    }
    public static void method2(double d1,double d2,double d3){
        //average of these three numbers
        double avg = ((d1+d2+d3)/3);
        System.out.println("The average of "+ d1 + " ," + d2 + " ,"+ " and " + d3 + " is " + avg + ".");
    }
    public static void method3(String fname,String lname){
        //fname_lname
       System.out.println(fname + " "+ lname);

    }

}
