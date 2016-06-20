/* Write a client program called BankAccountClient that creates a BankAccount object called b1 and assigns "John" to its name field and 1000 to balance
field. Call the deposit method to deposit 500 to this account and call the display method to display the current balance. then withdraw 300
from this account and call the display method to display the current balance. Create another object called b2 and display the name and the current balance
for the object.

*/

public class BankAccountClient {

  public static void main (String [] args) {

    BankAccount B1 = new BankAccount("John", 1000);
    B1.deposit(500);
    B1.displayBalance();
    B1.withdraw(300);

    BankAccount B2 = new BankAccount();
    B2.displayBalance();


  }
}
