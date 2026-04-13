import javax.swing.JOptionPane;

public class CheckingAccount extends BankAccount {
    // DO NOT CHANGE ANY VARIABLE, METHOD, OR CLASS NAMES. THE AUTOGRADER DEPENDS ON
    // THEM.
    private final double OVERDRAFT_FEE = 35.00;

    public CheckingAccount(String accountHolder, double initialDeposit) {
        // TODO: Call the parent constructor using 'super'
        super(accountHolder, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        // TODO: Implement Checking withdrawal logic
        if (amount > getBalance()) {
            this.setBalance(getBalance() - amount - OVERDRAFT_FEE);
            System.out.println("Overdraft! $35.00 fee.");
            JOptionPane.showMessageDialog(null, "Overdraft! $35.00 fee. New balance: " + this.getBalance(),
                    "Overdraft Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            this.setBalance(getBalance() - amount);
        }
    }
}