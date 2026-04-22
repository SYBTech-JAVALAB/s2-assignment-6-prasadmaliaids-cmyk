import java.util.Scanner;

// Custom Exception
class LessBalanceException extends Exception {
    LessBalanceException(double amount) {
        super("Withdraw amount (Rs " + amount + ") is not valid. Insufficient balance.");
    }
}

// Account Class
class Account {
    double balance;

    // Constructor
    Account(double balance) {
        if (balance < 1000) {
            this.balance = 1000;
            System.out.println("Minimum balance set to Rs 1000");
        } else {
            this.balance = balance;
        }
    }

    // Deposit Method
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs " + amount);
    }

    // Withdraw Method
    void withdraw(double amount) throws LessBalanceException {
        if ((balance - amount) < 1000) {
            throw new LessBalanceException(amount);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: Rs " + amount);
        }
    }

    void display() {
        System.out.println("Current Balance: Rs " + balance);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter initial balance: ");
            double bal = sc.nextDouble();

            Account acc = new Account(bal);

            System.out.print("Enter deposit amount: ");
            double dep = sc.nextDouble();
            acc.deposit(dep);

            System.out.print("Enter withdrawal amount: ");
            double wd = sc.nextDouble();

            try {
                acc.withdraw(wd);
            } catch (LessBalanceException e) {
                System.out.println(e.getMessage());
            }

            acc.display();

            // Demonstrating ArithmeticException
            System.out.println("\nDemonstrating ArithmeticException:");
            int a = 10, b = 0;
            int result = a / b;  // will cause exception
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
        }

        sc.close();
    }
}