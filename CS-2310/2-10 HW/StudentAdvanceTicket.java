

public class StudentAdvanceTicket extends AdvanceTicket {

  public StudentAdvanceTicket (int number, int days) {
    super(number, days);

  }

  public double getTicPrice () {

    if (days > 10){
      return base = base + 5;
    }
    else {
      return base = base + 10;
    }
  }

  public String toString()  {
      String result = String.format("Number: %05d, Price: %.2f (ID Required)", tickNum, getTicPrice());
      return result;
  }
}
