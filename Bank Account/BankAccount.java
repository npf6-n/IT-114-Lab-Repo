public abstract class BankAccount {
    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON
    // THEM.
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialDeposit) {
        // TODO: Initialize the instance variables
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        // TODO: Implement deposit logic
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. No changes made");
        } else {
            this.balance += amount;
            System.out.println("New Balance: " + this.balance);
        }

    }

    /**
     * Abstract method: Child classes must implement this.
     */
    public abstract void withdraw(double amount);

    // --- GETTERS AND SETTERS ---

    public String getAccountHolder() {
        // TODO: Return the account holder name
        return this.accountHolder; // Placeholder
    }

    public double getBalance() {
        // TODO: Return the current balance
        return this.balance; // Placeholder
    }

    protected void setBalance(double balance) {
        // TODO: Set the balance
        this.balance = balance;
    }
}