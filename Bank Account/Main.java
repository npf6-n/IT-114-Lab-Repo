import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: Create a Scanner to read
        Scanner scanner = new Scanner(System.in);

        // TODO: Ask for User Name and Initial Deposit
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();

        BankAccount account;
        // TODO: Ask user to select Checking or Savings
        System.out.println("What type of account would you like to open? Type 1 or 2:");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        int accountType = scanner.nextInt();

        // TODO: Instantiate the correct account type based on input
        if (accountType == 1) {
            account = new CheckingAccount(name, initialDeposit);
        } else {
            account = new SavingsAccount(name, initialDeposit);
        }

        // TODO: Create a loop (while) that displays a menu:
        // 1. Deposit
        // 2. Withdraw
        // 3. Check Balance
        // 4. Exit

        while (true) {
            System.out.println("Select an option:  1-Deposit, 2-Withdraw, 3-Check Balance, 4-Exit");
            int operationNum = scanner.nextInt();

            if (operationNum == 4) {
                System.out.println("Exiting...");
                break;
            }

            if (operationNum == 3) {
                System.out.println("Current Balance: " + account.getBalance());
            }

            if (operationNum == 2) {
                System.out.println("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                account.withdraw(amount);
            }

            if (operationNum == 1) {
                System.out.println("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                account.deposit(amount);
                System.out.println("Deposited: " + amount);

            }

        }
        scanner.close();
    }
}