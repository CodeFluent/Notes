

public class AdvanceTicket extends TicketClass {

  public int days;

  public AdvanceTicket (int number, int days) {
    super(number);
    this.days = days;
  }

  public double getTicPrice () {

    if (days > 10){
      return base = base + 20;
    }
    else {
      return base = base + 30;
    }
  }

  public String toString()  {
      String result = String.format("Number: %05d, Price: %.2f", tickNum, getTicPrice());
      return result;
  }


}
