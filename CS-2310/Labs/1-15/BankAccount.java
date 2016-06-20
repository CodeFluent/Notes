
/* Write a Java class called BankAccount which has two field names String and balance (double) and three methods depost (double amount),
withdraw (double amount) and displayBalance() deposit method depostits the amount to the account causing the current balance to increase, withdraw method
withdraws the amount causing the current blanace to decrease and displayBalance method prints out the account name and the current balance spearated by a comma.

ex. Jake, $40.00 for String Jake and blance is 40.0
*/

public class BankAccount {

  String name;
  private double balance;

  public BankAccount () {
     name = null;
     balance = 0.0;
  }

  public BankAccount (String newName, double newBalance) {
    name = newName;
    balance = newBalance;
  }

  public void deposit (double amount) {
    balance = balance + amount;
  }

  public void withdraw (double amount) {
    balance = balance - amount;
  }

  public void displayBalance () {
    System.out.println(name + ", $"  + balance);
  }


}
