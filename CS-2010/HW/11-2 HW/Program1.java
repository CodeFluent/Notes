// Wasfi Momen
// HW 4


import java.util.Scanner;

public class Program1 {


  public static void getTotalPay(int hoursWorked, double payRate) {

    double finalSum;

    if (hoursWorked <= 40) {
      finalSum = (hoursWorked * payRate);
      System.out.println(finalSum);
    }
    else {
      for (int i=1; hoursWorked >= 40; i++){
        payRate += i;
        finalSum = (hoursWorked * payRate);
        System.out.println(finalSum);
      }

      System.out.println();
    }


  }




  public static double getPercentage(int hoursWorked) {
    double fraction = (hoursWorked * 100);
    double percent = (fraction / 40);
    return percent;
  }

  // public static void displayOutput() {
  //  getTotalPay();
  // }




  public static void main(String [] args){

    int hoursWorked;
    double payRate;


    Scanner paygrade = new Scanner(System.in);

    System.out.println();
    System.out.println("How many hours did you work this week? \n");
    hoursWorked =  paygrade.nextInt();
    System.out.println();
    System.out.println("What is your pay rate? \n");
    payRate = paygrade.nextDouble();


    // displayOutput(getTotalPay());
    System.out.println();
    System.out.println();
    System.out.println("Pay Rate: " + "$" + payRate);
    System.out.println("Hours Worked: " + hoursWorked);
    System.out.println("Percentage worked per week: " + getPercentage(hoursWorked) + "%");
    System.out.print("Total pay earned: " + "$");
    getTotalPay(hoursWorked, payRate);





  }


}
