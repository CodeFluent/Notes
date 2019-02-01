// BankAccount class for the BankAccountClient class.
// Has the following:
//     -

public class BankAccount {

  String firstName;
  String lastName;
  private double balance;

  public BankAccount () {
      firstName = "";
      lastName = "";
      balance = 0;
  }

  public BankAccount (String infirstName, String inlastName, double newBalance) {
      firstName = infirstName;
      lastName = inlastName;
      balance = newBalance;
  }

  // Setter method for the firstName variable. Receives a String argument newfirstName and assigns it to firstName.
  public void setfirstName (String newfirstName){
      firstName = newfirstName;
  }

  // Setter method for the lastName variable. Receives a String argument newlastName and assigns it to firstName.
  public void setlastName (String newlastName){
     lastName = newlastName;
  }

  // Setter method for the balance variable. Receives a double newBalance and assigns it to balance.
  public void setBalance (double newBalance){
     balance = newBalance;
  }

  // Getter method to return a String firstName.
  public String getfirstName() {
      return firstName;
  }

  // Getter method to return a String lastName.
  public String getlastName() {
      return lastName;
  }

  // Getter method to return a double balance.
  public double getBalance(){
      return balance;
  }

  // Deposit method that receives a double arguement amount and adds it to the current balance.
  public void deposit (double amount) {
      balance = balance + amount;
  }

  // Withdraw method that receives a double arguement amount, checks to see whether the amount value specified is larger than balance (and if so print out a String message) or subtracts the amount value from balance.
  public void withdraw (double amount) {
    if (amount > balance){
        System.out.println("Withdraw amount is above balance amount! Balance is currently " + balance + " and withdrawn amount asked for is " + amount + ".");
    } else {
        balance = balance - amount;
    }
  }

}
