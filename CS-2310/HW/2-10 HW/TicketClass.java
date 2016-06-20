

public class TicketClass {

    public int tickNum;
    public double base = 10.00;


    public TicketClass(int number)  {
        this.tickNum = number;
    }

    public double getTicPrice()  {
        return base;
    }

    public String toString()  {
        String result = String.format("Number: %05d, Price: %.2f", tickNum, getTicPrice());
        return result;
    }
}
