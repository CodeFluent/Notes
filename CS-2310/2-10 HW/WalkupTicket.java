

public class WalkupTicket extends TicketClass{

  public WalkupTicket (int number) {
    super(number);
  }

  public double getTicPrice()  {
      return base + 40.00;
  }


}
