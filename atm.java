import java.util.Scanner;

public class atm {
    private double balance;
    private Scanner scanner;

    public atm(double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            showMenu();
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // clear invalid input from scanner
                choice = 0; // reset choice to continue the loop
            }
        } while (choice != 4);
        scanner.close(); // close the scanner when done
    }

    private void showMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void checkBalance() {
        System.out.println("Your balance: ₹" + balance);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit (₹): ");
        double amount = getValidAmount();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw (₹): ");
        double amount = getValidAmount();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance. Withdrawal failed.");
        }
    }

    private double getValidAmount() {
        while (true) {
            try {
                double amount = scanner.nextDouble();
                return amount;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.next(); // clear invalid input from scanner
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double initialBalance = 0;
        boolean validInput = false;

        // Loop to get a valid initial balance
        do {
            try {
                System.out.print("Enter initial balance (₹): ");
                initialBalance = sc.nextDouble();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // clear invalid input from scanner
            }
        } while (!validInput);

        atm atm = new atm(initialBalance);
        atm.displayMenu();
    }
}
