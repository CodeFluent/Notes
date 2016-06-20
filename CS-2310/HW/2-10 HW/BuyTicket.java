

public class BuyTicket {

 public static void main (String[] args){

 System.out.println();

 WalkupTicket wt1=new WalkupTicket(12);
 System.out.println(wt1);

 AdvanceTicket at1=new AdvanceTicket (13,12);
 System.out.println(at1);

 AdvanceTicket at2 = new AdvanceTicket(14,2);
 System.out.println(at2);

 StudentAdvanceTicket sat1= new StudentAdvanceTicket(15,20);
 System.out.println(sat1);

 StudentAdvanceTicket sat2= new StudentAdvanceTicket(16,4);
 System.out.println(sat2);

  }
}
// Sample Output
// Number: 12, Price: 50.0
// Number: 13, Price: 30.0
// Number: 14, Price: 40.0
// Number: 15, Price: 15.0 (ID required)
// Number: 16, Price: 20.0 (ID required)
