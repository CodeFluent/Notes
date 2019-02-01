
public class BankAccountClient {

    public static void main (String [] args) {

        // Test the constructors.
        System.out.println();
        System.out.println("Testing first empty constructor...\n");
        System.out.println("---------------------------------");
        BankAccount b1 = new BankAccount();
        System.out.println("First Name: " + b1.getfirstName());
        System.out.println("Last Name: " + b1.getlastName());
        System.out.println("Balance: " + b1.getBalance());
        System.out.println("---------------------------------");


        System.out.println();

        System.out.println("Testing next 3 parameter constructor...");
        System.out.println("---------------------------------");
        BankAccount b2 = new BankAccount("Yu", "Shao", 30.00);
        System.out.println("First Name: " + b2.getfirstName());
        System.out.println("Last Name: " + b2.getlastName());
        System.out.println("Balance: " + b2.getBalance());
        System.out.println("---------------------------------");


        System.out.println();

        // Test the deposit and withdraw methods
        System.out.println("Testing the deposit and withdrawal methods...");

        System.out.println();

        System.out.println("Empty Constructor...");
        System.out.println("---------------------------------");
        b1.withdraw(400.00);
        b1.deposit(20.00);
        System.out.println(b1.getBalance());
        b1.withdraw(10.00);
        System.out.println(b1.getBalance());
        System.out.println("---------------------------------");


        System.out.println("3 Parameter Constructor...");
        System.out.println("---------------------------------");
        b2.withdraw(400.00);
        b2.withdraw(20.00);
        System.out.println(b2.getBalance());
        b2.deposit(10.00);
        System.out.println(b2.getBalance());
        System.out.println("---------------------------------");



    }
}
